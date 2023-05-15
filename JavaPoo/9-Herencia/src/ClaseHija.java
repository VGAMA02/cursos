//Extends es una palabra reservada para hacer herencia de otra clase
//En este caso se esta heredando desde la clase padre.
import javax.swing.JOptionPane;


public class ClaseHija extends ClasePadre{
    //override sirve para duplicar una funcion heredada y cambiar el ocmportamiento
    @Override
    public void hacerGalletas()
    {
        JOptionPane.showMessageDialog(null,"Soy la clase hija y tambien hago galletas");
    }
}
