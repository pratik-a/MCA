import java.net.*;
import java.io.*;
import java.util.Scanner;
class TCP_Client1{
	public static void main(String args[]) throws Exception{
		Socket s=new Socket(InetAddress.getLocalHost(),1234);
		DataOutputStream out;
		DataInputStream in;
		Scanner sc=new Scanner(System.in);
		String msg=null;
		while(true){
			System.out.println("Enter Your Message : ");
			msg=sc.nextLine();
			out=new DataOutputStream(s.getOutputStream());
			out.writeUTF(msg);
			if(msg.toUpperCase().equals("EXIT") || msg.toUpperCase().equals("BYE"))
				break;
			in=new DataInputStream(s.getInputStream());
			msg=in.readUTF();
			System.out.println("From Server : "+msg);
			if(msg.toUpperCase().equals("EXIT") || msg.toUpperCase().equals("BYE"))
				break;
		}
		s.close();
	}
}
