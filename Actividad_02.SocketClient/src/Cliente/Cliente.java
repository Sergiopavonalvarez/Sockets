package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	public static final int PUERTO = 2023;
	public static final String IP_SERVER = "localhost";

	public static void main(String[] args) throws IOException {
		System.out.println("        APLICACI�N CLIENTE         ");
		System.out.println("-----------------------------------");
		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);
		Scanner sc = new Scanner(System.in);
		Socket socketAlServidor = new Socket();

		System.out.println("CLIENTE: Esperando a que el servidor acepte la conexi�n");
		socketAlServidor.connect(direccionServidor);
		System.out.println("CLIENTE: Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO);

		while (true) {

			System.out.println("CLIENTE: Introduzca piedra papel o tijera");

			String mano = sc.nextLine();

			String operandos = mano;

			PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
			salida.println(operandos);
			InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
			BufferedReader bf = new BufferedReader(entrada);
			System.out.println("CLIENTE: Esperando al resultado del servidor...");
			String resultado = bf.readLine();
			System.out.println(resultado);

		}
	}

}
