import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    public Menu() throws Exception {
        Cubo cubo = new Cubo();
        cubo.alea();
        System.out.println("""
                Bienvenido.
                Su cubo ya ha sido creado.
                Y tiene las siguientes dimensiones:""");
        System.out.println("Ancho de: " + cubo.getCubo().length + "\n" + "Largo de: " + cubo.getCubo()[0].length + "\n" + "Y una profundidad de: " + cubo.getCubo()[0][0].length);
        System.out.println("Por favor recuerde que al ingresar un dato los rangos son los siguientes: ");
        System.out.println("Ancho: 0 a " + (cubo.getCubo().length-1) + "\n" + "Largo: 0 a " + (cubo.getCubo()[0].length-1) + "\n" + "Profundidad: 0 a " + (cubo.getCubo()[0][0].length-1));
        System.out.println("Que desea hacer a continuacion?");
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Asignarle nuevos numeros aleatorios.");
            System.out.println("2. Cargar un valor.");
            System.out.println("3. Modificar un valor.");
            System.out.println("4. Anular un valor.");
            System.out.println("5. Ver que posiciones se encuentran vacias.");
            System.out.println("6. Ver un valor dada una posicion.");
            System.out.println("7. Ver cuanto da la suma de cada profundidad del cubo.");
            System.out.println("8. Salir");

        String ans = scan.nextLine();

        switch (ans) {
            case "1":
                cubo.alea();
                System.out.println("Listo!");
                break;
            case "2":
                System.out.println("Ingrese la posicion y el valor a cargar:" + "\n" + "Ancho: ");
                int x = scan.nextInt();
                System.out.println("Largo: ");
                int y = scan.nextInt();
                System.out.println("Profundidad: ");
                int z = scan.nextInt();
                System.out.println("Valor a cargar: ");
                int a = scan.nextInt();
                scan.nextLine();
                cubo.cargar(x, y, z, a);
                break;
            case "3":
                System.out.println("Ingrese la posicion y el valor a modificar:" + "\n" + "Ancho: ");
                x = scan.nextInt();
                System.out.println("Largo: ");
                y = scan.nextInt();
                System.out.println("Profundidad: ");
                z = scan.nextInt();
                System.out.println("Valor a modificar: ");
                a = scan.nextInt();
                scan.nextLine();
                cubo.modificar(x, y, z, a);
                break;
            case "4":
                System.out.println("Ingrese la posicion del valor que se busca anular:" + "\n" + "Ancho: ");
                x = scan.nextInt();
                System.out.println("Largo: ");
                y = scan.nextInt();
                System.out.println("Profundidad: ");
                z = scan.nextInt();
                scan.nextLine();
                cubo.anular(x, y, z);
                break;
            case "5":
                cubo.nulos();
                break;
            case "6":
                System.out.println("Ingrese la posicion del valor que busca:" + "\n" + "Ancho: ");
                x = scan.nextInt();
                System.out.println("Largo: ");
                y = scan.nextInt();
                System.out.println("Profundidad: ");
                z = scan.nextInt();
                scan.nextLine();
                a = cubo.valor(x, y, z);
                System.out.println(a);
                break;
            case "7":
                int[] tabla = cubo.suma();
                break;
            case "8":
                System.out.println("Hasta la proxima");
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ans);
            }
            System.out.println("Presione 'ENTER' para continuar xfi");
            scan.nextLine();
        }
    }
}
