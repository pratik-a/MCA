import java.io.*;
import java.util.Scanner;

public class que1
{
	static int timeComp=0,spaceCmp=0;
	public static void main(String[] args)
	{
		
		int num1,num2;
		spaceCmp+=2*4;
		//spaceCmp=sizeof(int);
		que1 obj=new que1();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter num1 : ");
		num1=sc.nextInt();
		
		System.out.println("enter num1 : ");
		num2=sc.nextInt();
		
		obj.lcm(num1,num2);
		obj.hcf(num1,num2);
		
		System.out.println("time Complexity : "+timeComp);
		System.out.println("space Complexity : "+spaceCmp);
		sc.close();
	}

	public static void lcm(int num1 , int num2)
	{
		int min,max,Lcm=1;
		spaceCmp+=3*4;
		min=num1<num2?num1:num2;
		max=num1>num2?num1:num2;
		
		if(max%min==0)
		{
			Lcm=max;
			timeComp++;
		}
		else if(Lcm==1)
		{
			Lcm=min*max;
			timeComp++;
		}
		System.out.println("lcm is "+Lcm);
	}
	
	public static void hcf(int num1 , int num2)
	{

		int i,min,Hcf=1;
		spaceCmp+=3*4;
		min=num1>num2?num1:num2;
		
		for(i=2;i<min;i++)
		{
			timeComp++;
			if(num1%i==0 && num2%i==0)
			{
				Hcf=i;
				timeComp++;
			}
		}
		
		System.out.println("hcf is "+Hcf);
	}
}