class kth_smallest {
    public static int findKthLargest(int[] a, int k) {
        int beg=0,end=a.length-1,j=-1;
        while(beg<end)
        {
         j=partition(a,beg,end);    
        if(j==k-1)
        return a[j];
        else if(j>k-1)
        end=j-1;
        else if(j<k-1)
        beg=j+1;
        }

     return a[beg];
    }
    public static int partition(int[]a,int beg,int end)
    {
        int i=beg-1;
        int x=a[end];
        for(int j=beg;j<end;j++)
        {
            if(a[j]>=x)
            {
                i++;
                swap(a,i,j);
            }
        }
        swap(a,i+1,end);
        return i+1;
    }
    public static void swap(int[] a,int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void main(String[] args) {
      int[]a={3,2,3,1,2,4,5,5,6};
      int k=4;
      int ans=findKthLargest(a,k);
      System.out.println(ans);

    }
}