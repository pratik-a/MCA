import java.io.*;
import java.util.Scanner;

public class que12
{
	static int nvertex= 9;
	
	public static void main(String[] args)
	{
		
		que12 obj =new que12();
		Scanner sc=new Scanner(System.in);
		
		/*System.out.println("enter number of edges of graph");
		int nvertex=sc.nextInt();
		
		int graph[][]=new int[nvertex][nvertex];
		
		 for(int i=0;i<nvertex;i++)
	        {
	        	for(int j=0;j<nvertex;j++)
	        	{
	        		System.out.println("enter weight of "+(i+1)+" to "+(j+1));
	        		if(i!=j)
	        		{
	        			graph[i][j]=sc.nextInt();
	        		}
	        		else
	        		{
	        			System.out.println("0");
	        			graph[i][j]=0;
	        		}
	        	}
	        }*/
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
             { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
             { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
             { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
             { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
             { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
             { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
             { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
             { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		 obj.dijkstra(graph,0);
			
	}
	
	void dijkstra(int graph[][],int src)
	{
		
		int dist[]=new int[nvertex];
		boolean sptSet[] =new boolean[nvertex];
		
		for(int i=0;i<nvertex;i++)
		{
			dist[i]=Integer.MAX_VALUE;
			sptSet[i]=false;
		}
		
		dist[src]=0;
		
		for(int count=0;count<nvertex-1;count++)
		{
			int u=minDistance(dist,sptSet);
			sptSet[u]=true;
			
			for(int v=0;v<nvertex;v++)
			{
				if(!sptSet[v] && graph[u][v]!=0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
				{
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		printSolution(dist,nvertex);
	}
	
	 int minDistance(int dist[], boolean sptSet[])
	    {
	        // Initialize min value
	        int min = Integer.MAX_VALUE, min_index = -1;
	  
	        for (int v = 0; v <nvertex; v++)
	        {
	            if (sptSet[v] == false && dist[v] <= min) 
	            {
	                min = dist[v];
	                min_index = v;
	            }
	        }
	        return min_index;
	    }
	  
	 	void printSolution(int dist[], int n)
	 	{
	 		System.out.println("Vertex   Distance from Source");
	 		for (int i = 0; i <nvertex; i++)
	 		{
	 			System.out.println(i + "   tt   " + dist[i]);
	 		}
	 	}
}