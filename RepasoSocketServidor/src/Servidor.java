import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		Socket socket=null;
		InputStreamReader entrada=null;
		PrintStream salida=null;
		int ip= 2013;
		System.out.println("        APLICACI�N CLIENTE         ");
		System.out.println("-----------------------------------");

		InetSocketAddress direccion=new InetSocketAddress(ip);
		
		try(ServerSocket serverSocket=new ServerSocket()){
			serverSocket.bind(direccion);
			socket=serverSocket.accept();
			entrada=new InputStreamReader(socket.getInputStream());
			BufferedReader bf=new BufferedReader(entrada);
			String recibido=bf.readLine();
			String []operadores=recibido.split("-");
			int numero1=Integer.parseInt(operadores[0]);
			int numero2=Integer.parseInt(operadores[1]);
			int numero3=Integer.parseInt(operadores[2]);
			int resultado=0;
			
			if (numero3==1) {
				 resultado=numero1-numero2;
			}else {
				resultado=numero1+numero2;
			}
			
			salida=new PrintStream(socket.getOutputStream());
			salida.println(resultado);

			
		}

	}

}
