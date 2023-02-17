public class next_permutation {
    public static void main(String[] args) {
        int[]a={1,2,7,4,3,8,9};
        nextPermutation(a);
        for(int i:a)
        System.out.print(i+" ");
    }
    public static void nextPermutation(int[] a) {
        int n=a.length;
        int i=n-2;
        while(i>=0 && a[i]>=a[i+1])
        i--;
        if(i>=0)
        {
            int j=n-1;
            while(a[j]<=a[i])
            j--;
            swap(a,i,j);
        }
        reverse(a,i+1,n-1);
        
    }
    public static void swap(int[]a,int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void reverse(int[]a,int i,int n)
    {
        int k=0;
        while(i+k<n-k)
        {
        swap(a,i+k,n-k);
        k++;
        }
    }
}
