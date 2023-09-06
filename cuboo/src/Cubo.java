import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
public class Cubo {
    // Atributos
    int[][][] cubo; // Array de tres dimensiones
    Random rand = new Random(); //Random para crear las dimensiones del cubo.

    /*
     Metodos
     */

    /**
     * Se crea un cubo sin dimensiones de tamaño cero.
     */
    public Cubo() {
        this.cubo = new
                int[rand.nextInt(1,10)][rand.nextInt(1,10)][rand.nextInt(1,10)];
    }
    /**
     * Le asigna un valor numerico a cada espacio del cubo.
     */
    public void alea(){
        for(int i = 0; i < cubo.length; i++){ // Revisar las filas
            for(int j = 0; j < cubo[0].length; j++){ // Revisar las columnas
                for(int k = 0; k < cubo[0][0].length; k++){ //Revisar la profundidad
                    cubo[i][j][k] = rand.nextInt(0,10); // Asignar un valor aleatorio entero.
                }
            }
        }
    }

    /**
     * Se cargaran datos solo si es una posicion vacia.
     * @param x Largo
     * @param y Alto
     * @param z Profundidad
     * @param valor Valor que se quiere asignar.
     * @throws Exception En caso de usar erroneamente cargar, lanzara un error.
     */
    public void cargar(int x, int y, int z, int valor) throws Exception {
        if(cubo[x][y][z] == 0){
            cubo[x][y][z] = valor;
            System.out.println("Cargado!");
        } else{
            throw new Exception();
        }
    }

    /**
     *
     * @param x Largo
     * @param y Alto
     * @param z Profundidad
     * @param valor Valor que se quiere asignar
     * @throws Exception En caso de haber usado erroneamente modificar se lanza un error.
     */
    public void modificar(int x, int y, int z, int valor) throws Exception {
        if(valor != 0 && cubo[x][y][z] != 0){ // El valor no debe ser 0. En ese caso se usa asignar. Y si el valor guardado es 0, se deberia usar cargar.
            cubo[x][y][z] = valor;
            System.out.println("Modificado!");
        } else{
            throw new Exception();
        }
    }

    /**
     * Asigna el valor 0 a posiciones que no estan vacias.
     * @param x Largo
     * @param y Alto
     * @param z Profundidad
     * @throws Exception En caso de usar erroneamente anular, lanzara un error.
     */
    public void anular(int x, int y, int z) throws Exception {
        if(cubo[x][y][z] != 0){
            cubo[x][y][z] = 0;
            System.out.println("Anulado!");
        } else{
            throw new Exception();
        }
    }

    /**
     * Muestra las coordenadas de las posiciones vacias.
     */
    public void nulos(){
        int cont = 1; //Indice para las posiciones vacias que se mostraran.
        for(int i = 0; i < cubo.length; i++){
            for(int j = 0; j < cubo[0].length; j++){
                for(int k = 0; k < cubo[0][0].length; k++){
                    if(cubo[i][j][k] == 0){ // Si es una posicion vacia imprime sus coordenadas con su indice.
                        System.out.println(cont + ". (" + i + "," + j + "," + k + ").");
                        cont ++;
                    }
                }
            }
        }
    }

    /**
     * Suma cada dato de cada profundidad del cubo.
     * @return Devuelve una tabla con los resultados de cada profundidad sumados.
     */
    public int[] suma() {
        int[] tabla = new int[cubo[0][0].length]; // Se crea una tabla donde se iran guardando los resultados.
        int a; // Variable que guardara los resultados.
        int o = 0; // Indice para guardar los datos en la tabla.
        for (int k = 0; k < cubo[0][0].length; k++) {
            a = 0; // Se vuelve 0 para sumar los datos de esa profundidad y no mezclarlos.
            for (int[][] ints : cubo) {
                for (int j = 0; j < cubo[0].length; j++) {
                    a += ints[j][k]; // Se van sumando hasta recorrer los dos ciclos.
                }
            }
            tabla[o] = a;
            o++;
        }

        for(int i = 0; i < tabla.length; i++){
            System.out.println("Capa " + (i+1) + ": " + tabla[i]);
        }

        return tabla;

    }

    /**
     * Devuelve el valor segun la posicion buscada
     * @param x Ancho
     * @param y Largo
     * @param z Profundidad
     * @return Devuelve el valor numerico
     * @throws InputMismatchException En caso de superar alguna dimension lanzara este error.
     */
    public int valor(int x, int y, int z) throws InputMismatchException{
        if (cubo.length > x && cubo[0].length > y && cubo[0][0].length > z ) {
            return cubo[x][y][z];
        }else{
            throw new InputMismatchException();
        }
    }

    /**
     * @return Da la matriz tridimensional
     */
    public int[][][] getCubo() {
        return cubo;
    }

    @Override
    public String toString() {
        return "Cubo{" +
                "cubo=" + Arrays.toString(cubo) +
                '}';
    }
    public void imprimir(){
        for(int i = 0; i < cubo.length; i++){ // Revisar las filas
            for(int j = 0; j < cubo[0].length; j++){ // Revisar las columnas
                for(int k = 0; k < cubo[0][0].length; k++){ //Revisar la profundidad
                    cubo[i][j][k] = rand.nextInt(); // Asignar un valor aleatorio entero.
                }
            }
        }
    }
}