import java.lang.*;
import java.io.*;
import java.util.*;
class Pair{
    int i;
    int d;
    Pair(int i,int d)
    {
        this.i=i;
        this.d=d;
    }
}
public class prims {
    int[]vis;
    public int prim(List<List<Pair>> adj,int v)
    {
        int ans=0;
        vis=new int[v];
        Queue<Pair>q=new PriorityQueue<>((p1,p2)->p1.d-p2.d);
        q.add(new Pair(0,0));
        while(q.size()>0)
        {
            Pair p=q.remove();
            int i=p.i;
            List<Pair>l=adj.get(i);
            if(vis[i]==1)continue;
            vis[i]=1;
            ans+=p.d;
            for(Pair pr:l)
            {
                int nhb=pr.i;
                int d=pr.d;
                q.add(new Pair(nhb,d));
            }
        }
        return ans;
    }
       public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            List<List<Pair>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                adj.get(u).add(new Pair(v, w));
                adj.get(v).add(new Pair(u, w));
            }

            prims ob = new prims();

            int ans = ob.prim(adj,V);

            System.out.println(ans);
        }
    }
}
