import java.io.*;
import java.util.Scanner;


public class que4
{
	static int timeComp=0,spaceCmp=0;
	public static void main(String[] args)
	{
		int arr[]=new int[10],i,n;
		spaceCmp+=12*4;
		que4 obj=new que4();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter numbers of element in array : ");
		n=sc.nextInt();
		
		System.out.println("enter array : ");
		for(i=0;i<n;i++)
			{
				timeComp++;
				arr[i]=sc.nextInt();
			}
		
		obj.mergeSort(arr, 0 , n-1);
		
		for(i=0;i<n;i++)
		{
			timeComp++;
			System.out.print(arr[i]+" ");
		}
		System.out.println("time Complexity : "+timeComp);
		System.out.println("space Complexity : "+spaceCmp);
		sc.close();
	}

	public static void mergeSort(int arr[] ,int startPt, int endPt)
	{
		int middle;
		spaceCmp+=4;
		
		if(startPt<endPt)
		{
			timeComp++;
			middle=(startPt+endPt)/2;
			
			mergeSort(arr,startPt,middle);
			mergeSort(arr,middle+1,endPt);
			
			mergeArray(arr,startPt,middle,endPt);
		}
	}
	
	public static void mergeArray(int arr[],int startPt,int middle,int endPt)
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
		while(i<n1 && j<n2)
		{
			timeComp++;
			if(left[i]<right[j])
			{
				timeComp++;
				arr[k]=left[i];
				i++;
				k++;
			}
			else
			{
				timeComp++;
				arr[k]=right[j];
				j++;
				k++;
			}
		}
		
		while (i < n1) 
		 {
			timeComp++;
	            arr[k] = left[i];
	            i++;
	            k++;
	     }
	 
	    while (j < n2) 
	     {
	    	timeComp++;
	            arr[k] = right[j];
	            j++;
	            k++;
	     }
	   
	}
}
