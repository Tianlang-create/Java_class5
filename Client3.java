import java.net.*;
import java.io.*;
import javax.swing.*;
class Client3 extends JFrame  implements Runnable{
	private BufferedReader br = null;
	private PrintStream ps = null;	
	public Client3() throws Exception{
		this.setSize(400,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		Socket s = new Socket("172.17.10.144",9999);
		ps = new PrintStream(s.getOutputStream());
		br = new BufferedReader(new InputStreamReader(s.getInputStream())); 
		String str = br.readLine();
		this.setTitle(str);
		new Thread(this).start();
	}	
	public void run() {
		while(true){
			try{
				String s = br.readLine();
				this.setTitle(s);
				}catch(Exception ex){}
		}
	}
	public static void main (String[] args)  throws Exception{	
		new Client3();
	}	
}