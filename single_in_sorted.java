class single_in_sorted {
    public int singleNonDuplicate(int[] nums) {
    int n=nums.length-1;
    int res=-1;
    res=findno(nums,0,n,n+1);
    return res;            
    }
    public int findno(int[]a,int start,int end,int len)
    {
    int ans =-1;        
    if(start<end)
    {
        int mid=start+(end-start)/2;
        if(mid-1 >=0 && mid+1<len && a[mid]!=a[mid+1] && a[mid]!=a[mid-1])
        return a[mid];
        else
        {
                if((mid-start)%2==0)
                {
                    if( a[mid+1]==a[mid])
                 ans=findno(a,mid,end,len);
                    else
                ans=    findno(a,start,mid,len);
                }
                else
                {
                    if(a[mid+1]==a[mid])
                ans=    findno(a,start,mid-1,len);
                    else
                ans=    findno(a,mid+1,end,len);
                }
        }
    }
    else
    return a[start];

        return ans;
    } 
}