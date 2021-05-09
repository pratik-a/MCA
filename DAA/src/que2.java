import java.io.*;
import java.util.Scanner;


public class que2
{
	static int timeComp=0,spaceCmp=0;
	public static void main(String[] args)
	{
		int arr[]=new int[10],i,n;
		spaceCmp+=12*4;
		que2 obj=new que2();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter numbers of element in array : ");
		n=sc.nextInt();
		
		System.out.println("enter array : ");
		for(i=0;i<n;i++)
			{
				arr[i]=sc.nextInt();
				timeComp++;
			}
		
		obj.median(arr, n);
		
		System.out.println("time Complexity : "+timeComp);
		System.out.println("space Complexity : "+spaceCmp);
		
		sc.close();
	}

	public static void median(int arr[] , int n)
	{
		int i,j,med;
		spaceCmp+=3*4;
		for(i=0;i<n;i++) 
		{
			timeComp++;
			for(j=i+1;j<n;j++)
			{
				timeComp++;
				if(arr[i]>arr[j])
				{
					timeComp++;
					arr[i]=arr[i]+arr[j];
					arr[j]=arr[i]-arr[j];
					arr[i]=arr[i]-arr[j];
				}
			}
		}
		System.out.println("median is : "+arr[(n-1)/2]);
	}
}