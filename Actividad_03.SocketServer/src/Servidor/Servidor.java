package Servidor;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

//En este caso, vamos a abrir un hilo por cada peticion que haga el servidor
//para as� poder procesar varias peticiones simultaneas de diferentes clientes
public class Servidor {
	
	

	
	
	
	
	public static final int PUERTO = 2018;
	
	public static void main(String[] args) {
		
		
		ArrayList<Peliculas> peliculas = new ArrayList<>();;
		
		
		
		Peliculas uno=new Peliculas("01", "Malas Calles", "Martin Scorsese");
		Peliculas dos=new Peliculas("02", "Malas Calles", "Martin Scorsese");
		Peliculas tres=new Peliculas("03", "Malas Calles", "Martin Scorsese");
		Peliculas cuatro=new Peliculas("04", "Malas Calles", "Martin Scorsese");
		
		
		peliculas.add(uno);
		peliculas.add(dos);
		peliculas.add(tres);
		peliculas.add(cuatro);

		
		System.out.println("      APLICACI�N DE SERVIDOR CON HILOS     ");
		System.out.println("-------------------------------------------");	
		System.out.println(peliculas.toString());
		
		int peticion = 0;
		
		try (ServerSocket servidor = new ServerSocket()){			
			InetSocketAddress direccion = new InetSocketAddress(PUERTO);
			servidor.bind(direccion);

			System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO);
			
			while (true) {
				//Por cada peticion de cliente aceptada se me crea un objeto socket diferente
				Socket socketAlCliente = servidor.accept();
				System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");
				//Abrimos un hilo nuevo y liberamos el hilo principal para que pueda
				//recibir peticiones de otros clientes
				new HiloPeliculas(socketAlCliente);
			}			
		} catch (IOException e) {
			System.err.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVIDOR: Error");
			e.printStackTrace();
		}
	}
}
