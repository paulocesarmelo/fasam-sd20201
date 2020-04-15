package upd;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

	static int serverPort = 6789;
	
	public static void main(String args[]) {
		
		DatagramSocket serverSocket = null;
		
		try {
			serverSocket = new DatagramSocket(6789);
			
			byte[] buffer = new byte[1024];
			
			while(true) {
				
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				
				System.out.println("Server listening port: "+serverPort);
				
				serverSocket.receive(request);
				
				System.out.println("Request received: "+new String(request.getData()));
				
				System.out.println("Request processing...");
				
				processing();
				
				DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort());
				
				System.out.println("Generating response ...");
				
				serverSocket.send(reply);	
				
				System.out.println("Response sent!");
				
			}
			
		} catch (SocketException e) {
			System.out.println("Socket: "+e.getMessage());
		}catch (IOException e) {
			System.out.println("IO: "+e.getMessage());
		}finally {
			if(serverSocket != null)
				serverSocket.close();
		}
		
	}
	
	public static void processing() {
		
		int cont = 0;
		
		while(cont < 60) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
			cont++;
		}
		
	}
	
}
