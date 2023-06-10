/*Q;300 */
import java.util.*;
public class longest_cont_sub {
    public static void main(String[] args) {
        int[]a={10,9,2,5,3,7,101,18};
        int ans=longestConsecutive(a);
        
    }
    public static int longestConsecutive(int[] a) {
        int n=a.length;
        int count=0,res=0;
        HashSet<Integer> set=new HashSet<>(); 
        for(int i=0;i<n;i++)
        set.add(a[i]);

        for(Integer i:set)
        {
            if(set.contains(i-1)==false)
            {
                count=1;
                while(set.contains(i+1))
                {
                    i+=1;
                    count++;
                }
                res=(res<count)?count:res;
            }
        }
        return res;
    }
}
