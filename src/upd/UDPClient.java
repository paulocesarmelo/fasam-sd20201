package upd;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class UDPClient {
	
	static String serverName = "localhost";
	static int serverPort = 6789;
	
	public static void main(String args[]) {
		
		DatagramSocket clientSockt = null;
		
		try {
			clientSockt = new DatagramSocket();
			
			String text = JOptionPane.showInputDialog("Digite uma mensagem: ");
			
			byte[] msg = text.getBytes();
			
			InetAddress serverIP = InetAddress.getByName(serverName);
			
			System.out.println("Generating datagram...");
			
			DatagramPacket request = new DatagramPacket(msg, msg.length, serverIP, serverPort);
			
			clientSockt.send(request);
			
			System.out.println("Datagram sent!");
			
			//implementar comportamento similar ao do servidor
			
			byte[] buffer = new byte[1024];
			
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			
			clientSockt.receive(reply);
			
			System.out.println("Reply received: "+new String(reply.getData()));
			
		} catch (SocketException e) {
			System.out.println("Socket: "+e.getMessage());
		}catch (UnknownHostException e) {
			System.out.println("Host: "+e.getMessage());
		}catch (IOException e) {
			System.out.println("IO: "+e.getMessage());
		}finally {
			
			if(clientSockt != null)
				clientSockt.close();
		}
		
		
	}

}
