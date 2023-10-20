//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends


public class flight {
    class Node{
    int i;
    int d;
    int steps=0;
    Node(int i,int d,int steps){
        this.i=i;
        this.d=d;
       
        this.steps=steps;
    }
}
    class Pair{
        int i;
        int d;
        Pair(int i,int d){
            this.i=i;
            this.d=d;
        }
    }

    int[] dis;
    Queue<Node>q;
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        int m=flights.length;
        dis=new int[n];
        //q=new ArrayDeque<>((n1,n2)->(n1.steps!=n2.steps)?(n1.steps-n2.steps):(n1.d-n2.d));
        q=new ArrayDeque<>();
        int allowed=k+1; //max permissible edges;
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<Pair>());
        
        for(int i=0;i<m;i++)
        {
            int[]d=flights[i];
            ArrayList<Pair>l=adj.get(d[0]);
            l.add(new Pair(d[1],d[2]));
        }
        //System.out.println(adj);
        int cnt=0;
        for(ArrayList<Pair>l:adj)
        {
        System.out.print(cnt+"->");   
        for(Pair node:l)
        System.out.print("{"+node.i+" "+node.d+"} ");
        System.out.println();
        cnt++;
        }
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        
        q.add(new Node(src,0,0));
        
        dijkastra(adj,dst,k+1);
        
        return (dis[dst]==Integer.MAX_VALUE)?-1:dis[dst];
    }
    void dijkastra(ArrayList<ArrayList<Pair>> adj,int dest,int stop)
    {
        while(q.size()>0)
        {
            Node node=q.remove();
            int i=node.i;
            int d=node.d;
            int steps=node.steps;
            if(steps>stop)continue;
            ArrayList<Pair>l=adj.get(i);
            
            for(Pair n:l)
            {
                int k=n.i;
                int d_k=n.d;
                int pre=dis[k];
                if(steps+1<=stop)
                {
                dis[k]=Math.min(dis[k],d+d_k);
                if(pre>dis[k])
                q.add(new Node(k,dis[k],steps+1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        File file=new File("/home/kushal/Desktop/leetCode/flights.txt");
        Scanner sc = new Scanner(file);

            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            flight obj = new flight();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
