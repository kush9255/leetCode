import java.util.*;
import java.lang.*;

public class four_Sum {
    
    public static ArrayList<ArrayList<Integer>> fourSum(int[] a, int k) {
        HashMap<String,Boolean>map=new HashMap<>();
        int n=a.length;
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        Arrays.sort(a);
        //for(int i : a)
        //System.out.print(i+" ");
        for (int i=0;i<n-3;i++){
            int sum=k-a[i];
            ArrayList<ArrayList<Integer>> aux_res=threeSum(a,i+1,n,sum,map);
            if(aux_res.size()>0){
                String key=a[i]+"";
                 for(int p=0;p<aux_res.size();p++){
                     ArrayList<Integer>aux_List=aux_res.get(p);
                     for (int s2:aux_List)
                     key+=s2+"";
                     if (!map.containsKey(key)){
                     aux_List.add(0,a[i]);
                     res.add(p,aux_List);
                     map.put(key,true);
                     }
                 }
             }
         }
         return res;
            
        }
    
     public static ArrayList<ArrayList<Integer>> threeSum(int[]a,int beg,int n,int k,HashMap<String,Boolean>map){
         int end=n;
          ArrayList<ArrayList<Integer>>res=new ArrayList<>();
         for(int i=beg;i<end-2;i++)
         {
             int sum=k-a[i];
             ArrayList<ArrayList<Integer>> aux_res=twoSum(a,i+1,n,sum,map);
             if(aux_res.size()>0){
                String key=a[i]+"";
                 for(int p=0;p<aux_res.size();p++){
                     ArrayList<Integer>aux_List=aux_res.get(p);
                     for (int s2:aux_List)
                     key+=s2+"";
                     if (!map.containsKey(key)){
                     aux_List.add(0,a[i]);
                     res.add(p,aux_List);
                     map.put(key,true);
                     }
                 }
             }
         }
         return res;
     }
     
    public static ArrayList<ArrayList<Integer>> twoSum(int[]a,int i,int n,int k,HashMap<String,Boolean>map){
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        int j=n-1;
        while(i<j){
            if(a[i]+a[j]==k)
            {
            String key=a[i]+""+a[j]+"";
            if(!map.containsKey(key)){    
            ArrayList<Integer>list=new ArrayList<>();    
            list.add(a[i]);
            list.add(a[j]);
            res.add(list);
            map.put(key,true);
            }
            i++;
            }
            else if(a[i]+a[j]<k) i++;
            else if (a[i]+a[j]>k) j--;
        }
        return res;
    }
    public static void main(String[] args) {
        int a[]={-3,-2,-1,0,0,1,2,3};
        int k=0;
        ArrayList<ArrayList<Integer>>res=fourSum(a,k);
        System.out.println(res);
    }
}