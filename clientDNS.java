import java.io.*;
import java.net.*;

public class clientDNS {
	public static void main(String argv[]) throws Exception
	{
			String[][] database = new String[100][100];
			DatagramSocket serverSocket = new DatagramSocket(2229);
		
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			
			database[0][0] = "video.hiscinema.com";
			database[0][1] = "127.0.0.1";
		
			InetAddress IPAddress = null;
			String IP = null;
			serverSocket.receive(receivePacket);
			
			InetAddress returnAddress = receivePacket.getAddress();
			
			String link = new String(receivePacket.getData());
			
			if(link.contains("video.hiscinema.com"))
			{
				IPAddress = InetAddress.getByName("127.0.0.1");
				IP = "video.hiscinema.com";
			}
			sendData = IP.getBytes();
		
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 4567);
		
			
			serverSocket.send(sendPacket);
			
			byte[] receiveData2 = new byte[1024];
			byte[] sendData2 = new byte[1024];
			DatagramPacket receivePacket2 = new DatagramPacket(receiveData2, receiveData2.length);
			serverSocket.receive(receivePacket2);
			String herIP = new String(receivePacket2.getData());
			InetAddress IPAddress2 = IPAddress = InetAddress.getByName(herIP);
			
			DatagramPacket sendPacket2 = new DatagramPacket(sendData,sendData.length, IPAddress2, 4567);
			serverSocket.send(sendPacket2);
			
			byte[] receiveData3 = new byte[1024];
			byte[] sendData3 = new byte[1024];
			DatagramPacket receivePacket3 = new DatagramPacket(receiveData3, receiveData3.length);
			serverSocket.receive(receivePacket3);
			String contentIP = new String(receivePacket3.getData());
			sendData3 = contentIP.getBytes();
			DatagramPacket sendPacket3 = new DatagramPacket(sendData3,sendData3.length, returnAddress, 4567);
	}
}
