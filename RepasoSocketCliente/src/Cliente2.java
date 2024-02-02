import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente2 {
	public static void main(String[] args) throws IOException {
		String servidor="localhost";
		int ip=2013;
		
		InetSocketAddress direccion=new InetSocketAddress(servidor,ip);
		
		try(Scanner sc=new Scanner(System.in);Socket socket=new Socket();){
			System.out.println("************Cliente*************");
			System.out.println("Introduce tres numeros: el ultimo 1 si sumar, dos si restar");
			String num1=sc.nextLine();
			String num2=sc.nextLine();
			String num3=sc.nextLine();
			String num4=num1+"-"+num2+"-"+num3;
			socket.connect(direccion);
			PrintStream salida=new PrintStream(socket.getOutputStream());
			salida.println(num4);
			
			
			InputStreamReader entrada=new InputStreamReader(socket.getInputStream());
			BufferedReader bf=new BufferedReader(entrada);
			String resultado=bf.readLine();
			System.out.println("El resultado es: ");
			System.out.println(resultado);
			
		}


}
}