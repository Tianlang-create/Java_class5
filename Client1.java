import java.net.*;
import java.io.*;
class Client1  {	
	public static void main (String[] args)  throws Exception{	
		Socket s = new Socket("172.17.10.144",9999);
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		BufferedReader br = 
			new BufferedReader(new InputStreamReader(is)); 
		String str = br.readLine();
		System.out.println(str);
	}	
}