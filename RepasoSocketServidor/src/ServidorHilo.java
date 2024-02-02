import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorHilo {
	public static void main(String[] args) throws IOException {
		int ip=2013;
	
		
		InetSocketAddress direccion=new InetSocketAddress(ip);
		
		try(ServerSocket serversocket=new ServerSocket();){
			
			while(true) {
			serversocket.bind(direccion);
			Socket socket=serversocket.accept();
			
			new HiloContadorLetras(socket);
			}
		}
		

		
		
		
	}

}
