import java.lang.*;
import java.io.*;
import java.util.*;

public class stck_span {
    public static int[] calculateSpan(int a[], int n)
    {
        // Your code here
        int [] res=new int[n];
        Stack<Integer>s1=new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            int cnt=0;
            while(s1.size()>0 && a[s1.peek()]<=a[i])
            {
                cnt+=res[s1.peek()];
                s1.pop();
            }
            res[i]=cnt+1;
            s1.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int price[] = {100 ,80 ,60 ,70 ,60 ,75 ,85};
        int n=7;
        int [] res=calculateSpan(price,n);
    }
}
