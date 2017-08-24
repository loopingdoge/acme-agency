#!/usr/bin/env node
const express = require('express')
const timestamp = require('time-stamp')
const shortid = require('shortid')
const jsonfile = require('jsonfile')
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

const JSON_DB = 'mails.json'

const mail = (from, to, text) => ({
    id: shortid.generate(),
    from,
    to,
    text
})

const log = (message) => {
    console.log(`${timestamp('[YYYY/MM/DD HH:mm:ss]')} - ${message}`)
}

const initMails = () => {
    const { mails } = jsonfile.readFileSync(JSON_DB)
    return mails
}

const saveDatabase = (mailsToSave) => {
    const err = jsonfile.writeFileSync(JSON_DB, { 'mails': mailsToSave })
    if (err) {
        console.log(err)
    }
}

const mails = initMails()

app.get('/:user', (req, res) => {
    const { user } = req.params

    log(`GET from ${user}`)

    if (!user) {
        log('Undefined user')
        return res.status(400).json(response('Undefined user'))
    }

    const mailOfUser = mails.filter((mail) => mail.to === user)

    return res.status(200).json({
        mails: mailOfUser
    })
})

app.post('/:user', (req, res) => {

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