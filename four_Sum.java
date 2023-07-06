/*
 * LEETCODE Q:18
 */

import java.util.*;
import java.lang.*;

public class four_Sum {
    
   public List<List<Integer>> fourSum(int[] nums, int target) {
         int n = nums.length; // size of the array
        List<List<Integer>> ans = new ArrayList<>();

        // sort the given array:
        Arrays.sort(nums);

        // calculating the quadruplets:
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            long t1=target-nums[i];
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                long t2=t1-nums[j];
                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                  long t3=0;
                    t3+=nums[k];
                    t3 += nums[l];
                    if (t3 == t2) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (t3 < t2) k++;
                    else l--;
                }
            }
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