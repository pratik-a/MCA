 import java.util.Arrays;
 import java.util.Comparator;
 import java.util.Scanner;
 
public class FracKnapSk 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter nuber of objects\t");
		int num=sc.nextInt();
		
		int wt[]=new int[num];
		int val[]=new int[num];
		int capacity;
		
		System.out.println("enter capacity\t");
		capacity=sc.nextInt();
		
		for(int i=0;i<num;i++)
		{
			System.out.println("enter weight of"+(i)+"\t");
			wt[i]=sc.nextInt();
			System.out.println("enter profit of"+(i)+"\t");
			val[i]=sc.nextInt();
		}
		
		getMaxProf(wt,val,capacity);
	}
	
	public static void getMaxProf(int[] wt,int[] val,int capacity)
	{
		ItemValue[] ival=new ItemValue[wt.length];
		
		for(int i=0;i<wt.length;i++)
		{
			ival[i]=new ItemValue(wt[i],val[i],i);
		}
		
		Arrays.sort(ival,new Comparator<ItemValue>()
		{
			@Override
			public int compare(ItemValue o1,ItemValue o2)
			{
				return o2.cost.compareTo(o1.cost);
			}
		});
		
		double totalvalue=0d;
		
		for(ItemValue i : ival)
		{
			int curWt=(int)i.wt;
			int curVl=(int)i.val;
			
			if(capacity-curWt >=0) 
			{
				capacity=capacity-curWt;
				totalvalue+=curVl;
			}
			else
			{
				double fraction=((double)capacity/(double)curWt);
				totalvalue+=(curVl*fraction);
				capacity=(int)(capacity-(curWt*fraction));
				break;
			}
		}
		
		System.out.println("profit = "+totalvalue);
	}
	
	static class ItemValue
	{
		Double cost;
		double wt,val,ind;
		
	
		public ItemValue(int wt,int val,int ind)
		{
			this.wt=wt;
			this.val=val;
			this.ind=ind;
			
			cost=new Double((double)val/(double)wt);
		}
	}
}

