/*
 * Q 560 leetcode very imp. here complement approach doesn't work when sum itself is 0
 */
import java.util.*;
import java.io.*;
public class subarray_sum {
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
      
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int a[]={1,-1,0,0,0};
        System.out.println(subarraySum(a, 0));
    }
}