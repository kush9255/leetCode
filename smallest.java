//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class smallest{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        while(l<r)
        {
            int pivot=partion(arr,l,r);
            if(pivot == k-1)
            return arr[pivot];
            if(pivot<(k-1))
            l=pivot+1;
            if(pivot >(k-1))
            r=pivot-1;
        }
        return arr[l];
    }
    public static int partion(int[] arr,int l,int r)
    {
        int i=l-1;
        int x=arr[r];
       
        for( int j=l;j<r;j++)
        {
            if(arr[j]<=x)
            {
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,r);
        return i+1;
    }
    public static void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main (String[] args) {
        int [] a ={7,10,4,3,20,15};
        int k=3;
        int res=kthSmallest(a, 0, a.length-1, k);
        System.out.println(res);
        }
}
