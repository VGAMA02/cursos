/*conexion a base de datos entre otras weas*/
'use strict'
/*utilizando mongo db */
var mongoose = require('mongoose');
var app = require('./app');
var port = 3900;

//mongoose.set('useFindAndModify', false);
mongoose.Promise = global.Promise;
/*CONECTAR A MONGO*/
mongoose.connect('mongodb://localhost:27017/api_rest_blog', {useNewUrlParser: true})
    .then(()=> {
        console.log('La conexion a la base de datos se ha realizado bien!!!');
        //crear servidor y ponerme a escuchar peticiones.
        app.listen(port,() =>{
            console.log('Servidor corriendo en http://localhost:' + port);
        });
    })