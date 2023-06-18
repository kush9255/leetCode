import java.util.Stack;

public class sub_arr_min {
/*       public static int sumSubarrayMins(int[] a) {
        long sum=0;
        long mod=(long)1e9+7;
        int n=a.length;
        int[] right=new int[n];
        int[] left=new int[n];

        
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
    } */

    public static int sumSubarrayMins(int[] arr) {
        long res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        long M = (long)1e9 + 7;
        stack.push(-1);
        
        for (int i2 = 0; i2 < arr.length+1; i2++){
            int currVal = (i2<arr.length)? arr[i2] : 0;
            
            while(stack.peek() !=-1 && currVal < arr[stack.peek()]){
                int index = stack.pop();
                int i1 = stack.peek();
                int left = index - i1;
                int right = i2 - index;
                long add = (long)(left * right * (long)arr[index]) % M;
                res += add ;
                res %= M;
            }
            
            stack.push(i2);
            
        }
        
        return (int)res;
    }

    public static void main(String[] args) {
        int[]a={71,55,82,55};
        int res=sumSubarrayMins(a);
        System.out.println(res);
    }
}
