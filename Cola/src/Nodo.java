public class Nodo {
    Object dato; // Dato contenido.
    Nodo ns; // Nodo siguiente.

    @Override
    public String toString() {
        return "Nodo{" +
                "Dato: " + dato +
                ", Nodo siguiente: " + ns +
                '}';
    }
}
