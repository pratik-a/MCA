import java.io.*;
import java.util.*;

public class que14
{
	public static void main(String[] args)
	{
		que14 obj=new que14();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter string one for matching");
		String str1=sc.nextLine();
		System.out.println("enter string two for matching");
		String str2=sc.nextLine();
		
		char[] carr1=str1.toCharArray();
		char[] carr2=str2.toCharArray();
		
		int arr1len=carr1.length;
		int arr2len=carr2.length;
		

	    System.out.println("Length of LCS is : "+obj.lcs(carr1,carr2,arr1len,arr2len));
	}
	
	int lcs(char[] carr1,char[] carr2,int arr1len,int arr2len)
	{
		if(arr1len==0 || arr2len==0)
		{
			return 0;
		}
		
		if(carr1[arr1len-1]==carr2[arr2len-1])
		{
			return 1 + lcs(carr1,carr2,arr1len-1,arr2len-1);
		}
		else
		{
			return 1+max(lcs(carr1,carr2,arr1len-1,arr2len),lcs(carr1,carr2,arr1len,arr2len-1));
		}
	}
	
	int max(int a, int b)
	  {
	    return (a > b)? a : b;
	  }
}