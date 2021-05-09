import java.io.*;
import java.util.*;

public class que19
{
    private int V;
    private LinkedList<Integer> adj[]; 
    
    que19(int v)
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
        
        que19 g = new que19(nvertex);
        
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
        
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.BFS(2);
    }
    
    void BFS(int s)
    {
    	boolean visited[]=new boolean[V];
    	
    	LinkedList<Integer> queue=new LinkedList<Integer>();
    	
    	visited[s]=true;
    	queue.add(s);
    	
    	while(queue.size()!=0)
		{
			s=queue.poll();
			System.out.print(s+" ");
			
			Iterator<Integer> i=adj[s].listIterator();
			while(i.hasNext())
			{
				int n=i.next();
				if(!visited[n])
				{
					visited[n]=true;
					queue.add(n);
				}
			}
		}
	}
    
}
