import java.util.Scanner;

public class que13
{
	class Edge {
        int source, destination, weight;
        Edge()
        {
        	source = destination = weight = 0;
        }
    };
    
	public static void main(String[] args)
	 {
		 int nvertex=4,nedge=5,i,j;
		 
		 Scanner sc=new Scanner(System.in);
		 
		 System.out.println("enter number of edges");
		 nedge=sc.nextInt();
		 
		 System.out.println("enter number of vertex");
		 nvertex=sc.nextInt();
		 
		 que13 graph=new que13(nvertex,nedge);;
		
		 
		 	for(i=0;i<nedge;i++)
		 	{
		 			System.out.println("enter the source ");
		 			graph.edge[i].source=sc.nextInt();
		 			System.out.println("enter the destination from source : "+graph.edge[i].source);
		 			graph.edge[i].destination=sc.nextInt();
		 			System.out.println("enter the weight from : "+graph.edge[i].destination+" to source : "+graph.edge[i].source);
		 			graph.edge[i].weight=sc.nextInt();
		 	}
	 
		 	graph.BellmanFord(graph, 0);
	 }
	
	void printArr(int dist[], int V)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
        {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }
	
    int V, E;
    Edge edge[];
  
    // Creates a graph with V vertices and E edges
    que13(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
        {
            edge[i] = new Edge();
        }
    }
    
    void BellmanFord(que13 graph, int src)
    {
    	int v=graph.V,e=graph.E;
    	int dist[]=new int[V];
    	
    	for(int i=0;i<V;i++)
    	{
    		dist[i]=Integer.MAX_VALUE;
    	}
    	dist[src]=0;
    	
    	for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].source;
                int uv = graph.edge[j].destination;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[uv])
                    dist[uv] = dist[u] + weight;
            }
        }
  
        // Step 3: check for negative-weight cycles. The above
        // step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter
        // path, then there is a cycle.
        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].source;
            int uv = graph.edge[j].destination;
            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[uv]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        printArr(dist, V);
    }
}