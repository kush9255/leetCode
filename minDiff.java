//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner14;

  

// User function Template for Java

class minDiff {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
       /* for(int i=0;i<n;i++)
        {
            if(arr[i]<k)
            arr[i]+=k;
            else
            arr[i]-=k;
        }
        */
        int diff=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        Arrays.sort(arr);
        diff=arr[n-1]-arr[0];
        for(int i=0;i<n-1;i++)
        {
        if(arr[i+1]<k)continue;
         min = Math.min(arr[0] + k, arr[i+1] - k);
        max = Math.max(arr[n - 1] - k, arr[i] + k);
        if (max < min) continue;      // as max till now can't be smaller than min till now hence ignore that element.
        diff = Math.min(diff, max - min);
        }
      return diff;
    }
    public static void main(String[] args) throws Exception {
        int[]a={6 ,1 ,9 ,1 ,1 ,7 ,9 ,5 ,2 ,10};
      int k=4;
     // int ans=findKthLargest(a,k);
      //System.out.println(ans);
            int ans = new minDiff().getMinDiff(a, a.length, k);
            System.out.println(ans);
        }
}
