import java.io.*;
import java.util.Scanner;

public class que3
{
	static int timeComp=0,spaceCmp=0;
	public static void main(String[] args)
	{
		int arr[]=new int[10],i,n;
		spaceCmp+=12*4;
		que3 obj=new que3();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter numbers of element in array : ");
		n=sc.nextInt();
		System.out.println("enter array : ");
		for(i=0;i<n;i++)
			{
				arr[i]=sc.nextInt();
				timeComp++;
			}
		obj.majority(arr, n);
		
		System.out.println("time Complexity : "+timeComp); 
		System.out.println("space Complexity : "+spaceCmp);
		sc.close();
	}

	public static void majority(int arr[] , int n)
	{
		int i,j,maj=0,count=0,max=0;
		spaceCmp+=5*4;
		for(i=0;i<n;i++) 
		{
			timeComp++;
			for(j=0;j<n;j++)
			{
				timeComp++;
				if(arr[i]==arr[j])
				{
					timeComp++;
					count++;
				}
				if(max<count)
				{
					timeComp++;
					max=count;
					maj=arr[i];
				}
			}
			count=0;
		}
		System.out.println("majority is : "+maj+" element : "+max);
	}
}