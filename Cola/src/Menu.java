import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    public Menu(){
        ColaLKL colaLKL = new ColaLKL();
        ColaND colaND = new ColaND();
        boolean est = false;
        while(!est){
            System.out.println("""
                    1. Cola LinkedList.
                    2. Cola Nodo.
                    3. Salir""");
            String ans = scan.nextLine();
            switch (ans){
                case "1" -> colaLKL.interfaz();
                case "2" -> colaND.interfaz();
                case "3" -> est = true;
                default -> System.out.println("No reconocido");
            }
            if (!est){
                System.out.println("Presione 'ENTER' para continuar.");
                scan.nextLine();
            }
        }
    }
}
