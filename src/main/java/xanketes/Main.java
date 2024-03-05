package xanketes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca un mensaje para encriptar: ");
        String mensaje = sc.nextLine();

        String mensajeEncriptado = Encriptacion.encriptar(mensaje);
        System.out.println("Mensaje encriptado: " + mensajeEncriptado);

        String mensajeDesencriptado = Encriptacion.desencriptar(mensajeEncriptado);
        System.out.println("Mensaje desencriptado: " + mensajeDesencriptado);


    }
}