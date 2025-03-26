import java.util.Scanner; //Importamos la clase scanner para la entrada del dato

public class Main {
    public static void main(String[] args) {
        //creamos un objeto scanner para tomar la entrada del usuario desde la terminal
        Scanner entrada = new Scanner(System.in);
        //llamamos al método obtenerMedidaValida para solicitar al usuario una medida en metros
        double metros = obtenerMedidaValida(entrada);

        //hacemos la conversiin de la medida ingresada a todas las unidades de longitud
        double pies = metros * 3.28084;      //metros a pies
        double pulgadas = metros * 39.3701; //metros a pulgadas
        double centimetros = metros * 100;  //metros a centímetros
        //mostramos en la terminal la medida ingresada y todas las longitudes
        System.out.println("La medida ingresada es: " + metros + " Metros"); //usamos los "+" para combinar la informacion en la salida
        System.out.println("La conversión a Pies es: " + pies);
        System.out.println("La conversión a Pulgadas es: " + pulgadas);
        System.out.println("La conversión a Centrimetros es: " + centimetros);

        //por ultimo cerramos el scanner
        entrada.close();
    }

    //con esta funcion vamos a validar que el dato ingresado sea un numero valida, en este caso positivo, para llevar el proceso
    //si llega a ser un valor negativo o un caracter no se llevara el proceso    
    public static double obtenerMedidaValida(Scanner entrada) {
        double metros;
        while (true) { //abrimos un while que continuará ejecutandose hasta que se ingrese un numero positivo
            System.out.println("Ingrese medida que quiere convertir en metros:");

            //en este if se verifica si la entrada es un número de tipo double
            if (entrada.hasNextDouble()) {
                metros = entrada.nextDouble(); //tomamos el número ingresado
                // Verifica que el número sea mayor o igual a 0
                if (metros >= 0) {
                    return metros; //ya retornamos el valor válido para finalizar el proceso
                } else {
                    System.out.println("Error la medida no puede ser negativa.\n");
                }
            } else {
                System.out.println("Error solo debes ingresar numeros.\n");
                entrada.next(); //descartamos la entrada incorrecta para evitar un bucle infinito
            }
        }
    }
}
