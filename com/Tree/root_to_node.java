package com.Tree;

import java.util.ArrayList;


public class root_to_node {
      ArrayList<ArrayList<Integer>>m=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> Paths(TreeNode root){
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        ArrayList<Integer>aux=new ArrayList<>();
        
        print(root,aux);
        
        for(ArrayList<Integer>l:m)
        ans.add(l);
        
        m.clear();
        return ans;
    }
    ArrayList<Integer> print(TreeNode node,ArrayList<Integer> l)
    {
        ArrayList<Integer>left=new ArrayList<>();
        ArrayList<Integer>right=new ArrayList<>();
        if(node.left==null && node.right==null)
        {
            l.add(node.val);
            return l;
        }
        l.add(node.val);
        if(node.left!=null && node.left.val!=-1)
        left=print(node.left,l);
        if(node.right!=null && node.right.val!=-1)
        right=print(node.right,l);
        
        if(left.size()>0)
        m.add(left);
        if(right.size()>0)
        m.add(right);
        
        return l;
        }
    public static void main(String[] args) {
        Integer[]a={1,2,3,4,5,6,null,null,null,null,7};
        TreeConstruction t=new TreeConstruction();
        TreeNode node=t.formTree(a);
        root_to_node r=new root_to_node();
        ArrayList<ArrayList<Integer>>ans=r.Paths(node);

        System.out.println(ans);
    }
}
