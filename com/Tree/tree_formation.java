package com.Tree;

public class tree_formation {
      static TreeNode  root=null;
    public static TreeNode buildTree(int inorder[], int preorder[], int n)
    {
        if(inorder.length==1)
        {
            return new TreeNode(inorder[0]);
        }
        root=null;
        
        return constructTree(preorder,inorder,0,n-1,0,n-1);
         
    }
    public static TreeNode constructTree(int[] preorder,int[] inorder,int beg,int end,int pbeg,int pend)
    {
        //System.out.println("beg "+beg+" end "+end+" pbeg "+pbeg+" pend "+pend);
        if(pbeg>pend || beg>end)
        return null;
        
        TreeNode node=new TreeNode(preorder[pbeg]);
        if(root == null)
        root=node;
        
        int idx=beg;
        while(inorder[idx]!=preorder[pbeg])idx++;
        int count=idx-beg;
        
        node.left=constructTree(preorder,inorder,beg,beg+count-1,pbeg+1,pbeg+count);
        node.right=constructTree(preorder,inorder,beg+count+1,end,pbeg+count+1,pend);
        return node;
    }
    public static void main(String[] args) {
        int a[]={1,6,8,7};
        int b[]={1,6,7,8};
        TreeNode node=buildTree(a, b,4);
        postorder(node);
    }
    public static void postorder(TreeNode node) {
        if(node.left!=null)
        postorder(node.left);
        if(node.right!=null)
        postorder(node.right);
        System.out.print(node.val+" ");
        
    }
}
