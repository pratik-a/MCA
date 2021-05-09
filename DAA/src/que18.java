import java.io.*;
import java.util.*;

public class que18
{
    private int V;
    private LinkedList<Integer> adj[]; 
    
    que18(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
        {
            adj[i] = new LinkedList();
        }
    }
    
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
    
    public static void main(String args[])
    {
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.println("enter number of vertex");
        int nvertex=sc.nextInt();
        
        que18 g = new que18(nvertex);
        
        int source,dest,nedge;
        
        System.out.println("enter number of edges");
        nedge=sc.nextInt();
        
        for(int i=0;i<nedge;i++)
        {
            System.out.println("enter source");
            source=sc.nextInt();
            System.out.println("enter destination");
            dest=sc.nextInt();
            
            g.addEdge(source,dest);
        }
        
 
        System.out.println("Following is depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(2);
    }
    
    void DFSUtil(int v, boolean visited[])
    {
    	
    	visited[v]=true;
    	System.out.print(v + " ");
			Iterator<Integer> i=adj[v].listIterator();
			while(i.hasNext())
			{
				int n=i.next();
				if(!visited[n])
				{
					DFSUtil(n, visited);
				}
			}
	}
	
    void DFS(int v)
    {
        boolean visited[] = new boolean[V];
 
        DFSUtil(v, visited);
    }
}
