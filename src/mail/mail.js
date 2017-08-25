#!/usr/bin/env node
const express = require('express')
const timestamp = require('time-stamp')
const shortid = require('shortid')
const jsonfile = require('jsonfile')
const bodyParser = require('body-parser')
const argv = require('yargs')
    .usage('Usage: -p [port]')
    .alias('p', 'port')
    .nargs('p', 1)
    .describe('p', 'The server port, defaults to 7778')
    .default('p', 7774)
    .help('h')
    .alias('h', 'help').argv

const PORT = argv.port

jsonfile.spaces = 4

const app = express()

app.set('json spaces', 4)

app.use(bodyParser.json())
app.use(bodyParser.urlencoded({
    extended: true
}))

const JSON_DB = 'mails_dump.json'

const mail = (from, to, text) => ({
    from,
    to,
    text,
    read: false,
})

const log = (message) => {
    console.log(`${timestamp('[YYYY/MM/DD HH:mm:ss]')} - ${message}`)
}

const mailsExample = () => ({
    [shortid.generate()]: mail('alberto', 'devid', 'ciao'),
    [shortid.generate()]: mail('devid', 'alberto', 'yo')
})

const initMails = () => {
    try {
        const { mails } = jsonfile.readFileSync(JSON_DB)
        return mails
    } catch (err) {
        return {}
    }
    
}

const saveDatabase = (mailsToSave) => {
    const err = jsonfile.writeFileSync(JSON_DB, { 'mails': mailsToSave })
    if (err) {
        console.log(err)
    }
}

let mails = initMails()

app.get('/:user', (req, res) => {
    const { user } = req.params
    const unread = req.query.unread === 'true'

    log(`GET from ${user}`)

    if (!user) {
        log('Undefined user')
        return res.status(400).json({error: 'Undefined user'})
    }
    
    let mailsIdsOfUser = Object.keys(mails).filter((key) => mails[key].to === user)
    
    if (unread) {
        mailsIdsOfUser = mailsIdsOfUser.filter((key) => !mails[key].read)
    }

    const mailsOfUser = mailsIdsOfUser.map((key) => mails[key])

    mailsIdsOfUser.forEach((key) => mails[key].read = true)

    return res.status(200).json({
        mails: mailsOfUser
    })
})

app.post('/:user', (req, res) => {
    const { from, text } = req.body
    const to = req.params.user

    if (!from || !text) {
        log('Undefined mail property')
        return res.status(400).json({error: 'Undefined user'})
    }

    const newMail = {
        [shortid.generate()]: mail(from, to, text)
    }

    mails = Object.assign(newMail, mails)

    return res.status(200).json({ error: '' })
})

app.get('*', (req, res) => {
    res.status(404).json({
        message: 'Not found'
    })
})

app.listen(PORT, () => {
    console.log(`\nDistance service listening on port ${PORT}`)
})

process.on('exit', () => saveDatabase(mails))

process.on ('uncaughtException', (err) => {
    console.dir (err, { depth: null });
    process.exit(1);
});

// Catch CTRL+C
process.on ('SIGINT', () => {
    process.exit(0);
});