import java.io.BufferedReader;
import java.io.IOException;
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
public class dijkastra2 {
    Queue<Pair>q;
    public int[] dijkastra(List<List<Pair>> adj,int n,int s)
    {
        int[]dis=new int[n];
        q=new PriorityQueue<>((p1,p2)->p1.d-p2.d);
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[s]=0;
        q.add(new Pair(s,0));
        while(q.size()>0)
        {
            Pair p=q.remove();
            int i=p.i;
            int d=p.d;
            List<Pair>l=adj.get(i);
            for(Pair pair:l)
            {
                int nhb=pair.i;
                int n_d=pair.d;
                if(d+n_d<dis[nhb])
                {
                    dis[nhb]=d+n_d;
                    q.add(new Pair(nhb,dis[nhb]));
                }
            }
        }
        return dis;
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

            int S = Integer.parseInt(read.readLine());

            dijkastra2 ob = new dijkastra2();

            int[] ptr = ob.dijkastra(adj,V,S);

            for (i = 0; i < V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
