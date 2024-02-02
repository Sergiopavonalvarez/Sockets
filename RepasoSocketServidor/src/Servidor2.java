import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor2 {


	public static void main(String[] args) throws IOException {
		int ip=2013;
		InputStreamReader entrada=null;
		PrintStream salida=null;
		Socket socket=null;
		InetSocketAddress direccion=new InetSocketAddress(ip);
		
		try(ServerSocket serversocket=new ServerSocket()){

			serversocket.bind(direccion);

			socket=serversocket.accept();
			entrada=new InputStreamReader(socket.getInputStream());
			BufferedReader bf=new BufferedReader(entrada);
			String operandoss=bf.readLine();
			String operandos[]=operandoss.split("-");
			int num1=Integer.parseInt(operandos[0]);
			int num2=Integer.parseInt(operandos[1]);
			int num3=Integer.parseInt(operandos[2]);
			int resultado=0;
			
			if (num3==1) {
				resultado=num1+num2;
				
				
			}else {
				resultado=num1-num2;
			}
			
			salida=new PrintStream(socket.getOutputStream());
			System.out.println(resultado);
			salida.println(resultado);
			
			
		}

			
			
			
			
		
		
		
		
		

	}

}
