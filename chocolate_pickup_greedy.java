import java.util.*;
import java.lang.*;
import java.io.*;

public class chocolate_pickup_greedy {
    public int solve(int n, int m, int a[][]){
        int ans=Integer.MIN_VALUE;
        int aux_ans=Integer.MIN_VALUE;
        int i1=0,j1=0,i2=0,j2=m-1;
        int f_j1=0,f_j2=m-1,f_i1=0,f_i2=0;
        int s1=0,s2=0;
        while(f_i1+1<n && f_i2+1<n)
        {
            s1+=a[f_i1][f_j1];
            s2+=a[f_i2][f_j2];
            for(int t1=f_j1-1;t1<f_j1+2;t1++)
            {
                int a1=0;
                if(t1<0|| t1>=m)continue;
                a1=s1+a[f_i1+1][t1];
                for(int t2=f_j2-1;t2<f_j2+2;t2++)
                {
                    int a2=0;
                    if(t2==t1|| t2<0 || t2>=m)continue;
                    a2=s2+a[f_i2+1][t2];
                    if(a1+a2>aux_ans)
                    {
                        f_j1=t1;f_j2=t2;
                        aux_ans=a1+a2;
                    }
                    
                }
            }
            ans=Math.max(ans,aux_ans);
            f_i1++;f_i2++;
        }
        return ans;
        // Code here
    }

    public static void main(String[] args) throws FileNotFoundException {
        File f1 = new File("/home/kushal/Desktop/leetCode/chocolate_pick.txt");
        Scanner sc = new Scanner(f1);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        chocolate_pickup_greedy c = new chocolate_pickup_greedy();
        int ans = c.solve(n, m, a);
        System.out.println(ans);
    }
}
