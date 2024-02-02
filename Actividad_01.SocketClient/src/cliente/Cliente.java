package cliente;

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

	public static void main(String[] args) {
		System.out.println("        APLICACI�N CLIENTE         ");
		System.out.println("-----------------------------------");
		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);
		try (Scanner sc = new Scanner(System.in); Socket socketAlServidor = new Socket()) {
			System.out.println("CLIENTE: Introduzca los numeros tres numeros");
			System.out.println("+     ------->    1");
			System.out.println("-     ------->    2");
			System.out.println("*     ------->    3");
			System.out.println("/     ------->    4");
			System.out.println("Salir ------->    5");
			String numero1 = sc.nextLine();
			String numero2 = sc.nextLine();
			String numero3 = sc.nextLine();
			String operandos = numero1 + "-" + numero2 + "-" + numero3;// 3-4
			System.out.println("CLIENTE: Esperando a que el servidor acepte la conexi�n");
			socketAlServidor.connect(direccionServidor);
			System.out.println("CLIENTE: Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO);
			PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
			salida.println(operandos);// 3-4
			InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
			BufferedReader bf = new BufferedReader(entrada);
			System.out.println("CLIENTE: Esperando al resultado del servidor...");
			String resultado = bf.readLine();
			System.out.println("CLIENTE: El resultado de la operacion es: " + resultado);// 7
		} catch (UnknownHostException e) {
			System.err.println("CLIENTE: No encuentro el servidor en la dirección" + IP_SERVER);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("CLIENTE: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
		}
		System.out.println("CLIENTE: Fin del programa");
	}
}