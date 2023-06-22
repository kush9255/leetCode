package com.Tree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;



class Pair{
    TreeNode node;
    int hd;
    
    Pair(TreeNode node,int hd)
    {
        this.node=node;
        this.hd=hd;
    }
}

public class top_view {
    
     static ArrayList<Integer> topView(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0)); 
        while(!q.isEmpty()) {
            Pair it = q.remove();
            int hd = it.hd; 
            TreeNode temp = it.node; 
            if(map.get(hd) == null) map.put(hd, temp.val); 
            if(temp.left != null) {
                
                q.add(new Pair(temp.left, hd - 1)); 
            }
            if(temp.right != null) {
                
                q.add(new Pair(temp.right, hd + 1)); 
            }
        }
    
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
        
    }
    
    public static void main(String[] args) {
        Integer[]a={7,5,8,2,6,null,56,1,3,null,null,10,57,null,null,null,4,9,51,null,null,null,null,null,null,13,52,12,45,null,55,11,null,20,49,54,null,null,null,15,44,48,50,53,null,14,18,23,null,46,null,null,null,null,null,null,null,16,19,21,30,null,47,null,17,null,null,null,22,28,34,null,null,null,null,null,null,24,29};
        TreeConstruction t=new TreeConstruction();
        TreeNode node=t.formTree(a);
        top_view b=new top_view();
        ArrayList<Integer>ans=b.topView(node);
        System.out.println(ans);
    }
}
