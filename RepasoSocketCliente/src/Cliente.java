import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {
		String direccion="localhost";
		int ip= 2013;
		
		System.out.println("        APLICACI�N CLIENTE         ");
		System.out.println("-----------------------------------");
		InetSocketAddress socketdireccion=new InetSocketAddress(direccion,ip);
		
		try(Scanner sc=new Scanner(System.in);Socket socket=new Socket()){
			System.out.println("Cliente, introduzca un dos numeros y a continuacion la opcion:");
			System.out.println("1 -------------> restar");
			System.out.println("2 -------------> sumar");
			String numero1=sc.nextLine();
			String numero2=sc.nextLine();
			String numero3=sc.nextLine();
			String enviar = numero1+"-"+numero2+"-"+numero3;
			socket.connect(socketdireccion);
			PrintStream salida=new PrintStream(socket.getOutputStream());
			InputStreamReader entrada=new InputStreamReader(socket.getInputStream());
			salida.println(enviar);
			BufferedReader bf=new BufferedReader(entrada);
			String resultado=bf.readLine();
			System.out.println("El resultado es: ");
			System.out.println(resultado);
			
			
		}
		

	}

}
