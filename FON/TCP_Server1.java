import java.io.*;
import java.net.*;
import java.util.Scanner;
class TCP_Server1{
	public static void main(String args[]) throws Exception{
		ServerSocket ss=new ServerSocket(1234);
		Socket s=ss.accept();
		DataOutputStream out;
		DataInputStream in;
		String msg=null;
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.print("From Client : ");
			in=new DataInputStream(s.getInputStream());
			msg=in.readUTF();
			System.out.println(msg);
			if(msg.toUpperCase().equals("EXIT") || msg.toUpperCase().equals("BYE"))
				break;
			System.out.print("Enter Message : ");
			out=new DataOutputStream(s.getOutputStream());
			msg=sc.nextLine();
			out.writeUTF(msg);
			if(msg.toUpperCase().equals("EXIT") || msg.toUpperCase().equals("BYE"))
				break;
		}
		s.close();
		ss.close();
	}
}
