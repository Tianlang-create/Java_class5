import java.net.*;
import java.io.*;
import javax.swing.*;
class Server3 extends JFrame  {	
	private BufferedReader br = null;
	private PrintStream ps = null;	
	public Server3() throws Exception{
		this.setSize(300,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		ServerSocket ss = new ServerSocket(9999);
		Socket s = ss.accept();
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		ps = new PrintStream(s.getOutputStream());
		ps.println("欢迎连接");
		new ChatThread().start();
	}
	class ChatThread extends Thread{
		public void run(){
			while(true){				
				try{  Thread.sleep(1000);  }catch(Exception ex){}
				double r = Math.random();
				ps.println("随机数字：" + r);
			}
		}
	}
	
	
	
	public static void main (String[] args) throws Exception {	
		new Server3();
		
	}	
}