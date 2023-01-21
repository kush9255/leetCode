import java.util.Scanner;
import java.lang.*;
public class shortest_unsorted {
    public static int unsorted(int[]a)
    {
        int start=1;
        int end =0;
        int n=a.length;
        int min=a[0];
        int max=a[n-1];
        for(int i=1;i<n;i++)
        {
            if(a[i]<min)
            end=i;
            else
            min=a[i];
        }
        if(end==0)
        return 0;
        for(int i=n-2;i>=0;i--)
        {
            if(a[i]>max)
            start=i;
            else
            max=a[i];
        }
        return end-start+1;
    }
    public static void main(String[] args) {
        System.out.println("Print no");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        int res=unsorted(a);
        System.out.println(res);
    }
    
}
