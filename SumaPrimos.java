import java.util.Scanner; //Llamamos al scanner para leer los datos que lleguen de la consola

public class SumaPrimos { //creamos la clase  principal

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //creamos un objeto scanner para leer la entrada del usuario que use el programa
        boolean repetir = true; //generamos una variable para verificar si se repite el programa

        while (repetir) { //abrimos un bucle con el fin de que no se repite mientras el usuario quiera
            int n = 0; //creamos otra variable donde se guarde el número ingresado

            //ahora otro bucle para validar que el número ingresado sea un entero positivo mayor que 1
            while (true) {
                try {
                    System.out.print("Ingrese un numero entero positivo mayor que 1: ");
                    n = Integer.parseInt(scanner.nextLine()); //se lee el dato y lo convierte a entero

                    if (n > 1) break; //generamos una condicion para verificar si el número es válido,luego sale del bucle
                    else System.out.println("El numero debe ser mayor que 1."); //definimos un mensaje por si el número no es válido
                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida, por favor ingrese un número entero positivo valido."); //llevamos un error por si se ingresa un formato incorrecto
                }
            }

            int suma = 0; //tenemos una variable para acumular la suma de primos
            StringBuilder primos = new StringBuilder(); //esta es la cadena para guardar la lista de primos encontrados

            //abrimos un bucle para encontrar todos los números primos menores o iguales a n
            for (int i = 2; i <= n; i++) {
                if (esPrimo(i)) { //verificamos que el número actual es primo
                    suma += i; //sumamos el número primo
                    primos.append(i).append(" "); //ya lo agregamos a la lista de primos
                }
            }

            //mostramos los resultados
            System.out.println("\nNumeros primos menores o iguales a " + n + ":");
            System.out.println(primos.toString().trim()); //imprimimos la lista de primos
            System.out.println("➕ Suma total: " + suma); //imprimimos la suma total de primos

            String respuesta;
            //ahora abrimos un bucle para validar si la respuesta del usuario al final es valida
            while (true) {
                System.out.print("\n¿Desea intentar con otro numero? (Si/No): ");
                respuesta = scanner.nextLine().trim().toLowerCase(); //se lee y pasa a ser minuscula la entrada 

                if (respuesta.equals("si") || respuesta.equals("si")) { //esta opcin si el usuario quiere repetir
                    repetir = true;
                    break; //rompemos el proceso
                } else if (respuesta.equals("no")) { //esta opción si el usuario no quiere continuar
                    repetir = false;
                    System.out.println("¡Gracias por usar el programa!");
                    break; //rompemos el proceso
                } else {
                    System.out.println("Respuesta no valida, por favor escriba 'Si' o 'No'."); //mensaje si la entrada es inválida
                }
            }
        }

        scanner.close(); //se cierra el scanner al final del programa
    }

    //esta función determina si es un número primo
    public static boolean esPrimo(int num) {
        if (num <= 1) return false; //los números menores o iguales a 1 no son primos
        if (num == 2) return true; //2 es primo
        if (num % 2 == 0) return false; //si es par y diferente a 2, no es primo

        //revisamos la divisibilidad solo hasta la raíz cuadrada del número, en pasos de 2, solo impares
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false; //si tiene algún divisor, no es primo
        }

        return true; //si no se encontró divisor, es primo
    }
}