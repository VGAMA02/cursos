/*un modelo es una clase*/
'use strict'
/*guardamos moongose*/
var mongoose = require('mongoose');
/*llamando a Schema de la dependencia moongose*/
var Schema = mongoose.Schema;

/*crear modelo*/
var ArticleSchema = Schema({
    title: String,
    content: String,
    date: {type: Date, default: Date.now},
    image: String
});
/* guardar en cada archivo en la base de datos un archivo que tendra
la contrusccion articulo */
module.exports = mongoose.model('Article', ArticleSchema);
//Articles --> guarda documentos de este tipo y con estructura dentro de la coleccion
