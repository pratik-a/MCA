import java.io.*;
import java.util.Scanner;


public class que7
{
	static int timeComp=0,spaceCmp=0;
	public static void main(String[] args)
	{
		int arr[]=new int[10],i,n,find;
		spaceCmp+=12*4;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter numbers of element in array : ");
		n=sc.nextInt();
		
		System.out.println("enter array : ");
		for(i=0;i<n;i++)
			{
				arr[i]=sc.nextInt();
				timeComp++;
			}
		
		sort(arr,n);
		
		System.out.println("enter number want to search in array : ");
		find=sc.nextInt();
		
		binarySearch(arr,0,n,find);
		
		System.out.println("time Complexity : "+timeComp);
        System.out.println("space Complexity : "+spaceCmp);
        
		sc.close();
	}

	public static void sort(int arr[],int endPt)
	{
		int i,j;
		for(i=0;i<endPt;i++)
		{
			for(j=i+1;j<endPt-1;j++)
			{
				if(arr[i]>arr[j])
				{
					arr[i]=arr[i]+arr[j];
					arr[j]=arr[i]-arr[j];
					arr[i]=arr[i]-arr[j];
				}
			}
		}
	}

	public static void binarySearch(int arr[],int startPt,int endPt,int find)
	{
		int midpt=(startPt+endPt)/2;
		
		if (find == arr[midpt]) 
		{
			System.out.println(find + " found in array");
		}
		else if(endPt>=startPt)
		{
			if (arr[midpt] > find) 
			{
				binarySearch(arr, midpt+1, endPt, find);
			} 
			else if (arr[midpt] < find) 
			{
				binarySearch(arr, startPt, midpt-1, find);
			}
		}
		else
		{
			System.out.println(find+" not found in array");
		}
	}
}