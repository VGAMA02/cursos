
import javax.swing.JOptionPane;

public class PilasMemoriaDinamica {

    public static void main(String[] args) {
        int opcion = 0, elemento = 0;
        Pila pila = new Pila();

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.Enpujar un elemento en la pila\n"
                        + "2.Sacar un elemento de la pila\n"
                        + "3.La pila esta vacia?\n"
                        + "4.Que elemento esta en la cima?\n"
                        + "5.Vaciar pila\n"
                        + "6.Tamaño de la pila?\n"
                        + "7.Salir\n",
                        "inicializando pila", JOptionPane.INFORMATION_MESSAGE));

                switch (opcion) {
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique el elemento a insertar",
                                "Insertando datos", JOptionPane.INFORMATION_MESSAGE));
                        pila.push(elemento);
                        break;
                    case 2:
                        if (!pila.vacia()) {
                            elemento = pila.pop();
                            JOptionPane.showMessageDialog(null, "El elemento eliminado es: " + elemento);
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila esta vacia", "oouh... no...", JOptionPane.INFORMATION_MESSAGE);
                        }

                        break;
                    case 3:
                        if (pila.vacia()) {
                            JOptionPane.showMessageDialog(null, "La pila esta vacia", "oouh... no...", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila NO esta vacia", ":D", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 4:
                        if (!pila.vacia()) {
                            elemento = pila.cima();
                            JOptionPane.showMessageDialog(null, "El elemento en la cima de la pila es: " + elemento);
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila esta vacia", "oouh... no...", JOptionPane.INFORMATION_MESSAGE);
                        }

                        break;
                    case 5:
                        if (!pila.vacia()) {
                           pila.Limpiar();
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila esta vacia", "oouh... no...", JOptionPane.INFORMATION_MESSAGE);
                        }

                        break;
                    case 6:
                        elemento = pila.tamanio();
                        JOptionPane.showMessageDialog(null, "El tamaño de la pila es " + elemento, "Its...", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 7:
                        JOptionPane.showMessageDialog(null, "Saliendo", "Bay", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion equivocada");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR " + e.getMessage());
            }

        } while (opcion != 7);
    }

}
