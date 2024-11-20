import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Client5 extends JFrame  implements Runnable,ActionListener{
	private JTextField jtf = new JTextField();
	private JTextArea jta = new JTextArea();	
	private BufferedReader br = null;
	private PrintStream ps = null;	
	String nickName = null;
	public Client5() throws Exception{
		this.add(jtf,BorderLayout.SOUTH);
		this.add(jta,BorderLayout.CENTER);
		jta.setBackground(Color.pink);		
		jtf.addActionListener(this);
		
		this.setSize(400,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		nickName = JOptionPane.showInputDialog(this," ‰»ÎÍ«≥∆");
		Socket s = new Socket("172.17.10.144",9999);
		ps = new PrintStream(s.getOutputStream());
		br = new BufferedReader(new InputStreamReader(s.getInputStream())); 
		String str = br.readLine();
		this.setTitle(str);
		new Thread(this).start();
	}	
	public void actionPerformed(ActionEvent e){
		ps.println(nickName + "Àµ:" + jtf.getText());
	}
	public void run() {
		while(true){
			try{
				String s = br.readLine();
				jta.append(s +"\n");
				}catch(Exception ex){}
		}
	}
	public static void main (String[] args)  throws Exception{	
		new Client5();
	}	
}