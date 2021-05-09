import java.io.*;
import java.util.Scanner;

class insertSort
{
	public static void main(String[] args)
	{
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter length of array");
		int num=sc.nextInt();
		
		int arr[]=new int[num];
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print("enter value at "+(i+1)+" of array ");
			arr[i]=sc.nextInt();
		}
		
		insertSort obj =new insertSort();
		obj.sort(arr);
		
		System.out.println("sorted array");
		print(arr);
				
	}
	
	void sort(int arr[])
	{
		
		int n=arr.length;
		
		for(int i=0;i<n;i++)
		{
			int key=arr[i];
			int j=i-1;
			
			while(j>=0&&arr[j]>key)
			{
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
	}
	
	static void print(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
}