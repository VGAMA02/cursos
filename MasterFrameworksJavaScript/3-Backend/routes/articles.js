'use strict'
/* llamar dependencias para enrutamiento */
var express = require('express');
var ArticleController = require('../controlers/article');
var router = express.Router();
var multipart = require('connect-multiparty');
//el metodo multiparte devuelve un midelware el cual se ejecuta antes de que llegue
//a ejecutarse el metodo que esta asignado a la ruta (como ArticleController.datosCurso por ejemplo) 
var md_upload = multipart({uploadDir: './upload/articles'}); //le estamos diciendo que guarde algo en esta carpeta
//rutas de prueba
router.post('/datos-curso', ArticleController.datosCurso);
router.get('/test-de-controlador', ArticleController.test);
///Rutas utiles y //rutas para articulos
router.post('/save', ArticleController.save);
//en las rutas el /: es una opcional que puede traer algun valor. el ? hace obligatorio un parametro
router.get('/articles/:last?', ArticleController.getArticles);
router.get('/article/:id', ArticleController.getArticle);
router.put('/article/:id', ArticleController.update);
router.delete('/article/:id', ArticleController.delete);
router.post('/upload-image/:id?', md_upload ,ArticleController.upload); //a esta ruta se le aplica un midelware
router.get('/get-image/:image', ArticleController.getImage);
router.get('/search/:search', ArticleController.search);
module.exports = router;
