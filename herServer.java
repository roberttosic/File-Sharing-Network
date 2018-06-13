import java.io.*;
import java.net.*;

public class herServer {
	public static void main(String argv[]) throws Exception{
		File file1 = new File("sender.mp4");
		File file2 = new File("sender.mp4");
		File file3 = new File("sender.mp4");
		File file4 = new File("sender.mp4");
		File file5 = new File("sender.mp4");
		int length = 1024;
		
		ServerSocket welcomeSocket = new ServerSocket(6667);
		Socket socket = welcomeSocket.accept();
		System.out.println("Connected!");
		
		byte[] b = new byte[1024];
		InputStream in = new FileInputStream(file1);
		OutputStream out = socket.getOutputStream();
		
		int count = in.read(b, 0, length);
		while(count != -1){
			out.write(b,0,length);
			count = in.read(b,0,length);
		}
		in.close();
		out.close();
		socket.close();
	}

}
