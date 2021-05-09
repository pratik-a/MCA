import java.util.Scanner;

class travelProb 
{
	static int timeComp=0,spaceCmp=0;
    static int tsp(int[][] graph, boolean[] v,int currPos, int n,int count, int cost, int ans) 
    {
    	
    	if(count==n && graph[currPos][0]>0)
    	{
    		ans=Math.min(ans,cost+graph[currPos][0]);
    		return ans;
       	}
    	
    	for(int i=0;i<n;i++)
    	{
    		if(v[i]==false && graph[currPos][i]>0)
    		{
    			v[i]=true;
    			ans=tsp(graph,v,i,n,count+1,cost+graph[currPos][i],ans);
    			
    			v[i]=false;
     		}
    	}
    	return ans;
    }
  
    // Driver code
    public static void main(String[] args)
    {
    	int n,i,j,graph[][]=new int[10][10];
    	Scanner sc=new Scanner(System.in);
		
    	spaceCmp+=23*4+10+4;
    	
		System.out.println("enter numbers of element in Graph : ");
		n=sc.nextInt();
  
		for(i=0;i<n;i++)
		{
			timeComp++;
			System.out.println("enter distance from node"+(i+1));
			for(j=0;j<n;j++)
			{
				timeComp++;
				if(i!=j)
				{
					timeComp++;
					graph[i][j]=sc.nextInt();
				}
				else if(i==j)
				{
					timeComp++;
					graph[i][j]=0;
					System.out.println(graph[i][j]);
				}
			}
		}
  
        // Boolean array to check if a node
        // has been visited or not
       
		boolean[] v = new boolean[n];
  
        // Mark 0th node as visited
       
        v[0] = true;
        int ans = Integer.MAX_VALUE;
  
        // Find the minimum weight Hamiltonian Cycle
      
        ans = tsp(graph, v, 0, n, 1, 0, ans);
  
        // ans is the minimum weight Hamiltonian Cycle
       
        System.out.println(ans);
        
        System.out.println("time Complexity : "+timeComp);
        System.out.println("space Complexity : "+spaceCmp);
    }
}