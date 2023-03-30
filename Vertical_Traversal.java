import java.lang.*;
import java.util.*;
import com.Tree.TreeConstruction;
import com.Tree.TreeNode;

public class Vertical_Traversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();

        Vt(root, 0, 0, map);

        for (Map.Entry<Integer, List<List<Integer>>> set : map.entrySet()) {
            List<List<Integer>> b = set.getValue();
            List<Integer> c = new ArrayList<>();
            for (List<Integer> a : b) {
                c.add(a.get(0));
            }
            res.add(c);
        }

        System.out.println(res);
        return res;
    }
    
        
         public static int bs(List<List<Integer>> b,int h,TreeNode node)
         {
            int low=0;
            int pos=b.size();
            int hi=pos-1;
             while(low<=hi)
             {
                 int mid=low+(hi-low)/2;
                 if (b.get(mid).get(1)> h || b.get(mid).get(1)==h && b.get(mid).get(0)>node.val)

                 {
                    pos=mid;
                     hi=mid-1;
                 }
                 else
                 {
                 pos=mid+1;
                 low=mid+1;
                 }
             }
             if(low < b.size() && (low >= hi) && (b.get(low).get(1)< h || (b.get(low).get(1)==h && b.get(low).get(1)<node.val)))
             pos=low;
             return pos;
         }
    public void Vt(TreeNode node, int d, int h, TreeMap<Integer, List<List<Integer>>> map) {
        if (node != null && node.val != -1) {

            if (map.containsKey(d)) {
                List<List<Integer>> b = map.get(d);
                    int i=b.size()-1;
                    int pos=b.size();
                    int pos1=bs(b,h,node);
                    while(i>=0)
                    {
                    List<Integer> a = b.get(i);
                    if (a.get(1) > h || a.get(1)==h && a.get(0)>node.val)
                        pos--;   
                    else
                    break;   
                    i--; 
                    }
                
                List<Integer> a1 = new ArrayList<>();
                a1.add(node.val);
                a1.add(h);
                b.add(pos,a1);
            } else {

                List<Integer> a = new ArrayList<>();
                a.add(node.val);
                a.add(h);
                List<List<Integer>> b = new ArrayList<>();
                b.add(a);
                map.put(d, b);
            }
            Vt(node.left, d - 1, h + 1, map);
            Vt(node.right, d + 1, h + 1, map);
        }
    }

    public static void main(String[] args) {
        Integer inp[] = {0,8,1,null,null,3,2,null,4,5,null,null,7,6};
        TreeConstruction t = new TreeConstruction();
        TreeNode root = t.formTree(inp);
        Vertical_Traversal v = new Vertical_Traversal();
        v.verticalTraversal(root);
        // System.out.println(res);
    }

}
