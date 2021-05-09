import java.io.*;
import java.util.Scanner;


public class que6
{
	static int timeComp=0,spaceCmp=0,min,max;
	public static void main(String[] args)
	{
		int arr[]=new int[10],i,n;
		spaceCmp+=12*4;
		que6 obj=new que6();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter numbers of element in array : ");
		n=sc.nextInt();
		
		System.out.println("enter array : ");
		for(i=0;i<n;i++)
			{
				timeComp++;
				arr[i]=sc.nextInt();
			}
		min=max=arr[1];
		obj.divide(arr, 0 , n-1);
		
		System.out.println("minimum : "+min);
		System.out.println("maximum : "+max);
		
		System.out.println("time Complexity : "+timeComp);
		System.out.println("space Complexity : "+spaceCmp);
		
		sc.close();
	}

	public static void divide(int arr[] ,int startPt, int endPt)
	{
		int middle;
		spaceCmp+=4;
		if(startPt<endPt)
		{
			timeComp++;
			middle=(startPt+endPt)/2;
			
			divide(arr,startPt,middle);
			divide(arr,middle+1,endPt);
			
			conquer(arr,startPt,middle,endPt);
		}
	}
	
	public static void conquer(int arr[],int startPt,int middle,int endPt)
	{
		spaceCmp+=5*4;
		int i=0,j=0,k=startPt,n1,n2;
		n1=middle-startPt+1;
		n2=endPt-middle;
		
		int left[]=new int[n1];
		int right[]=new int[n2];
		
		for(i=0;i<n1;i++)
		{
			timeComp++;
			left[i]=arr[startPt+i];
		}
		for(j=0;j<n2;j++)
		{
			timeComp++;
			right[j]=arr[middle+j+1];
		}
		i=0;
		j=0;
		while(i<n1 || j<n2)
		{
			timeComp++;
			if(i<n1)
			{
				timeComp++;
				arr[k]=left[i];
				if(min>arr[k])
				{
					min=arr[k];
				}
				if(max<arr[k])
				{
					max=arr[k];
				}
				i++;
				k++;
			}
			if(j<n2)
			{
				timeComp++;
				arr[k]=right[j];
				if(min>arr[k])
				{
					min=arr[k];
				}
				if(max<arr[k])
				{
					max=arr[k];
				}
				j++;
				k++;
			}
		
		}
		
	}
}