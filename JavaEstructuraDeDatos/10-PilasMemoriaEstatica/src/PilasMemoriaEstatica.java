
import javax.swing.JOptionPane;

public class PilasMemoriaEstatica {

    public static void main(String[] args) {
        int opcion = 0, elemento, tamanio;

        try {

            tamanio = Integer.parseInt(JOptionPane.showInputDialog(null, "De que tamaño quieres la pila?",
                    "inicializando pila", JOptionPane.INFORMATION_MESSAGE));
            Pila pila = new Pila(tamanio);

            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.Enpujar un elemento en la pila\n"
                        + "2.Sacar un elemento de la pila\n"
                        + "3.La pila esta vacia?\n"
                        + "4.La pila esta llena?\n"
                        + "5.Que elemento esta en la cima?\n"
                        + "6.Vaciar pila\n"
                        + "7.Tamaño de la pila?\n"
                        + "8.Saliar\n",
                        "inicializando pila", JOptionPane.INFORMATION_MESSAGE));

                switch (opcion) {
                    case 1:
                        if (!pila.llena()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique el elemento a insertar",
                                    "Insertando datos", JOptionPane.INFORMATION_MESSAGE));
                            pila.push(elemento);
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila esta llena", "oouh... no...", JOptionPane.INFORMATION_MESSAGE);
                        }

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
                        if (pila.llena()) {
                            JOptionPane.showMessageDialog(null, "La pila esta llena", "oouh... no...", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila NO esta llena", ":D", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 5:
                        if (!pila.vacia()) {
                            elemento = pila.cimaPila();
                            JOptionPane.showMessageDialog(null, "El elemento en la cima de la pila es: " + elemento);
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila esta vacia", "oouh... no...", JOptionPane.INFORMATION_MESSAGE);
                        }

                        break;
                    case 6:
                        while (!pila.vacia()) {
                            pila.pop();
                        }
                        JOptionPane.showMessageDialog(null, "La pila esta vacia", "oouh... no...", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 7:

                        elemento = pila.tamanioPila();
                        JOptionPane.showMessageDialog(null, "El tamaño de la pila es " + elemento, "Its...", JOptionPane.INFORMATION_MESSAGE);

                        break;

                    case 8:
                        JOptionPane.showMessageDialog(null, "Saliendo", "Bay", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion equivocada");
                }

            } while (opcion != 8);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e.getMessage());
        }

    }

}
