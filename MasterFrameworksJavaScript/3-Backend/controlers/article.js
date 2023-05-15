/*rutas y metodos relacionadas con articulos*/
'use strict'
var validator = require('validator') //importar validator
var Article = require('../models/article');
var fs = require('fs'); //libreria para eliminar imagenes
var path = require('path'); //modulo que saca la ruta de un archivo
const { param } = require('../routes/articles');
const { exists } = require('../models/article');
/*objecto control json con funcion anonima
  basicamente es un objecto con varias funciones
*/
var controller = {
    datosCurso: (req, res) => {
        var hola = req.body.hola;
        //siempre se debe devolver algo
        return res.status(200).send({
            curso: 'Master en frameworks',
            autor: 'gama',
            url: 'https://www.twitch.tv/vgama02',
            hola 
        });
    },

    test: (req, res) => {
        return res.status(200).send({
            message: 'soy la accion test de mi controlador de mi articulo'
        });
    },

    save: (req, res) => {
        //se mandan los datos desde el "postman" que es un porgrama colocar el metodo post en la parte de body por medio de x-www-form-urlencoded 
        //recoger parametros por post
        var params = req.body //req es lo que obtiene la funcion en si desde el parametro post, lo que le manda la persona
        console.log(params);
        //validad datos (con libreria validator)
        try{
            //usamos validatos viendo si el titulo y el contenido no estan vacios
            var validate_title = !validator.isEmpty(params.title);
            var validate_content = !validator.isEmpty(params.content);
        }catch(err){
            return res.status(200).send({
                status: 'error',
                message: 'Faltan datos por eroor!!!' //article es una propiedad propia de la funcion, creada aqui y sirve para almacenar lo que hay en params
              });
        }
        //comprobar validacion
        if(validate_title && validate_content){
             //crear el objecto a guardar
            var article = new Article();
            //asignar valores 
            article.title = params.title;
            article.content = params.content;
            if(params.image){
                article.image = params.image;
            }
            else{
                article.image = null;
            }
            
            //Guardar el articulo
            article.save((err, articleStored) =>{
                if(err || !articleStored){
                    return res.status(404).send({
                        status:'error',
                        message: 'el articulo no se ha guardado'
                     });
                }
                //Devolver una respuesta
                return res.status(200).send({
                status:'success',
                article: articleStored
                });
            });
        }
        else
        {
            return res.status(200).send({
                status: 'error',
                message: 'Los datos no son correctos!!!' //article es una propiedad propia de la funcion, creada aqui y sirve para almacenar lo que hay en params
              });
        }
    },

    getArticles: (req, res) => {
        var last = req.params.last;
        var query = Article.find({})
        //limitar la cantidad de articulos vistos
        if(last || last != undefined){
            query.limit(5);
        }
        //find encontrar articulos de la base de datos
        //sort sirve para ordenar los datos " - " es necesario poner " _ " despues de eso,  invierte el orden
        query.sort('-_id').exec((err,articles) =>{
            if(err){
                return res.status(500).send({
                    status: 'error',
                    message: "error al devolver los datos!!!"
                  });
            }

            if(!articles){
                return res.status(404).send({
                    status: 'error',
                    message: "no hay articulos para mostrar"
                  });
            }
            return res.status(200).send({
                status: 'success',
                articles
              });
        }) //vacio se saca todo    
    },

    getArticle: (req,res) =>{
        //Recoger el id de la url
        var articleId = req.params.id;
        //comprobar que existe
        if(!articleId || articleId == null){
            return res.status(404).send({
                status: 'error',
                message: "No existe el articulo !!!"
              });
        }
        //buscar el articulo
        Article.findById(articleId, (err, article) =>{
            if(!article || err ){
                return res.status(404).send({
                    status: 'error',
                    message: "No existe el articulo !!!"
                  });
            }
            //devolver en json
            return res.status(200).send({
                status: 'success',
                article
              });
        })  
    }, //getArticle
    
    update: (req,res) => {
        //recoger el id del articulo por la url
        var articleId = req.params.id;
        //recoger los datos que llegan por put
        var params = req.body;
        //validar los datos
        try{
            var validate_title = !validator.isEmpty(params.title);
            var validate_content = !validator.isEmpty(params.content);
        }catch(err)
        {
            return res.status(404).send({
                status: 'error',
                message: "Faltan datos por enviar"
              });
        }

        if(validate_title && validate_content)
        {
             //hacer un find y update                         // el new es para devolver el objecto que estoy actualizando actualizado, no antes de.
            Article.findOneAndUpdate({_id: articleId}, params,{new:true},(err, articleUpdate) => {
                if(err){
                    return res.status(404).send({
                        status: 'error',
                        message: "error al actualizar"
                      });
                }
                //article update es lo que devolvio como tal la funcion
                if(!articleUpdate){
                    return res.status(404).send({
                        status: 'error',
                        message: "No existe el articulo !!!"
                      });
                }


                return res.status(200).send({
                    status: 'success',
                    article: articleUpdate
                });
            });

            
        }
        else{
            return res.status(200).send({
                status: 'error',
                message: "La validacion no es correcta !!!"
            });
        }      
    },

    delete: (req, res) => {
        //recoger el id de la la url
        var articleId = req.params.id;
        //Find and delete
        Article.findOneAndDelete({_id: articleId}, (err,articleRemoved) =>{
            if(err){
                return res.status(500).send({
                    status: 'error',
                    message: "error al borrar"
                });
            }
            if(!articleRemoved)
            {
                return res.status(404).send({
                    status: 'error',
                    message: "no se ha borrado el articulo posiblemente no exista"
                }); 
            }

            return res.status(200).send({
                status:'success',
                article: articleRemoved
            });
        });
    },

    upload: (req,res) =>{
        ///IMPORTANTE!
        //Es necesario llamar a la llave de envio file0

        //configurar el mdulo del connect multiparty que se hace en el router en este caso router/article.js, ( listo )

        //Recoger el fichero de la peticion
        var file_name = 'Imagen no subida...';
        if(!req.files){ //verificar si, si llego el fichero
            return res.status(404).send({
                status: 'error',
                message: file_name
            }); 
        }
        //Conseguir el nombre y la extension del artchivo
        var file_path = req.files.file0.path; //el path tiene varias parte, la ruta, el nombre
        var file_split = file_path.split('\\'); 

        // * ADVERTENCIA * EN LINUX O MAC
        // var file_split = file_path.split('/');   ↑↑↑

        //Nombre del archivo
        var file_name = file_split[2];
        //Extension del fichero
        var extension_split = file_name.split('\.');
        var file_ext = extension_split[1];
        //Comprobar la extension, solo imagenes, si es valida borrar el fichero
        if(file_ext != 'png' && file_ext != 'jpg' && file_ext != 'jpeg' && file_ext != 'gif')
        {
            //borrar el archivo subido
            fs.unlink(file_path,(err) =>{
                return res.status(200).send({
                    status: 'error',
                    message: 'La extension de la imagen no es valida'
                }); 
            });
        }
        else{
            //si todo es valido, sacar el id de la url
            var articleId = req.params.id;

            if(articleId){
                //Buscar articulo, asignaerle el nombre de la imagen y actualizarlo
                //le indicamos el primer paramatro cual es el articulo que busca y en el segundo que va a actualziar
                Article.findOneAndUpdate({_id: articleId},{image:file_name},{new:true},(err,articleUpdate) => {
                    if(err || !articleUpdate)
                    {
                        return res.status(404).send({
                            status: 'error',
                            Message: 'Error al actualizar los datos'
                        });   
                    }
                    return res.status(200).send({
                        status: 'success',
                        article: articleUpdate
                    });
                });
                //retorno
            }else{
                return res.status(200).send({
                    status: 'success',
                    image: file_name
                });
            }
          
            
        }
    },
    getImage: (req, res) => {
        var file = req.params.image;
        var path_file = './upload/articles/' + file;
        //console.log(exists);
        fs.exists(path_file, (exists) =>{
            if(exists){
                return res.sendFile(path.resolve(path_file));
            }
            else{
                return res.status(404).send({
                    status: 'error',
                    message: 'la imagen no existe'
                });
            }

        });
       
    },

    search: (req,res) =>{
        //sacar el string a buscar
        var searchString = req.params.search;
        //find or
        //hacer condiciones
        Article.find({ "$or": [ //or esp para decirle que guarde los articulos que encuentre algo de lo que este la cadena ya sea en el titulo o en el contenido
            {"title": { "$regex": searchString, "$options": "i"}},
            {"content": { "$regex": searchString, "$options": "i"}}
           
        ]}) //importante no poner punto y coma aqui, esto hace que las ordenes se sigan... acumulando (?)
        .sort([['date','descending']]) //le decimos que el array que formo lo anterior sea ordenado por fecha decendientemente
        .exec((err,articles) =>{
            if(err){
                return res.status(500).send({
                    status: 'error',
                    message: 'error en la peticion !!!'
                });
            }
            
            if(!articles){
                return res.status(404).send({
                    status: 'error',
                    message: 'No hay articulos que considan con tu busqueda'
                });
            }
            
            return res.status(200).send({
                status: 'success',
                articles
            });
        });
       
    }



}; // end controller
module.exports = controller;
