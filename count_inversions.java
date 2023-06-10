public class count_inversions {
    static long inversionCount(long[] arr,long n)
    {
        return Count(arr,0,(int)n-1);
    }
    static long Count(long arr[], int low,int high)
    {
        int mid=(low+high)/2;
        if(low>=high)
        return 0;
        else
        {
        long l=Count(arr,low,mid);
        long r=Count(arr,mid+1,high);
        long m=merge_count(arr,low,mid,high);
        return l+m+r;
        }
        
    }
    static long merge_count(long[] a,int low,int mid,int high)
    {
        long count=0;
        
        int i=low;
        int j=mid+1;
        int k=0;
        long[] temp =new long[(int)(high-low+1)];
        while(i<=mid && j<=high)
        {
         if(a[i]>a[j])
         {
             temp[k++]=a[j++];
             count+=mid-i+1;
         }
         else
         temp[k++]=a[i++];
        }
        while(i<=mid)
        temp[k++]=a[i++];
         while(j<=high)
        temp[k++]=a[j++];
        int l=k;
        k=0;
        while(k<high-low+1)
        {
            a[low++]=temp[k++];
        }
        return count;
    }
    public static void main(String[] args) {
        long[] arr={2,4,1,3,5};
        long res=inversionCount(arr,5);
        System.out.println(res);

    }
    
}
