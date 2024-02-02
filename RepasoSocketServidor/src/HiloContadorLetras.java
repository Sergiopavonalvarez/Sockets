import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class HiloContadorLetras implements Runnable {
	private Thread hilo;
	private Socket socket;
	private int numcliente=0;
	
	
	




	public HiloContadorLetras(Socket socket) {
		super();
		numcliente++;
		hilo = new Thread("Cliente "+numcliente);
		this.socket = socket;
		hilo.start();
	}







	@Override
	public void run() {
		InputStreamReader entrada=null;
		PrintStream salida=null;
		
	}
	

}
