import java.util.*;
import java.io.*;
import java.lang.*;
class Edge
{
    int i;
    int j;
    int w;
    Edge(int i,int j,int w)
    {
        this.i=i;
        this.j=j;
        this.w=w;
    }
}
public class disjoint{
    static int[]par;
    static int[]size;
    public static int mst_disjoint(int[][]graph,int n,int m)
    {
        int ans=0;
        par=new int[n];
        size=new int[n];

        for(int i=0;i<n;i++)
        par[i]=i;
        List<Edge> edges =new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            int[]a=graph[i];
            edges.add(new Edge(a[0],a[1],a[2]));
            // edges.add(new Edge(a[1],a[0],a[2]));
        }
        Collections.sort(edges,(e1,e2)->e1.w-e2.w);
        ans=create_mst(edges);
        return ans;
    }
    public static int create_mst(List<Edge>edges)
    {
        int ans=0;
        int n=edges.size();
        for(int k=0;k<n;k++)
        {
            Edge e=edges.get(k);
            int pi=find_par(e.i);
            int pj=find_par(e.j);
            if(pi!=pj)
            {
                find_union(e.i, e.j);
                ans+=e.w;
            }

        }
        return ans;
    }
    public static int find_par(int i)
    {
        if(i==par[i])
        return i;
        par[i]=find_par(par[i]);
        return par[i];
    }
    public static void find_union(int i,int j)
    {
        if(size[i]<size[j])
        {
            par[j]=i;
            size[i]+=size[j];
        }
        else
        {
            par[i]=j;
            size[j]+=size[i];
        }
    }
    public static void main(String[] args) {
        try {
            File f=new File("graph.txt");
            Scanner sc=new Scanner(f);
            int t=sc.nextInt();
            while(t--!=0)
            {
                int n=sc.nextInt();
                int m=sc.nextInt();
                int[][]graph=new int[m][3];
                for(int i=0;i<m;i++)
                {
                    for(int j=0;j<3;j++)
                    graph[i][j]=sc.nextInt();
                }
                int ans=mst_disjoint(graph,n,m);
                System.out.println(ans);
            }
            
        } catch (IOException e) {
            if(e instanceof FileNotFoundException)
            System.out.println(e.getMessage());
            if(e instanceof EOFException)
            System.out.println(e.getMessage());
        }
    }
}


