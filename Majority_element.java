import java.util.*;
import java.lang.*;

public class Majority_element {
    public static List<Integer> majorityElement(int[] a) {
    List<Integer> ans=new ArrayList<>();
    int count=0;
    int n=a.length;
    int mark=n/3;
    long n1=Long.MIN_VALUE;
    long n2=Long.MIN_VALUE;
    int cnt1=0,cnt2=0;
    for(int i=0;i<n;i++){
        if(cnt1==0 && a[i]!=n2){
            n1=a[i];
            cnt1++;
        }
        else if(cnt2==0 && a[i]!=n1){
            n2=a[i];
            cnt2++;
        }
        else if (cnt1!=0 && a[i]==n1)
        cnt1++; 
        else if (cnt2!=0 && a[i]==n2)
        cnt2++;
        else{
            cnt1--;
            cnt2--;
        }
    }
    cnt1=0;cnt2=0;
    for(int i=0;i<n;i++)
    {
        if(a[i]==n1)cnt1++;
        if(a[i]==n2)cnt2++;
    }
    if(cnt1>mark)
    {
        ans.add((int)(n1));
    }
    if(cnt2>mark)
    {
        ans.add((int)(n2));
    }
    else
    {
        ans.add(-1);
    }

    return ans;
        
    }
    public static void main(String[] args) {
        int[]a={1,2};
        List<Integer>res=majorityElement(a);
        System.out.println(res);
    }
}
