import java.io.*;
import java.util.Scanner;

public class activitySelc
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter number of activities");
		int nact=sc.nextInt();
		
		int[][] actTime=new int[2][nact];
		
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<nact;j++)
			{
				if(i==0)
				{
					System.out.println("enter starting time of activity "+(j+1));
					actTime[i][j]=sc.nextInt();
				}
				else
				{
					System.out.println("enter ending time of activity "+(j+1));
					actTime[i][j]=sc.nextInt();
				}
			}
		}
		selActivity(actTime,nact);
	}
	
	public static void selActivity(int actTime[][],int nact)
	{
		int i=0,j,k=0;
		System.out.print("these activities are selected n : "+(i+1)+" ");
		
			for(j=0;j<nact;j++)
			{
				if(actTime[i+1][k]<actTime[i][j])
				{
					System.out.print((j+1)+" ");
					k=j;
				}
			}
	}
}
