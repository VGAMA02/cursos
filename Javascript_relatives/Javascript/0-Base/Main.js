//definicion de variables let las pone en un contexto limitado
//var las pone en un contexto global.
//NaN, significa not a number
//bacjtips alt 96 o ctrl + alt y }
//comentario rapido ctrl + }
let numero = 20, numero2 = 40, numero3;

numero3 = 650;

alert(numero3);
alert(numero3 * numero);

let nombre = prompt("Hola ¿que cuentas?");
alert(nombre);

//Concatenacion
document.open();
frase = "hola";
frase2 = "soy dalto";
frase3 = frase.concat(frase2);
frase4 = "soy" + frase2 + "y ando programando";
frase5 = `  ${frase2}  y ando programando`; 

document.write(frase5);

numberText = "20";
document.write(numero === numberText); //compara si es estrictamente igual, incluye tipo de dato.
document.write(numero !== numberText);