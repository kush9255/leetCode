import java.util.*;

public class jerry {
    int vis[][];
    int path[][];
    int ans;
    public  void traverse_1(int i,int j,int[][]a,int x,int y,int cnt,int n,int time)
    {
        if(i<0 || i==n || j<0 || j==n || a[i][j]==1 || vis[i][j]==1 && path[i][j]==1)return;
            if(i==x && j==y)
            {
                if(cnt!=0)
                return;
                else
                ans=Math.min(time,ans);
            }
            vis[i][j]=1;
            path[i][j]=1;
            if(a[i][j]==2)
            {   
                cnt--;
            }
            time++;
            int[]row={-1,0,0,1};
            int[]col={0,-1,1,0};
            for(int k=0;k<4;k++)
            {
                traverse_1(i+row[k],j+col[k], a, x, y, cnt, n,time);
            }
            vis[i][j]=0;
            path[i][j]=0;
            time--;
            
        return ;
    }
    public static void main(String[] args) {
        int [][]a={{0,2,2,1},{0,2,1,0},{0,1,1,0},{0,0,0,0}};
        int x=1;
        int y=0;
        int cnt=0;
        int n=a.length;
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
        if(a[i][j]==2)cnt++;
        jerry j=new jerry();
        j.vis=new int[n][n];
        j.path=new int[n][n];
        j.ans=Integer.MAX_VALUE;
        j.traverse_1(0,0,a,x,y,cnt,n,0);
        int res=(j.ans==Integer.MAX_VALUE)?-1:j.ans;
        System.out.println(res);
    }
}
