class rotate {
    public static void rotate(int[] nums, int k) {
        int n=nums.length;
        int pos=n-k;
        reverse(nums,0,pos-1);
        reverse(nums,pos,n-1);
        reverse(nums,0,n-1);
    }
    public static void reverse(int[] a,int beg,int end)
    {
        while(beg<end)
        {
            int temp=a[beg];
            a[beg]=a[end];
            a[end]=temp;
            beg++;end--;
        }
    }
    public static  void main(String[] args) {
        int[]nums={1,2,3,4,5,6,7};
        int k=3;
        for(int i:nums)
        System.out.print(i+" ");
        System.out.println();
        rotate(nums, k);
        for(int i:nums)
        System.out.print(i+" ");
        return;
    }
}