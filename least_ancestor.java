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
public class least_ancestor {
    static TreeNode res=null;
    public static void main(String[] args) {
        ArrayDeque<TreeNode> q=new ArrayDeque<>();
        Integer[] inp={3,5,1,6,2,0,8,null,null,7,4};
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
            if(par !=null)
            {
            if(i+1<inp.length && inp[i+1]!=null)
            {
               
                TreeNode node=new TreeNode();
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
            if(i+1<inp.length && inp[i+1]==null)
            {
                TreeNode node=new TreeNode();
                node.val=-1;
                par.left=node;
            //q.add(new TreeNode(-1));    
            }
            if(i+2<inp.length && inp[i+2]==null)
            {
                TreeNode node=new TreeNode();
                node.val=-1;
                par.right=node;
            }
                if(root == null)
                root=par;   
            }
            }
        }
        TreeNode p=new TreeNode(5);
        TreeNode r=new TreeNode(6);
        printTree(root);
        lowestCommonAncestor(root,p,r);
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
            if(node.val!=-1)
            {
            if(node.left!=null)        
            q.add(node.left);
            if(node.right!=null)
            q.add(node.right);
            }
                if(node.val!=-1)
                System.out.print(node.val +" ");
                else
                {
                System.out.print("null ");
                }
                cnt--;
            }
        
            System.out.println();
        }
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null || p== null || q==null)
        return null;
        boolean ans=LCA(root,p.val,q.val);
        if(ans)
        System.out.println(res.val);
        else System.out.println("null");
        return res;
    
    }
    public static boolean LCA(TreeNode root,int p, int q)
    {
        if(root==null)
        return false;
        if(res!=null)
        return true;
        boolean self=(root.val==p || root.val==q);
         if(res!=null) return true;
        boolean left=LCA(root.left,p,q);
        if(res!=null) return true;
        boolean right=LCA(root.right,p,q);

        if((self && left) || (self && right) || (left && right))
        res=root;

        return self||left||right;
    }
    
    
}



