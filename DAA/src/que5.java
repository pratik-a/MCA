import java.io.*;
import java.util.Scanner;


public class que5
{
	static int timeComp=0,spaceCmp=0;
	public static void main(String[] args) throws Exception
	{
		int arr[]=new int[10],i,n;
		spaceCmp+=12*4;
		que5 obj=new que5();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter numbers of element in array : ");
		n=sc.nextInt();
		
		System.out.println("enter array : ");
		for(i=0;i<n;i++)
			{
				arr[i]=sc.nextInt();
				timeComp++;
			}
		
		obj.quickSort(arr, 0 , n-1);
		
		for(i=0;i<n;i++)
			{
				System.out.print(arr[i]+" ");
				timeComp++;
			}
		
		System.out.println("time Complexity : "+timeComp);
        System.out.println("space Complexity : "+spaceCmp);
        
		sc.close();
	}

 void quickSort(int arr[],int startPt,int endPt)
	{
		if(startPt<endPt)
		{
			timeComp++;
			
			int pivot=partion(arr,startPt,endPt);
			
			quickSort(arr,startPt,pivot-1);
		    quickSort(arr,pivot+1,endPt);
			
		}
	}
	
	public static int partion(int arr[],int startPt,int endPt)
	{
		int pivot=arr[endPt],i;
		int left=(startPt-1);
		spaceCmp+=4*4;
		
		for(i=startPt;i<=endPt-1;i++)
		{
			if(arr[i]<pivot)
			{
				timeComp++;
				left++;
				swap(arr,left,i);
				
			}
		}
		swap(arr,left+1,endPt);
		return (left+1);
	}
	
	public static void swap(int arr[],int i,int j)
	{
		spaceCmp+=4;
		timeComp++;
		int temp;
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}