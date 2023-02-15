import java.util.*;
import java.lang.*;
public class longest_inc_sub {
    public static void main(String[] args) {
        int[]a={10,9,2,5,3,7,101,18};
        int ans=lengthOfLIS(a);
        
    }
    public static int  lengthOfLIS(int[] a) 
    {
        int n=a.length;
        int low=0,high=n-1;
        ArrayList<Integer>res=new ArrayList<>();
        res.add(a[0]);
        int k=0;
        int count=1;
        for(int i=1;i<n;i++)
        {
             if(a[i]>res.get(k))
            {
                res.add(a[i]);
                k++;
            }
            else if(a[i]<res.get(0))
            res.set(0,a[i]);
            else
            {
                int pos=bs(res,a[i]);
                res.set(pos,a[i]);
            }
         //  System.out.println(res);
            count=Math.max(count,res.size());
        }
        return count;
        
    }
    public static int bs(ArrayList<Integer>res,int a)
    {
        int low=0;
        int hi=res.size()-1;
        int index=-1;
        
        while(low<=hi)
        {
            int mid=(low+hi)/2;
            if(res.get(mid)<a)
            low=mid+1;
            else 
            {
                index=mid;
                hi=mid-1;
            }
        }
        return index;
    }
    
}
