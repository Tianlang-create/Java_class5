import java.net.*;
import java.io.*;
class Server1  {	
	public static void main (String[] args) throws Exception {	
		ServerSocket ss = new ServerSocket(9999);
		Socket s = ss.accept();
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		PrintStream ps = new PrintStream(os);
		ps.println("»¶Ó­Á¬½Ó");
		
	}	
}