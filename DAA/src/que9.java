import java.util.*;
import java.lang.*;
import java.io.*;

class que9
{
	class Edge implements Comparable<Edge>
	{
		int source,destination,weight;
		
		public int compareTo(Edge compareEdge)
		{
			return this.weight-compareEdge.weight;
		}
	};
	
	class subset
	{
		int parent,rank;
	};
	
	int Vertex,eedge;
	Edge edges[];
	
	que9(int vertex,int edge)
	{
		Vertex=vertex;
		eedge=edge;
		edges=new Edge[eedge];
		
		for(int i=0;i<edge;++i)
		{
			edges[i]=new Edge();
		}
	}
	
	int find(subset subsets[],int i)
	{
		if(subsets[i].parent!=i)
		{
			subsets[i].parent=find(subsets,subsets[i].parent);
		}
		
		return subsets[i].parent;
	}
	
	void union(subset subsets[],int x,int y)
	{
		int xroot=find(subsets,x);
		int yroot=find(subsets,y);
		
		if(subsets[xroot].rank < subsets[yroot].rank)
		{
			subsets[xroot].parent=yroot;
		}
		else if(subsets[xroot].rank > subsets[yroot].rank)
		{
			subsets[yroot].parent=xroot;
		}
		else
		{
			subsets[yroot].parent=xroot;
			subsets[xroot].rank++;
		}
	}
	
	void KrushkalMst()
	{
		Edge result[]=new Edge[Vertex];
		int e=0;
		int i=0;
		
		for(i=0;i<Vertex;++i)
		{
			result[i]=new Edge();
		}
		
		Arrays.sort(edges);
		
		subset subsets[]=new subset[Vertex];
		
		for(i=0;i<Vertex;++i)
		{
			subsets[i]=new subset();
		}
		
		for(int v=0;v<Vertex;++v)
		{
			subsets[v].parent=v;
			subsets[v].rank=0;
		}
		i=0;
		
		while(e<Vertex-1)
		{
			Edge next_edge=edges[i++];
			
			int x = find(subsets, next_edge.source);
            int y = find(subsets, next_edge.destination);
            
            if (x != y) 
            {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
		}
		
		System.out.println("Following are the edges in the constructed MST");
		int minimumCost = 0;
		for (i = 0; i < e; ++i)
		{
			System.out.println(result[i].source + " --> "+ result[i].destination+ " == " + result[i].weight);
			minimumCost += result[i].weight;
		}
		
		System.out.println("Minimum Cost Spanning Tree "+ minimumCost);
	}
	
	 public static void main(String[] args)
	 {
		 int nvertex=4,nedge=5,i,j;
		 
		 Scanner sc=new Scanner(System.in);
		 
		 System.out.println("enter number of edges");
		 nedge=sc.nextInt();
		 
		 System.out.println("enter number of vertex");
		 nvertex=sc.nextInt();
		 
		 que9 graph=new que9(nvertex,nedge);
		 
		 	for(i=0;i<nedge;i++)
		 	{
		 			System.out.println("enter the source ");
		 			graph.edges[i].source=sc.nextInt();
		 			System.out.println("enter the destination from source : "+graph.edges[i].source);
		 			graph.edges[i].destination=sc.nextInt();
		 			System.out.println("enter the weight from : "+graph.edges[i].destination+" to source : "+graph.edges[i].source);
		 			graph.edges[i].weight=sc.nextInt();
		 	}
	 
	        // Function call
	        graph.KrushkalMst();
	 }
}


