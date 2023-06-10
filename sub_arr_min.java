import java.util.Stack;

public class sub_arr_min {
      public static int sumSubarrayMins(int[] a) {
        long sum=0;
        long mod=(long)1e9+7;
        int n=a.length;
        int[] right=new int[n];
        int[] left=new int[n];
        /*
        for(int i=0;i<n;i++)
        sum+=a[i];
        */
        Stack<Integer>s=new Stack<>();

        for(int i=n-1;i>=0;i--)
        {
            while(s.size()>0 && a[i]<a[s.peek()]) 
            //this is tricky here a[i]<a[s.peek] in RIGHT but in LEFT it is a[i]<=a[s.peek]
            {
                s.pop();
            }
            if(s.size()==0)
            right[i]=n;
            else
            right[i]=s.peek();
            s.push(i);
        }

        s.clear();

        for(int i=0;i<n;i++)
        {
            while(s.size()>0 && a[i]<=a[s.peek()]) //this is simple
            s.pop();
            if(s.size()==0)
            left[i]=-1;
            else
            left[i]=s.peek();
            s.push(i);
        }
      
        for(int i=0;i<n;i++)
        {
            int l=i-left[i];
            int r=right[i]-i;
            long ans=(l*r*(long)a[i])%mod;
            //(long)a[i]) this is important else without long it will overflow as a[i]*l might cause it ti overflow
            //even if I take mod
            sum=(sum+ans)%mod;
            
        }

        return (int)sum;
    }
    public static void main(String[] args) {
        int[]a={71,55,82,55};
        int res=sumSubarrayMins(a);
        System.out.println(res);
    }
}
