'use strict'

//cargar modulos de node para crear el servidor
var express = require('express');
//ejecutar express (http)
var app = express();

//cargar ficheros rutas
var article_routes = require('./routes/articles');
// middlewares (procesar datos antes de ejecutar la ruta)
app.use(express.urlencoded({extended:false})); //cargar el middleware
app.use(express.json()); //conbertir cualquier peticion a json

//cors (permitir peticiones desde el frontend)
//el cors es el acceso cruzado entre dominio, es necesario configurarlo para permitir las llamadas del fronted por lo general son peticiones ajax
// Configurar cabeceras y cors, esto es un midelware
app.use((req, res, next) => {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Headers', 'Authorization, X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Allow-Request-Method');
    res.header('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, DELETE');
    res.header('Allow', 'GET, POST, OPTIONS, PUT, DELETE');
    next();
});


//añadir prefijos a rutas
app.use('/api', article_routes); //use sirve para cargar rutas o middlewares

//ruta o metodo de prueba para el API
/*app.post('/probando', (req, res) => {
    var hola = req.body.hola;
    //siempre se debe devolver algo
    return res.status(200).send({
        curso: 'Master en frameworks',
        autor: 'gama',
        url: 'https://www.twitch.tv/vgama02',
        hola 
    });
});
*/

//exportar modulo (fichero actual)
module.exports = app;

