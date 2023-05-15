import java.util.Stack;
public class PilasMedianteStack {

    public static void main(String[] args) {
      Stack pila = new Stack();
      pila.push(1);
      pila.add(2);
      pila.add(3);
      pila.add(4);
      pila.push(5);
      System.out.println("Tamaño de la pila:  " + pila.size());
      System.out.println("La cima es: " + pila.peek());
      System.out.println("Sacando a un elemento de la pila:  " + pila.pop());
      System.out.println("Sacando a un elemento de la pila:  " + pila.pop());
      System.out.println("Sacando a un elemento de la pila:  " + pila.pop());
      System.out.println("Tamaño de la pila:  " + pila.size());
      System.out.println("La pila esta vacia?:  " + pila.isEmpty());
    }
    
}
