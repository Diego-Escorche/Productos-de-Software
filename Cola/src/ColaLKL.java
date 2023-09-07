import java.util.LinkedList;
import java.util.Scanner;

public class ColaLKL {
    LinkedList<Object> cola;
    Scanner scan = new Scanner(System.in);

    /*
        Metodos.
     */
    public ColaLKL() {
        cola = new LinkedList<>();
    }

    /**
     * @return Devuelve true si esta vacia, false si tiene algo.
     */
    public boolean estaVacia(){
        return cola.isEmpty();
    }

    /**
     * Se usa el metodo clear para vaciar la lista.
     */
    public void vaciar(){
        cola.clear();
    }

    /**
     * @return Devuelve el valor con el metodo size.
     */
    public long largo(){
        return cola.size();
    }

    /**
     * Da el elemento al frente de la cola.
     * @return Primer elemento ingresado.
     */
    public Object verPrimero(){
        return cola.getFirst();
    }

    /**
     * @return Ultimo elemento ingresado.
     */
    public Object verUltimo(){
        return cola.getLast();
    }

    /**
     * Es para meter cualquier objeto en la cola.
     * @param o Ingresa un objeto cualquiera.
     */
    public void enfilar(Object o){
        cola.offer(o);
        System.out.println("Nodo enfilado.");
    }

    /**
     * Usado para sacar el nodo en el frente.
     */
    public void sacar(){
        System.out.println("El primer elemento era: " + cola.pollFirst());
        System.out.println("Sacado!");
    }
    public void interfaz(){
        boolean es = false;
        while (!es) {
            System.out.println("""
                    1. Ver si la cola esta vacia.
                    2. Vaciar la cola.
                    3. Ver que tan larga es la cola.
                    4. Ver primer nodo ingresado en la cola.
                    5. Ver el ultimo nodo ingresado en la cola.
                    6. Enfilar un nodo en la cola.
                    7. Sacar el primer nodo de la cola.
                    8. Imprimir la cola.
                    9. Salir.""");
            String ans = scan.nextLine();
            switch (ans){
                case "1":
                    if (estaVacia()){
                        System.out.println("La cola esta vacia.");
                    } else {
                        System.out.println("La cola no esta vacia.");
                    }
                    break;
                case "2":
                    vaciar();
                    System.out.println("Vaciado!");
                    break;
                case "3":
                    System.out.println("La cola tiene un largo de: " + largo());
                    break;
                case "4":
                    System.out.println("El primer nodo de la cola es: " + verPrimero());
                    break;
                case "5":
                    System.out.println("El ultimo nodo de la cola es: " + verUltimo());
                    break;
                case "6":
                    System.out.println("Inserte el valor que quiere ingresar en el nodo: ");
                    int a = Integer.parseInt(scan.nextLine());
                    enfilar(a);
                    break;
                case "7":
                    sacar();
                    break;
                case "8":
                    toString();
                    break;
                case "9":
                    es = true;
                    break;
                default:
                    System.out.println("No reconocido.");
            }
            if (!es){
                System.out.println("Presiona 'ENTER' para continuar.");
                scan.nextLine();
            }
        }
    }

    @Override
    public String toString() {
        return "ColaLKL{" +
                "Cola: " + cola +
                '}';
    }
}