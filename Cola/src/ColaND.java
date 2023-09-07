import java.util.Scanner;

public class ColaND {
    Nodo first; //Primer nodo ingresado.
    Nodo last; //Ultimo nodo ingresado.
    static int cont = 0; //Contador que se usara para el tamaño.
    Scanner scan = new Scanner(System.in);

    /*
        Metodos.
     */
    public ColaND() {
        first = null;
        last = null;
    }

    /**
     * Si el primer nodo es nulo significa que no hay ningun nodo.
     * @return Devuelve true si esta vacia, false si tiene algo.
     */
    public boolean estaVacia(){
        return first == null;
    }

    /**
     * Se reemplazan el primer y ultimo nodo con nulos.
     */
    public void vaciar(){
        first = null;
        last = null;
        cont = 0;
    }

    /**
     * Devuelve el contador que ha estado sumando cada que se mete 1.
     * @return Devuelve el valor del contador.
     */
    public long largo(){
        return cont;
    }

    /**
     * Da el elemento al frente de la cola.
     * @return Primer nodo ingresado.
     */
    public Object verPrimero(){
        return first;
    }

    /**
     *
     * @return Ultimo nodo ingresado.
     */
    public Object verUltimo(){
        return last;
    }

    /**
     * Es para meter cualquier objeto en la cola.
     * @param o Ingresa un objeto cualquiera.
     */
    public void enfilar(Object o){
        Nodo n = new Nodo(); // Se crea un nodo y se le pregunta al usuario el valor del dato que contendra.
        n.dato = o;
        if (first == null){ // Si no hay ningun nodo ingresado el nuestro tomara ese puesto.
            n.ns = null; // Y como es el primero en entrar no seguira a ninguno.
            first = n;
        } else{
            n.ns = last; // Si hay nodos en la cola, el valor de nodo siguiente lo toma segun el ultimo que hay.
        }
        last = n; // Y luego reemplaza al ultimo consigo mismo.
        cont++; // Aumenta el contador al ingresar el nodo.
        System.out.println("Nodo enfilado.");
    }

    /**
     * Usado para sacar el nodo en el frente.
     */
    public void sacar(){
        Nodo search; // Se crea un nodo de busqueda.
        boolean track = false; // Y un booleano que se usara en un while.
        search = last; // Se toma el valor del ultimo nodo ingresado.
        while(!track){
            if(search.ns == first){ // Si el nodo siguiente es el primero se reemplazara su valor con el de search.
                System.out.println("Este es el primer nodo ingresado en la cola " + first); //Muestra el valor del primero en consola.
                search.ns = null; // Se le cambia el valor del nodo siguiente a uno nulo.
                first = search; // Y con esto lo saca de la cola al tomar el valor del nodo anterior.
                cont--; // Y se le restara un elemento al contador de la cola.
                track = true;
            } else if (first == last){
                System.out.println("Este es el primer nodo ingresado en la cola: " + first); //Muestra el valor del primero en consola.
                first = null;
                last = null;
                track = true;
            } else{
                search = search.ns; // En cambio si no son iguales. La busqueda tomara el valor del nodo siguiente y repetira.
            }
        }
        System.out.println("Sacado!");
    }
    public void imprimir(){
        Nodo n = last;
        String text = "";
        while(n != null){
            if (n.ns != null){
                text += n.dato + " --> ";
            } else {
                text += n.dato + "";
            }
            n = n.ns;
        }
        System.out.println("\n" + text + "\n");
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
                    imprimir();
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

}
