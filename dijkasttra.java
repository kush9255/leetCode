import java.util.*;
import java.io.*;
import java.lang.*;
class Node{
    int i; // signifies the node from startting index; adk[k]=node.i then edge from k->i and 
    int d;
    int par;
    Node(int i,int d,int par)
    {
        this.i=i;
        this.d=d;
        this.par=par;
    }
}
public class dijkasttra {
    
static PriorityQueue<Node>q;
static int[]dis;
static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        dis=new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        q=new PriorityQueue<>((n1,n2)->(n1.d!=n2.d)?(n1.d-n2.d):(n1.i-n2.i));
       

        dis[S]=0;
        
        //Relexation starts here
        q.add(new Node(S,0,-1));
        
        while(q.size()>0)
        {
            Node node=q.poll();
            int i=node.i;
            int d=node.d;
            int par=node.par;
            ArrayList<ArrayList<Integer>>aux=adj.get(i);
            for(ArrayList<Integer>l:aux)
            {
                int nhb=l.get(0);
                int n_d=l.get(1);
                if(par!=nhb)
                {
                int pre=dis[nhb];    
                dis[nhb]=Math.min(dis[nhb],d+n_d);
                if(pre>dis[nhb])
                q.add(new Node(nhb,dis[nhb],i));
                }
            }
        }
        
        
        return dis;
    }


    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            dijkasttra ob = new dijkasttra();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }


    public int[] dijkstra(List<List<Pair>> adj, int v, int s) {
        return null;
    }
}




    