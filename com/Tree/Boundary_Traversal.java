package com.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;


public class Boundary_Traversal {

    TreeNode root=null;
	Stack<TreeNode> st=new Stack<>();
    ArrayDeque<TreeNode>q=new ArrayDeque<>();
    ArrayList<Integer>ans=new ArrayList<>();
	
	boolean leaf_TreeNode(TreeNode node)
	{
    if(node.left==null && node.right==null)
    return true;
    return false;
    }
	
	ArrayList <Integer> boundary(TreeNode node)
	{
	    if(node!=null)
	    {
            root=node;
            if(!leaf_TreeNode(root))
            ans.add(node.val);
            
            if(root.left!=null)
            Leftbound(root.left);
            
            print_leaf(root);
             
            if(root.right!=null)
            {
            Rightbound(root.right);
            }
	    }
        st.clear();
        q.clear();
        return ans;
	}
	
	void print_leaf(TreeNode node)
	{
	    if(node==null)
	    return;
	    
	    if(node.left==null && node.right==null)
	    ans.add(node.val);
	    
	    else
	    {
	        print_leaf(node.left);
	        print_leaf(node.right);
	    }
	    return ;
	}
	void Leftbound(TreeNode node)
	{
	    if(node==null)
	    return;
	    
	    if(!leaf_TreeNode(node))
	    q.add(node);
	    
	    if (node.left!=null)
	    Leftbound(node.left);
	    
	    else if(node.right!=null)
        Leftbound(node.right);

        
        while(q.size()>0)
        ans.add(q.remove().val);
          
        return;
	}
	
	void Rightbound(TreeNode node)
	{
	    if(node==null)
	    return;
	    
	    if(!leaf_TreeNode(node))
	    st.push(node);
	    
	    if(node.right!=null)
	    Rightbound(node.right);
	    
	    else if(node.left!=null)
	    Rightbound(node.left);
        

        while(st.size()>0)
        {
            TreeNode n=st.pop();
            ans.add(n.val);
        }
        return;
	}
    public static void main(String[] args) {
        Integer[]a={4,10,null,5,5,null,6,7,null,8,8,null,8,11,null,3,4,null,1,3,null,8,6,null,11,11,null,5,8};
        TreeConstruction t=new TreeConstruction();
        TreeNode node=t.formTree(a);
        Boundary_Traversal b=new Boundary_Traversal();
        ArrayList<Integer>ans=b.boundary(node);
        System.out.println(ans);
    }
}
