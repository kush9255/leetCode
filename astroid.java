import java.util.*;
public class astroid {
    public static int[] asteroidCollision(int[] a)
     {
         Stack<Integer>st=new Stack<>();
         int n=a.length;
         st.push(a[0]);
         for(int i=1;i<n;i++)
         {
             if(st.size()>0 && st.peek()>0 && a[i]<0)
             {
                 while(st.size()>0 && st.peek()<Math.abs(a[i]))
                 {
                     st.pop();
                 }
                 if(st.peek()==Math.abs(a[i]))
                 st.pop();
                 else if(st.size()==0 || st.peek()<0)
                 st.push(a[i]);
             }
             else
             st.push(a[i]);
         }
         int s=st.size();

         int[] res=new int[s];
         for(int i=s-1;i>=0;i--)
         res[i]=st.pop();
        return  res;
        
    }
    public static void main(String[] args)
    {
        int[]a={5,10,-5};
        int[]res=asteroidCollision(a);
        for(int i: res)
        System.out.print(i+" ");

    }
}