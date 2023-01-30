import java.lang.*;
import java.util.*;
import com.Tree.TreeNode;
import com.Tree.*;;

public class Diameter {
    static int d = Integer.MIN_VALUE;

    public static int diameterOfBinaryTree(TreeNode node) {
        height(node);
        return d;
    }

    public static int height(TreeNode node) {
        if (node == null)
            return 0;
        int l = height(node.left);
        int r = height(node.right);
        int h = Math.max(l, r);
        d = Math.max(d, (l + r));
        return 1 + h;
    }

    public static void main(String[] args) {
        Integer inp[] = { 1, 2 };
        //TreeConstruction p = new TreeConstruction();
        TreeConstruction t = new TreeConstruction();
        TreeNode root = t.formTree(inp);
        int res = diameterOfBinaryTree(root);
        System.out.println(res);
    }
}