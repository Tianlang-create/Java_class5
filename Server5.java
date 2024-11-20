import java.net.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
class Server5 extends JFrame implements Runnable {	
	private ArrayList<ChatThread> al = new  ArrayList<ChatThread>();
	private ServerSocket ss = null;
	public Server5() throws Exception{
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
				ChatThread ct = new ChatThread(s);
				al.add(ct);
				ct.start();
			}catch(Exception ex){}
		}
	}
	class ChatThread extends Thread{
		BufferedReader br = null;
		PrintStream ps = null;	
		ChatThread(Socket s) throws Exception{
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			ps = new PrintStream(s.getOutputStream());			
			ps.println("»¶Ó­Á¬½Ó");
		}
		public void run(){
			while(true){				
				try{ 
						 String str = br.readLine();
						 for(ChatThread ct : al){
						 	ct.ps.println(str);
						 }					 
				 	}catch(Exception ex){}
			}
		}
	}
	
	
	
	public static void main (String[] args) throws Exception {	
		new Server5();
		
	}	
}