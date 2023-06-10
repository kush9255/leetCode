import java.util.ArrayDeque;
import java.util.ArrayList;

public class window {
    static ArrayList <Integer> max_of_subarrays(int a[], int n, int k)
    {
        // Your code here
        ArrayDeque<Integer> q=new ArrayDeque<>();
        int i=0;
        int count=k;
        ArrayList<Integer> res=new ArrayList<>();
        for(int j=0;j<n;j++)
        {
            if(count !=0)
            {
            if(q.size()==0)    
            q.add(j);
            else
            {
                while(q.size()>0 && a[j]>a[q.peek()])
                q.remove();
                q.add(j);
            }
            count--;
            if(j-i+1<k)
            continue;
            }
            else if(j-i+1>k)
            {
                i++;
                if(q.peek()<i)
                q.remove();
                if(a[j]>a[q.peek()])
                q.remove();
                q.add(j);
            }
            if(j-i+1==k)
            {
                res.add(a[q.peek()]);
                /*while(a[j]>q.peek())
                q.remove();
                q.add(j);
                */
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int k=3;
        int[]a={2,1,4,5,3};
        ArrayList<Integer> res=max_of_subarrays(a,5,3);
        for(int i: res)
        System.out.println(i+" ");
    }
}
