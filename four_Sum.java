import java.util.*;
import java.lang.*;

public class four_Sum {
    
    HashMap<Integer,List<List<Integer>>>sum_2=new HashMap<>();
    HashMap<Integer,List<List<Integer>>> sum_3=new HashMap<>();
    //HashMap<Integer,List<List<Integer>>> sum_4=new HashMap<>();
    public List<List<Integer>> fourSum(int[] a, int target) {
    
    Arrays.sort(a);
    for(int x:a)
    System.out.print(x+" ");
    int n=a.length;
    List<List<Integer>>ans=new ArrayList<>();
    for(int i=0;i<n-3;i++)
    {
        int num1=(i-1>=0)?a[i-1]:Integer.MIN_VALUE;
        int num=a[i];
        if(num==num1)continue;
        List<List<Integer>>aux_List;
        int sum=target-a[i];
        if(sum_3.containsKey(sum))
        aux_List=sum_3.get(sum);
        else
        {
        aux_List=threeSum(a,i+1,n,sum);
        sum_3.put(sum,aux_List);
        }
            for(List<Integer>l1:aux_List)
            {
               List<Integer>l=new ArrayList<>();
               l.add(a[i]);
               for(Integer x:l1)
               l.add(x);
               ans.add(l);
            }
    }
        return ans;
    }

    public List<List<Integer>> threeSum(int[]a,int beg,int n,int key)
    {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=beg;i<n-2;i++)
        {
            int num1=(i-1>=beg)?a[i-1]:Integer.MIN_VALUE;
            int num=a[i];
            if(num==num1)continue;
            List<List<Integer>>aux_List;
            int sum=key-a[i];
            if(sum_2.containsKey(sum))
            aux_List=sum_2.get(sum);
            else
            {
                aux_List=twoSum(a,i+1,n-1,sum);
                if(aux_List.size()>0)
                sum_2.put(sum,aux_List);
            }
            for(List<Integer>l1:aux_List)
            {
               List<Integer>l=new ArrayList<>();
               l.add(a[i]);
               for(Integer x:l1)
               l.add(x);
               ans.add(l);
            }
        }
        return ans;
    }
    public List<List<Integer>> twoSum(int[]a,int beg, int end,int sum)
    {
        List<List<Integer>>ans=new ArrayList<>();
        int i=beg;
        while(i<end)
        {
            int num1=(i-1>=beg)?a[i-1]:Integer.MIN_VALUE;
            int num=a[i];
            if(num==num1)
            {
                i++;
                continue;
            }
            if(a[i]+a[end]==sum)
            {
                List<Integer>l=new ArrayList<>();
                l.add(a[i]);
                l.add(a[end]);
                ans.add(l);
                i++;
            }
            else if(a[i]+a[end]<sum)
            i++;
            else
            end--;
        }
        return ans;
    }
     

    public static void main(String[] args) {
        //int a[]={-3,3,-2,-1,0,0,1,2};
        int a[]={-9,-2,7,6,-8,5,8,3,-10,-7,8,-8,0,0,1,-8,7};
        int k=4;
        four_Sum f=new four_Sum();
        List<List<Integer>>res=f.fourSum(a,k);
        System.out.println(res);
    }
}