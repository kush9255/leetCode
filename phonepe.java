import java.util.*;
import java.lang.*;
import java.io.*;
public class phonepe {
    public static int min_arrow(int[]a,int n)
    {
        int ans=0;
        PriorityQueue<Integer>q=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++)
        q.add(a[i]);
        while(q.size()>1)
        {
            int num1=q.remove();
            int num2=q.remove();
            ans=Math.abs(num1-num2);
            q.add(ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]a={10,20,45,50,65};
        int n=a.length;
        int ans=min_arrow(a, n);
        System.out.println(ans);
    }
}
