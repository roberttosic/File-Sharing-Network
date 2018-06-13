import java.io.*;
import java.net.*;

public class hisServer {
	
	public static void main(String argv[]) throws Exception
	{
			File index;
			byte[] b;

			index = new File("index.txt");
			ServerSocket welcomeSocket = new ServerSocket(9998);
			System.out.println("Waiting for connection.");

				Socket connectionSocket = welcomeSocket.accept();
				System.out.println("Connected!");
				
				InputStream in = new FileInputStream(index);
				OutputStream out = connectionSocket.getOutputStream();

				b = new byte [1024];
				int length = 0;
				while((length = in.read(b)) != -1){
					out.write(b,0,length);
				}

				out.close();
				in.close();
				welcomeSocket.close();
				connectionSocket.close();
 
	} 
}
