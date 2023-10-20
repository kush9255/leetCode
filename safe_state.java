import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;


public class safe_state {

    int[]cycle;
    int[]vis;
    int[]path;
    
    int[]indeg;
    List<Integer> ans;
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        ans=new ArrayList<>();
        vis=new int[V];
        cycle=new int[V];
        indeg=new int[V];
        path=new int[V];
        ArrayList<Integer>zero=new ArrayList<>();
        //safe_state s=new safe_state();
        for(int i=0;i<V;i++)
        if(vis[i]==0)
        {
        cycleDetection(i,adj,V);
        }
        
        calc_indeg(adj,V);
        
        for(int i=0;i<V;i++)
        if(cycle[i]==0 && indeg[i]==0)
        zero.add(i);
        
       // System.out.println(zero);
        
        
        for(int i:zero)
        topological(i,adj,V);
        
        
        // for(int i=0;i<V;i++)
        // if(cycle[i]==1)
        // System.out.print(i+" ");
        // System.out.println();
        
        
    
         Collections.sort(ans);
         return ans;
        //return new ArrayList<Integer>();
        }
        void cycleDetection(int i,List<List<Integer>> adj,int n)
        {
            if(vis[i]==1)
            {
                if(path[i]==1 || cycle[i]==1)
                {
                    for(int k=0;k<n;k++)
                    if(path[k]==1)
                    cycle[k]=1;
                }
                return;
            }
            vis[i]=1;
            path[i]=1;
            List<Integer>l=adj.get(i);
            for(int k:l)
            cycleDetection(k, adj, n);
            path[i]=0;
            return;

            
        }
        void calc_indeg(List<List<Integer>> adj, int n)
        {
            for(int i=0;i<n;i++)
            {
                if(cycle[i]==1)
                continue;
                List<Integer>l=adj.get(i);
                for(int k:l)
                {
                indeg[k]++;
                }
            }
            /*
            for(int i=0;i<n;i++)
            System.out.print(indeg[i]+" ");
            System.out.println();
            */
        }
        void topological(int i, List<List<Integer>> adj,int n)
        {
            if(indeg[i]==0)
            {
                ans.add(i);
                List<Integer>l=adj.get(i);
                
                for(int k:l)
                {
                    indeg[k]--;
                    topological(k,adj,n);
                }
            }
            
        }
    public static void main (String[] args) throws FileNotFoundException {
        //System.out.println("enter values");
        File file=new File("/home/kushal/Desktop/leetCode/input.txt");
        Scanner sc = new Scanner(file);
        int T = 1;
        //System.out.println(T);
    
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }
            int c=0;
            for(List<Integer> l :adj)
            {
                System.out.println(c++ +"-> "+ l);
            }
            safe_state s=new safe_state();
            List<Integer> safeNodes = s.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        
    }

}
