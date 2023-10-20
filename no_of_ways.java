import java.util.*;
import java.io.*;
class Pair{
    int i;
    int d;
    Pair(int i,int d){
        this.i=i;
        this.d=d;
    }
}
public class no_of_ways{

    static PriorityQueue<Pair>q;
    static int[]dis;
    static int[]ways;
   static int countPaths(int n, List<List<Integer>> a) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        q=new PriorityQueue<>((n1,n2)->n1.d-n2.d);
        int m=a.size();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<Pair>());
        dis=new int[n];
        ways=new int[n];
        Arrays.fill(dis,1,n,Integer.MAX_VALUE);
        dis[0]=0;
        ways[0]=1;
        for(int i=0;i<m;i++)
        {
            
            List<Integer>d=a.get(i);
            adj.get(d.get(0)).add(new Pair(d.get(1),d.get(2)));
            adj.get(d.get(1)).add(new Pair(d.get(0),d.get(2)));
        }
        q.add(new Pair(0,0));
    
       dijkastra(adj,n-1);
        return ways[n-1];
    }
    static void dijkastra(ArrayList<ArrayList<Pair>> adj,int n)
    {
        int m=(int)(1e9+7);
        while(q.size()>0){
            Pair node=q.remove();
            int i=node.i;
            int d=node.d;
            ArrayList<Pair>l=adj.get(i);
            for(Pair p:l)
            {
                int k=p.i;
                int d_k=p.d;
                long pre=dis[k];
                long a_d=((long)d+(long)d_k);
                if(pre>a_d)
                {
                    q.add(new Pair(k,(int)a_d));
                    dis[k]=(int)a_d;
                }
                if(pre<a_d)continue;
                long ans=((long)ways[i]+(long)ways[k])%m;
                ways[k]=(int)ans;
                
            }
        
        }
        
    }
     public static void main(String[] args) throws FileNotFoundException {
        File file=new File("/home/kushal/Desktop/leetCode/ways.txt");
        Scanner sc = new Scanner(file);
    
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                List<Integer>l=new ArrayList<>();
                l.add(sc.nextInt());
                l.add(sc.nextInt());
                l.add(sc.nextInt());
                adj.add(l);
            }
            int res=countPaths(V, adj);
            System.out.println(res);
    }
    
}
