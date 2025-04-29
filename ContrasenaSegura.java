import java.util.Scanner; // importamos la clase scanner para leer entrada del usuario

public class ContrasenaSegura { // creamos la clase principal del programa

    // abrimos un metodo para verificar si la contraseña cumple con los requisitos de seguridad que planteamos
    public static boolean esContrasenaSegura(String contrasena) {
        // empezamos verificando si la longitud de la contraseña es menor a 10 caracteres
        if (contrasena.length() < 10) {
            return false; // si es menor a 10, no cumple como segura
        }

        // generamos variables para controlar si hay al menos una letra, un número y un símbolo
        boolean tieneLetra = false;
        boolean tieneDigito = false;
        boolean tieneSimbolo = false;

        // recorremos cada caracter de la contraseña
        for (char c : contrasena.toCharArray()) {
            if (Character.isLetter(c)) { // si el caracter es una letra
                tieneLetra = true;
            } else if (Character.isDigit(c)) { // si el caracter es un dígito
                tieneDigito = true;
            } else { // si no es ni letra ni dígito, entonces se asume que es un símbolo
                tieneSimbolo = true;
            }
        }

        // se devuelve true solo si se cumplen las tres condiciones
        return tieneLetra && tieneDigito && tieneSimbolo;
    }

    // este sera el método principal que se ejecuta al iniciar el programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // creamos un Scanner para leer desde consola
        String contrasena; // una variable para almacenar la contraseña ingresada

        // abrimos un bucle que se repetirá hasta que el usuario ingrese una contraseña segura
        do {
            System.out.print("Ingresa una contraseña segura: "); // pedimos al usuario la contraseña
            contrasena = scanner.nextLine(); // leemos la contraseña ingresada

            // verificamos si la contraseña no es segura
            if (!esContrasenaSegura(contrasena)) {
                // si no es segura, presentamos un mensaje explicando los requisitos
                System.out.println("La contraseña NO es segura. Debe tener al menos 10 caracteres, una letra, un número y un símbolo.");
            }

        } while (!esContrasenaSegura(contrasena)); // continua con el bucle mientras la contraseña sea insegura

        // cuando se ingresa una contraseña segura
        System.out.println("¡Contraseña segura registrada con éxito!");

        scanner.close(); // cerramos el scanner para liberar recursos
    }
}