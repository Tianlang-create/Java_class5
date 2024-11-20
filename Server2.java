import java.net.*;
import java.io.*;
import javax.swing.*;
class Server2 extends JFrame  {	
	private BufferedReader br = null;
	private PrintStream ps = null;	
	public Server2() throws Exception{
		this.setSize(300,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		ServerSocket ss = new ServerSocket(9999);
		Socket s = ss.accept();
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		ps = new PrintStream(s.getOutputStream());
		ps.println("»¶Ó­Á¬½Ó");
	}
	public static void main (String[] args) throws Exception {	
		new Server2();
		
	}	
}