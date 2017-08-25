#!/usr/bin/env node
const express = require('express')
const distance = require('google-distance-matrix')
const timestamp = require('time-stamp')
const argv = require('yargs')
    .usage('Usage: $0 -a [env | arg] [name] -p [port]')
    .example(
        'distance.js -a env MAPS_API_KEY',
        'Start the service getting the API key from MAPS_API_KEY environment variable'
    )
    .example(
        'distance.js -a arg dd90ka',
        'Start the service using dd90ka as the API key'
    )
    .alias('a', 'api')
    .nargs('a', 2)
    .describe('a', 'The Google Distance Matrix API key')
    .demandOption('a')
    .alias('p', 'port')
    .nargs('p', 1)
    .describe('p', 'The server port, defaults to 7778')
    .default('p', 7778)
    .help('h')
    .alias('h', 'help').argv

const MAPS_API_KEY =
    argv.api[0] === 'env' ? process.env[argv.api[1]] : argv.api[1]
const PORT = argv.port

const app = express()

app.set('json spaces', 4)

distance.key(MAPS_API_KEY)

const log = (message) => {
    console.log(`${timestamp('[YYYY/MM/DD HH:mm:ss]')} - ${message}`)
}

const response = (err, distance = 0, message = '') => ({
    message: err ? err : message,
    distance: distance
})

app.get('/', (req, res) => {
    const { from, to } = req.query

    log(`[Request] From: ${from}, To: ${to}`)

    if (!from) {
        log(`[Response] Missing [from] parameter`)
        return res.status(400).json(response('Missing [from] parameter'))
    }

    if (!to) {
        log(`[Response] Missing [to] parameter`)
        return res.status(400).json(response('Missing [to] parameter'))
    }

    distance.matrix([from], [to], (err, distances) => {
        if (err) {
            return res.status(400).json(response(err, ''))
        }
        if (!distances) {
            return res.status(400).json(response('no distance', ''))
        }
        if (distances.status == 'OK') {
            const origin = distances.origin_addresses[0]
            const destination = distances.destination_addresses[0]
            if (distances.rows[0].elements[0].status === 'OK') {
                const distance = distances.rows[0].elements[0].distance.value
                log(`[Response] Distance(m) from [${origin}] to [${destination}]`)
                return res
                    .status(200)
                    .json(
                        response(
                            '',
                            distance,
                            `Distance(m) from [${origin}] to [${destination}]`
                        )
                    )
            } else {
                log(`[Response] ${destination} is not reachable by land from ${origin}`)
                return res
                    .status(400)
                    .json(
                        response(
                            `${destination} is not reachable by land from ${origin}`,
                            ''
                        )
                    )
            }
        }
    })
})

app.get('*', (req, res) => {
    res.status(404).json({
        message: 'Not found'
    })
})

app.listen(PORT, () => {
    console.log(`\nDistance service listening on port ${PORT}`)
})
