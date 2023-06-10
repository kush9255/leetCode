package com.Tree;
import java.util.Scanner;
import com.Tree.TreeNode;

import java.util.ArrayDeque;
public class TreeConstruction {
   
static TreeNode root=null;

public TreeNode formTree(Integer[]inp)
{
    ArrayDeque<TreeNode> q=new ArrayDeque<>();
   // Integer[] inp={3,5,1,6,2,0,8,null,null,7,4};
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
    return root;
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
            System.out.print("null");
            }
            cnt--;
        }
    
        System.out.println();
    }
}

    
}
