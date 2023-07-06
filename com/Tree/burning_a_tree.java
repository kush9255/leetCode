package com.Tree;

import java.util.ArrayList;
class Path{
    TreeNode node;
    int left;
    Path(TreeNode n,int left)
    {
        this.node=n;
        this.left=left;
    }
}

public class burning_a_tree {
    
    public static int minTime(TreeNode root, int target) 
    {
        burning_a_tree s=new burning_a_tree();
        ArrayList<Path> path=new ArrayList<>();
        path=s.rootToTreeNode(root,target);
        int time=s.burn(path);
        return time;
    }
    public ArrayList<Path>  rootToTreeNode(TreeNode node,int target)
    {
         ArrayList<Path> left=new ArrayList<>();
         ArrayList<Path> right=new ArrayList<>();
         
         if(node==null)
         return right;
         
        if(node.val==target)
        {
            Path p=new Path(node,0);
            ArrayList<Path> ans=new ArrayList<>();
            ans.add(p);
            return ans;
        }
        left=rootToTreeNode(node.left,target);
        if(left.size()>0)
        {
            Path p1=new Path(node,1);
            left.add(0,p1);
            return left;
        }
        right=rootToTreeNode(node.right,target);
        if(right.size()>0)
        {
            Path p1=new Path(node,0);
            right.add(0,p1);
        }
        return right;
    }
    public int depth(TreeNode node)
    {
        if(node==null)
        return -1;
        
        int left=0,right=0;
        left=depth(node.left);
        right=depth(node.right);
        
        int h=Math.max(left,right);
        
        return 1+h;
    }
    
    public int burn(ArrayList<Path> path)
    {
        int s=path.size();
        int ref=0,extra=0,time=0;
        for(int i=s-1;i>=0;i--)
        {
            int aux=0,l=0,r=0;
            Path p=path.get(i);
            TreeNode n=p.node;
            int left=p.left;
            
            if(i==s-1)
            {
                ref=depth(n);
                time=ref;
            }
            else
            {
                extra=s-1-i;
                if(left==0)
                {
                     r=Math.max(extra,ref);
                     l=extra+1+depth(n.left);
                     aux=Math.max(l,r);
                }
                if(left==1)
                {
                     l=Math.max(extra,ref);
                     r=extra+1+depth(n.right);
                     aux=Math.max(l,r);
                }
            }
            time=Math.max(time,aux);
        }
        return time;
    }
    public static void main(String[] args) {
        Integer a[]={1,2,3,4,5,null,6,null,null,7,8,null,9,10,11,null,null,null,12,null,null,null,13};
        int tarhet=8;
        burning_a_tree b=new burning_a_tree();
        TreeConstruction t=new TreeConstruction();
        TreeNode node=t.formTree(a);
        int ans=b.minTime(node, tarhet);
        System.out.println(ans);
        
    }
}

