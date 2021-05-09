import java.util.Scanner;

class que15
{
	public static void min(String[] args)
	{
		int dimension;
		
		Scanner sc=new Scanner(System.in);
        
        System.out.println("enter number of dimension");
        dimension=sc.nextInt();
        
        int dimensions[]=new int[dimension];
        
        System.out.println("enter dimensions of matrix");
        for(int i=0;i<dimension;i++)
        {
        	dimensions[i]=sc.nextInt();
        }
	}
	static int MatrixChainOrder(int p[], int i, int j)
    {
        if (i == j)
            return 0;
 
        int min = Integer.MAX_VALUE;
 
        for (int k = i; k < j; k++)
        {
            int count = MatrixChainOrder(p, i, k)+ MatrixChainOrder(p, k + 1, j)+ p[i - 1] * p[k] * p[j];
 
            if (count < min)
            {
            	min = count;
            }
        }
        return min;
    }
}