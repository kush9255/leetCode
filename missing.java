class missing {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
       for(int i=0; i<n;i++)
       {
           if(nums[i]<0)
           nums[i]=n+1;
       }
       for(int i=0;i<n;i++)
       {
        if(nums[i]>=1&&nums[i]<=n)
        {
        if(nums[nums[i]-1]>0)   
        nums[nums[i]-1]*=-1;
        }
        else if(-1*nums[i]>=1&&-1*nums[i]<=n)
        if(nums[-1*nums[i]-1]>0)
        nums[-1*nums[i]-1]*=-1;
       }
       for(int i=0;i<n;i++)
       System.out.print(nums[i]+" ");
       int i=0;
       for( i=0;i<n;i++)
       if(nums[i]>=0)
       return i+1;

       return i+1;
    }
    public static void main(String[] args) {
        int[]a={3,4,-1,1};
        missing m=new missing();
        int ans=m.firstMissingPositive(a);
        System.out.println("ans "+ans);
  
      }
  
}