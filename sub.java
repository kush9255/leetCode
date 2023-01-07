import java.util.Arrays;

public class sub {
    public static int[] answerQueries(int[] a, int[] queries) {
        int m=queries.length;
        int n=a.length;
        Arrays.sort(a);
        int[] pref=new int[n];
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=a[i];
            pref[i]=sum;
        }
        int[]res=new int[m];
        for(int i=0;i<m;i++)
        {
            int len=0;
            int q=queries[i];
            res[i]=bs(pref,q);
        }
        return  res;
    }
   public static int bs(int[]a,int t)
    {
        int n=a.length;
        int low=0;
        int hi=n;
        int mid=(low+hi)/2;
        if(t<a[0])
        return 0;
        if(t==a[0])
        return 1;
        if(t>=a[n-1])
        return n;

        while(low<hi)
        {
            mid=(low+hi)/2;
            if(a[mid]<=t)
            {
                if(mid+1<n && a[mid+1]>t)
                return mid+1;
                else if(mid+1<n)
                low=mid+1;
            }
            else
            {
                if(mid-1>=0 && a[mid-1]<=t)
                return mid;
                else if(mid -1 >0)
                hi=mid-1;
            }
        }
        return 0;
    }
   public static void main(String[] args) {
    int[] nums={573210,20594,196301};
    int [] queries={880897,461149,301768,510087,572628,544429,141852,870779,156572};
    int[] res=answerQueries(nums,queries);
    for(int i :res)
    System.out.print(i+" ");
   }
}
