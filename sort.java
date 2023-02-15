import java.util.List;

public class sort {
    public static void sort_arr(int[] a,int n){
       
        int gap =(int) Math.ceil(n / 2.0);

        while(gap>0)
        {
            int i=0;
            while(i+gap<n)
            {
                int k=a[i];
                int l=a[i+gap];
                if(a[i]>a[i+gap])
                {
                    int temp=a[i];
                    a[i]=a[i+gap];
                    a[i+gap]=temp;
                }
                i++;
            }
            if (gap == 1) {
                gap = 0;
              } else {
                gap =(int)Math.ceil(gap / 2.0);
              }
        }
    }
    public static void main(String[] args) {
        int []a={7,8,15,16,1,5};
        int n=a.length;
        sort_arr(a,n);

        for(int i: a)
        System.out.print(i+" ");
        
    }
    
}
