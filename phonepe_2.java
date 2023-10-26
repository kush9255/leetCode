public class phonepe_2 {
    int share(int n)
    {
        int i=1;
        int j=n/2;
        int ans=0;
        while(i<j)
        {
            int mid=(i+j)/2;
            boolean f=check(n,mid,n/2);
            if(f)
            {
                ans=mid;
                j=mid-1;
            }
            else
            i=mid+1;
        }
        return ans;
    }
    boolean check(int n,int x,int ans)
    {
        int f=0;
        int s=0;
        while(n>x)
        {
            f+=x;
            s+=(n-x)/10;
            n-=x;
        }
        f+=n;
        if(f>=ans)
        return true;
        return false;
    }
}
