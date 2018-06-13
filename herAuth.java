import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class herAuth {
	public static void main(String argv[]) throws Exception
	{
		String[][] database = new String[100][100];
		DatagramSocket serverSocket = new DatagramSocket(4567);
	
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		
		serverSocket.receive(receivePacket);
		String link = new String(receivePacket.getData());
		
		InetAddress IPAddress = receivePacket.getAddress();
		String IP = new String("127.0.0.1");
		sendData = IP.getBytes();
		
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2229);
		
		serverSocket.send(sendPacket);
	}

}
