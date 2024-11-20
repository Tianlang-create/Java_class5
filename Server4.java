import java.net.*;
import java.io.*;
import javax.swing.*;
class Server4 extends JFrame implements Runnable {	
	private ServerSocket ss = null;
	public Server4() throws Exception{
		this.setSize(300,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);		
		ss = new ServerSocket(9999);
		new Thread(this).start();
	}
	public void run(){
		while(true){
			try{
				Socket s = ss.accept();			
				new ChatThread(s).start();
			}catch(Exception ex){}
		}
	}
	class ChatThread extends Thread{
		BufferedReader br = null;
		PrintStream ps = null;	
		ChatThread(Socket s) throws Exception{
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			ps = new PrintStream(s.getOutputStream());			
			ps.println("欢迎连接");
		}
		public void run(){
			while(true){				
				try{  Thread.sleep(1000);  }catch(Exception ex){}
				double r = Math.random();
				ps.println("随机数字：" + r);
			}
		}
	}
	
	
	
	public static void main (String[] args) throws Exception {	
		new Server4();
		
	}	
}