public class first_last_index {
    public static int[] searchRange(int[] a, int target) {

                 int[] res=new int[2];
                 res[0]=first_index(a,target);
                 res[1]=last_index(a,target);
                 return res;
         }
        static int last_index(int[]a,int target)
         {
             int index=-1;
             int low=0;
             int hi=a.length-1;
             while(low<=hi)
             {
                 int mid=low+(hi-low)/2;
                 if(a[mid]<=target)
                 {
                     low=mid+1;
                 }
                 else
                 hi=mid-1;
                 if(a[mid]==target)
                 index=mid;
             }
             return index;
         }
         static int first_index(int[]a,int target)
         {
             int index=-1;
             int low=0;
             int hi=a.length-1;
             while(low<=hi)
             {
                 int mid=low+(hi-low)/2;
                 if(a[mid]>=target)
                 {
                     hi=mid-1;
                 }
                 else
                 low=mid+1;
                 if(a[mid]==target)
                 index=mid;
             }
             return index;
         }
        
    public static void main(String[] args) {
        int[]nums={0,0,1,2,3,3,4};
        int target=2;
        searchRange(nums,target);
    }
    
}
