import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteHilo {
	public static void main(String[] args) throws IOException {
		
	
	String servidor="localhosto";
	int ip=2013;
	InetSocketAddress direccion=new InetSocketAddress(servidor,ip);
	
	
	try(Scanner sc=new Scanner(System.in)){
		boolean continuar=true;
		Socket socket=new Socket();
		socket.connect(direccion);
		
		do {
			
		
		
		
		
		System.out.println("Introduce una palabra, FIN para acabar");
		String palabra="";
		palabra=sc.nextLine();
		PrintStream salida=new PrintStream(socket.getOutputStream());
		salida.println(palabra);
		InputStreamReader entrada=new InputStreamReader(socket.getInputStream());
		BufferedReader bf=new BufferedReader(entrada);
		String resultado=bf.readLine();
		System.out.println(resultado);
		if(resultado.equalsIgnoreCase("OK")) {
			continuar=false;
		}
		}while(continuar);
		socket.close();
			
		}
		
		
	}

}
