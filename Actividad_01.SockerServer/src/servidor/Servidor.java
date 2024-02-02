package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static final int PUERTO = 2023;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("      APLICACI�N DE SERVIDOR      ");
		System.out.println("----------------------------------");
		InputStreamReader entrada = null;
		PrintStream salida = null;
		Socket socketAlCliente = null;
		InetSocketAddress direccion = new InetSocketAddress(PUERTO);
		try (ServerSocket serverSocket = new ServerSocket()) {
			serverSocket.bind(direccion);
			int peticion = 0;
			while (true) {

				System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO);
				socketAlCliente = serverSocket.accept();
				System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");
				entrada = new InputStreamReader(socketAlCliente.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);
				String stringRecibido = bf.readLine();
				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);
				String[] operadores = stringRecibido.split("-");
				int iNumero0 = Integer.parseInt(operadores[0]);// 3
				int iNumero1 = Integer.parseInt(operadores[1]);// 4
				int iNumero2 = Integer.parseInt(operadores[2]);
				int resultado = 0;
				switch (iNumero0) {

				case 1:
					resultado = iNumero1 + iNumero2;
					break;

				case 2:
					resultado = iNumero1 - iNumero2;
					break;

				case 3:
					resultado = iNumero1 * iNumero2;
					break;
				case 4:
					resultado = iNumero1 / iNumero2;
					break;
				case 5:
					socketAlCliente.close();

					break;

				}
				System.out.println("SERVIDOR: El calculo de los numeros es: " + resultado);
				salida = new PrintStream(socketAlCliente.getOutputStream());
				salida.println(resultado);
			}
		} catch (IOException e) {
			System.err.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVIDOR: Error -> " + e);
			e.printStackTrace();
		}
	}
}
