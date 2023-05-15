alert("hola mundo!");
var nombre = "Brandon";
var altura = 195;
var concatenacion = nombre +" "+altura;
//encontrar un elemento
var datos = document.getElementById("datos");
//añade un elemento html
//datos.innerHTML = concatenacion;
//usando comillas especiales
//innerHTML eliminara todo si se asigna = para añadir cosas se usa +=

//var y let son para declarar variables la diferencia es el "alcance" de la variable
datos.innerHTML = `
    <h1>Soy la caja de datos</h1>
    <h2>Mi nombre es: ${nombre}</h2>
    <h3>Mido ${altura}</h3>
`;

if(altura >= 190)
{
    datos.innerHTML += `<h1>Eres una persona alta</h1>`;
}
else
{
    datos.innerHTML += `<h1>Eres una persona  no tan alta</h1>`;
}

for (var index = 2015; index <= 2020; index++) {
    datos.innerHTML += "<h2>Estamos en el año " + index  +" </h2>"; 
}

function MuestraMiNombre(nombre2,altura2)
{
    var misdatos = `
    <h1>Soy la caja de datos</h1>
    <h2>Mi nombre es: ${nombre2}</h2>
    <h3>Mido ${altura2}</h3>
`;

    return misdatos;
}

function imprimir()
{
    var datos2 = document.getElementById("datos");
    datos2.innerHTML += MuestraMiNombre("brandon",180);
}

imprimir();

var nombres = ['victor','antonio','julian'];

alert(nombres[0]);
document.write("<h1>Listado de nombres</h1>");
/*
for (var index = 0; index < nombres.length; index++) {
    document.write(nombres[index] + "<br>");
}
*/
nombres.forEach((dat) => {
    document.write(dat + "<br>");
});

//objectos literales, json.
var coche = {
    modelo: "Mercedes Clase A",
    maxima: 500,
    antiguedad: 2020,
    mostrarDatos()
    {
        console.log(this.modelo,this.maxima,this.antiguedad);
    },
    propiedad1: "eeeeh"
};

document.write("<h1>"+coche.modelo+"</h1>");
coche.mostrarDatos();
console.log(coche);

//Promesas 
//la promesa espera que llegue una respuesta o un error dicho 
//resultado se saca de manera asynchrona. 
var saludar = new Promise((resolve,reject) => {
    setTimeout(() =>{
        let saludo = "Hola muy buenas a todos estoy muriendo :3";
        saludo = false;
        if(saludo)
        {
            resolve(saludo);
        }else
        {
            reject("no hay saludo");
        }
    },2000);
});
//then es cuando se produce el resultado en si
saludar.then(resultado => {
    alert(resultado);
})
.catch(err => {
    alert(err);
})