import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Min_Cost_Wt {
    public int minimumCost(int a[], int n,int w) throws IOException
	{
	    int[][]dp=new int[n+1][w+1];
	    
	    for(int i=0;i<=n;i++)
	    Arrays.fill(dp[i],-1);
		FileWriter myWriter1 = new FileWriter("Min_Cost.txt");
		int ans=cost(n,a,w,n,dp,myWriter1);
		
		if(ans>=1e8)
		ans=-1;
		myWriter1.close();
		return ans;
		
	}
	int cost(int i,int[]a,int w,int n,int[][]dp,FileWriter myWriter1) throws IOException
	{
        myWriter1.append(i+" "+w+"->"+"\n");
	    if(i==0 && w==0) return 0;
	    if(i==0) return (int)1e8;
	    
	    if(w==0) return 0;
	    
	    if(dp[i][w]!=-1) return dp[i][w];
	    
	    
	    int drop=cost(i-1,a,w,n,dp,myWriter1);
	    int pick=(int)1e8;
	    
	    if(w>=i &&  a[i-1]!=-1) 
	    pick=a[i-1]+cost(i,a,w-i,n,dp,myWriter1);
	    
	    myWriter1.append(i+" "+w+" "+pick+" "+drop+"\n");
	    
	    int aux_ans=Math.min(pick,drop);
	    
	    dp[i][w]=aux_ans;
	    
	    return dp[i][w];
	}
    public static void main(String[] args) throws IOException {
        int []a={20,10,4,50,100};
        Min_Cost_Wt m=new Min_Cost_Wt();
        int ans=m.minimumCost(a,a.length,5);
        System.out.println(ans);
    }
}
