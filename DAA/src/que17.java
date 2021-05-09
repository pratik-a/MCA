import java.util.*;
import java.io.*;

public class que17
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter string 1");
		String str1=sc.nextLine();
		System.out.println("enter string 2");
		String str2=sc.nextLine();
		
		naiveMethod(str1,str2);
	}
	
	public static void naiveMethod(String str1,String str2)
	{
		int m = str1.length();
        int n = str2.length();
        
        for (int i = 0; i <= m - n; i++) 
        {        	 
            int j;
 
            for (j = 0; j <n; j++)
            {
                if (str1.charAt(i + j) != str2.charAt(j))
                    break;
            }
            if (j == n)
            {
                System.out.println("Pattern found at index " + i);
            }	
        }
	}
}