public class rotated_search {
    public static int search(int a[], int l, int h, int x)
    {
        // l: The starting index
        // h: The ending index, you have to search the key in this range
        // Complete this function
        int beg=0;
        int end=h;
        int pos=-1;
        while(beg<=end)
        {
            int mid =end-(end-beg)/2;
            if(a[mid]==x)
            {
                pos=mid;
                break;
            }
            
            if(a[beg]<=a[mid])//left sorted
            {
                if(a[beg]<x && a[mid]>x)
                end=mid-1;
                else
                beg=mid+1;
            }
            else if (a[mid]<=a[end]) //right sorted
            {
                if(a[end]>x && a[mid] < x)
                beg=mid+1;
                else
                end=mid-1;
                
            }
                
        }
        return pos;
    }
    public static void main(String[] args) {
        int[]a={5,6,7,8,9,10,1,2,3};
        int ans=search(a, 0, a.length-1, 10);
        System.out.println(ans);
    }
}
