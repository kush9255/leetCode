import java.lang.reflect.Array;
import java.util.ArrayDeque;

class TreeNode {
    Integer val;
    TreeNode left=null;
    TreeNode right=null;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class linearize {
    public static void main(String[] args) {
        ArrayDeque<TreeNode> q=new ArrayDeque<>();
        Integer[] inp={1,2,5,3,4,null,6};
        TreeNode root=null;
        TreeNode par;
        //TreeNode node;
        q.add(new TreeNode(inp[0]));
        for(int i=0;i<inp.length;i+=2)
        {
            int count=0;
            if(q.size()>0)
            {
            par=q.remove();
            if(i+1<inp.length && inp[i+1]!=null)
            {
                TreeNode node=new TreeNode();
                //TreeNode right=new TreeNode();
                node.val=inp[i+1];
                    par.left=node;
                    q.add(par.left);
            }
            if(i+2<inp.length && inp[i+2]!=null)
                {
                    TreeNode node=new TreeNode();
                    node.val=inp[i+2];
                    par.right=node;
                    q.add(par.right);
                }
                if(root == null)
                root=par;   
            }
        }
        printTree(root);
      flatten(root);
        while(root!=null)
        {
            System.out.println(root.val+" ");
            root=root.right;
        }
    }
    public static void printTree(TreeNode root)
    {
        TreeNode node=root;
        ArrayDeque<TreeNode> q=new ArrayDeque<>();
        q.add(root);
     //   System.out.println(root.val);
        while(q.size()>0)
        {
            int cnt=q.size();
            while (cnt!=0) {
            node=q.remove();
            if(node!=null)
            {
            if(node.left!=null)    
            q.add(node.left);
            if(node.right!=null)
            q.add(node.right);
            }
                if(node!=null)
                System.out.print(node.val +" ");
                else
                System.out.println("null ");
                cnt--;
            }
        
            System.out.println();
        }
        }
    
    
    public static TreeNode flatten(TreeNode root) {
      
        TreeNode lastnode=null;
         TreeNode right;
         TreeNode left;
            TreeNode slkt;
    
    if(root!=null)
    {
        
         if(root.left==null && root.right==null)
        {
            return root;
        }
        else if(root.right!=null)
         lastnode=flatten(root.right);
        if(root.left!=null && root.right==null)
        {
            root.right=root.left;
            root.left=null;
            lastnode= flatten(root.right);
        }
        if(root.left!=null && root.right !=null)
        {
             right=root.right;
            left=root.left;
             slkt=flatten(root.left);
            //root.left=null;
            slkt.right=right;
            root.right=root.left;
            root.left=null;
        }
        return lastnode;
    }
    return null;
    
}
}
