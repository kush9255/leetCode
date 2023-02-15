public class first_last {
    public static void main(String[] args) {
        int[]a={5,5,5,7,7,7,7,8,8,10};
        int t=5;
        int[]res=searchRange(a,t);
        for(int i:res)
        System.out.print(i+" ");
    }
    public static int[] searchRange(int[] a, int target) {
        int n=a.length;
        int[]res={-1,-1};
        int low=0;
        int hi=n-1;
        int fi=-1,li=-1;
        int found=-1;
        if(a.length == 0 ||target<a[0] || target > a[n-1])
        return res;
        if(a.length==1)
        {
            if(a[0]==target)
            {
               return new int[2];
            }
            return res;
        }
        li=last_index(a,target,n);
        fi=first_index(a,target,n);
        res[0]=fi;
        res[1]=li;
        return res;
    }
    static int last_index(int[]a,int target,int n)
    {
        int lo=0;
        int hi=n-1;
        int pos=-1;
        while(lo<hi)
        {
        int mid=hi-(int)(Math.ceil((hi-lo)/2.0));
        if(a[mid]<=target)
        {
             lo=mid+1;
             if(a[mid]==target)
             pos=mid;
        }
        else
        hi=mid-1;
       }
        if(a[lo]==target)
        pos=lo;
        return pos;
    }
    static int first_index(int[]a,int target,int n)
    {
        int lo=0;
        int hi=n-1;
        int pos=-1;
        while(lo<hi)
        {
        int mid=hi-(int)(Math.ceil((hi-lo)/2.0));
        if(a[mid]>=target)
        {
            if(a[mid]==target)
            pos=mid;
            hi=mid-1;
        }
        else
        lo=mid+1;
        }
        if(a[lo]==target)
        pos=lo;
        return pos;
    }
}
