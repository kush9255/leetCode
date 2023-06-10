public class median_in_matrix {

static int median(int a[][], int n, int m) {
        
    int min=a[0][0];
    int max=a[0][m-1];
    
    for(int row=1;row<n;row++)
    {
    min=Math.min(min,a[row][0]);
    max=Math.max(max,a[row][m-1]);
    }
    int beg=min;
    int end=max;
    int ans=(n*m)/2;
    
    while(beg<=end)
    {
        int mid=end-(end-beg)/2;
        int num=0;
      
        for(int i=0;i<n;i++)
        num+=count(a[i],m,mid);
        
       
        if(num>ans)
        end=mid-1;
       
        else
        beg=mid+1;
    }
    return beg;
}
static int count(int[]a,int m,int key)
{
    int count=0;
    int beg=0;
    int end=m-1;
    
    while(beg<=end)
    {
        int mid=end-(end-beg)/2;
        
        if(a[mid]<=key)
        beg=mid+1;
    
        else
        end=mid-1;
        
    }
    return beg;
}
public static void main(String[] args) {
    int[][]a={{1, 3, 5},{2, 6, 9},{3, 6, 9}};
    int n=3,m=3;
    int ans=median(a,n,m);
    System.out.println(ans);
}
}