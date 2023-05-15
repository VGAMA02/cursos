class Coche{

    constructor(modelo,velocidad,antiguedad){
        this.modelo = modelo;
        this.velocidad = velocidad;
        this.antiguedad = antiguedad;
    }

    aumentarVelocidad()
    {
        this.velocidad += 1;
    }
    reducirVelocidad()
    {
        this.velocidad -= 1;
    }
} 

var coche1 = new Coche("BMW",200,2017);
var coche2 = new Coche("Senda",150,2019);
var coche3 = new Coche("Centra",350,2021);
document.write("Velocidad: " + coche1.velocidad +"<br/>");
console.log(coche1);
coche1.aumentarVelocidad();
coche1.aumentarVelocidad();
coche1.aumentarVelocidad();
console.log(coche2);
console.log(coche3);
console.log(coche1);
document.write("Velocidad: " + coche1.velocidad +"<br/>");


class Autobus extends Coche{
    constructor(modelo,velocidad,antiguedad){
        super(modelo,velocidad,antiguedad);
        this.altura = 5;
    }
    mostrarAltura()
    {
        return "La altura es: " + this.altura;
    }
}

  

var autobus1 = new Autobus("Pegasus",205,2050);
document.write("Velocidad: " + autobus1.velocidad +"<br/>");
console.log(autobus1.mostrarAltura());