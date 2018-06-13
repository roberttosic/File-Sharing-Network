import java.io.*;
import java.net.*;


public class client {

	public static void main(String argv[]) throws Exception
	{
		Socket clientSocket = new Socket("127.0.0.1", 9998);
		InputStream in = clientSocket.getInputStream();
		OutputStream out = new FileOutputStream("placehere/index.txt");
		
		byte[] b;
		byte[] b2;
		
		b = new byte [1024];
		b2 = new byte [1024];
		int length = 0;
		while((length = in.read(b)) != -1){
			out.write(b,0,length);
		}
		
		String[] videoList = new String[100];
		String l = null;
		int counter = 0;
		BufferedReader reader = new BufferedReader(new FileReader("placehere/index.txt"));
		while((l = reader.readLine()) != null)
		{
			//System.out.println(counter + ": " + );
			videoList[counter] = l;
			counter++;
		}
		
		System.out.println("Which video do you want to download?");
		for(int i = 0; i<counter;i++)
		{
			System.out.println(i +". " + videoList[i]);
		}
		
		BufferedReader choose = new BufferedReader(new InputStreamReader(System.in));
		String choice = null;
		choice = choose.readLine();
		
		DatagramSocket clientSocket2 = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
		
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		
		sendData = videoList[Integer.valueOf(choice)].getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2229);
		
		clientSocket2.send(sendPacket);
		
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		
		clientSocket2.receive(receivePacket);
		
		
		int len = 1024;
		Socket clientSocket3 = new Socket("127.0.0.1", 6667);
		FileOutputStream outFile = new FileOutputStream("placehere/gotit.mp4");
		int count = clientSocket3.getInputStream().read(b2,0,len);
		
		while(count!= -1){
			outFile.write(b2, 0, count);
			count = clientSocket3.getInputStream().read(b2,0,len);
		}
		
		
			
		clientSocket.close();
		clientSocket2.close();
		out.close();
		in.close();
		
		
		}
}


