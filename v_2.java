import java.lang.*;
import java.util.*;
import com.Tree.*;
import com.Tree.TreeNode;

public class v_2 {
    public ArrayList<Integer> verticalTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();

        Vt(root, 0, 0, map);

        for (Map.Entry<Integer, List<List<Integer>>> set : map.entrySet()) {
            List<List<Integer>> b = set.getValue();
            List<Integer> c = new ArrayList<>();
            for (List<Integer> a : b) {
                res.add(a.get(0));
            }
        }

        System.out.println(res);
        return res;
    }

    public void Vt(TreeNode node, int d, int h, TreeMap<Integer, List<List<Integer>>> map) {
        if (node != null && node.val != -1) {

            if (map.containsKey(d)) {
                List<List<Integer>> b = map.get(d);
                    int i=b.size()-1;
                    int pos=b.size();
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
        Integer inp[] = {1,2,3,4,6,5,7};
        TreeConstruction t = new TreeConstruction();
        TreeNode root = t.formTree(inp);
        Vertical_Traversal v = new Vertical_Traversal();
        v.verticalTraversal(root);
        // System.out.println(res);
    }

}
