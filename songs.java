import java.util.*;
import java.lang.*;
import java.io.*;
public class songs {
    static int[]ans;
    public static void findPrefOrder(int[][]a,int n,int m,FileWriter w) throws IOException
    {
        ans=new int[m];
        createGraph(a,n,m,w);

    }
    public static void createGraph(int[][]a,int n,int m,FileWriter w) throws IOException
    {
        int c=0;
        int[]cnt=new int[m];
        for(int j=0;j<m;j++)
        {
            int max=Integer.MIN_VALUE;
            int m_c=0;
            for(int i=0;i<n;i++)
            {
                if(cnt[a[i][j]]==Integer.MIN_VALUE)
                continue;
                cnt[a[i][j]]++;
                if(cnt[a[i][j]]>m_c)
                {
                    max=a[i][j];
                    m_c=cnt[a[i][j]];
                }
                else if(cnt[a[i][j]]==m_c && a[i][j]<max)
                {
                    max=a[i][j];
                    m_c=cnt[a[i][j]];
                }
            }
            w.write("n:"+max+" "+"c:"+m_c+" ");
            if(c<m && cnt[max]>=n/2)
            {
            ans[c++]=max;
            cnt[max]=Integer.MIN_VALUE;
            m_c=0;
            }
        }
        w.write("\n");
        while(c<m)
        {
            for(int i=0;i<m && c<m;i++)
            if(cnt[i]!=Integer.MIN_VALUE)
            {
                ans[c]=i;
                cnt[i]=Integer.MIN_VALUE;
                c++;
            }
        }
        return ;
    }
    public static void main(String[] args) throws FileNotFoundException{
        try
        {
            File f=new File("songs.txt");
            Scanner sc = new Scanner(f);
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[][] inp=new int[n][m];

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                inp[i][j]=sc.nextInt();
            }
            FileWriter w=new FileWriter("songs_list.txt");
            findPrefOrder(inp,n,m,w);
            for(int i=0;i<m;i++)
            w.write(ans[i]+" ");
            w.write("\n");
            w.close();
            sc.close();
        }
        catch(IOException e)
        {
            if(e instanceof IOException || e instanceof FileNotFoundException)
            System.out.println(e.getMessage());
        }
    }
        
}
