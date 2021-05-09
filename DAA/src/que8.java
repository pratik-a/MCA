import java.io.*;
import java.util.Scanner;


public class que8
{
	static int timeComp=0,spaceCmp=0;
	public static void main(String[] args)
	{
		int arr[]=new int[10],i,n;
		spaceCmp+=12*4;
		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter numbers of element in heap : ");
		n=sc.nextInt();
		
		System.out.println("enter heap : ");
		
		for(i=0;i<n;i++)
			{
				arr[i]=sc.nextInt();
				timeComp++;
			}
		
		heapSort(arr,n);
	
		for(i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
			timeComp++;
		}
		
		System.out.println("time Complexity : "+timeComp);
        System.out.println("space Complexity : "+spaceCmp);
        
		sc.close();
	}
	
	public static void heapSort(int arr[],int n)
	{
		int i,temp;
		
		for(i=n/2-1;i>=0;i--)
		{
			heapify(arr,n,i);
		}
		
		for(i=n-1;i>=0;i--)
		{
			temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			
			heapify(arr,i,0);
		}
	}
	
	public static void heapify(int arr[],int n,int i)
	{
		int largest=i;
		int leftNode=2*i+1;
		int rightNode=2*i+2;
		
		if(leftNode<n && arr[leftNode]>arr[largest])
		{
			largest=leftNode;
		}
		if(rightNode<n && arr[rightNode]>arr[largest])
		{
			largest=rightNode;
		}
		
		if(largest!=i)
		{
			int swap=arr[i];
			arr[i]=arr[largest];
			arr[largest]=swap;
			
			heapify(arr,n,largest);
		}
	}
}


	