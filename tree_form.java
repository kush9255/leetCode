import java.lang.*;
import java.util.*;

import javax.lang.model.util.ElementScanner6;
public class tree_form {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;
  
      TreeNode(int val) {
        this.val = val;
      }
      TreeNode() {
      }
    }
  
  static TreeNode root = null;
  
  public static TreeNode buildTree(int[] inorder, int[] postorder) {
    int in_start = 0;
    int in_end = inorder.length - 1;
    int post_start = 0;
    int post_end = in_end;
    HashMap<Integer, Integer>map = new HashMap<>();
  
    for (int i = post_end; i >= 0; i--)
    {
      int k = 0;
      int tar = postorder[i];
      while (inorder[k] != tar)
        k++;
      map.put(tar, k);
    }
 //   int idx=map.get(postorder[post_end]);
   root= treeForm(inorder, postorder, map, in_start, in_end, post_start, post_end);
  
    return root;
  }
  public static TreeNode treeForm(int[] inorder, int[] postorder, HashMap<Integer, Integer> map, int in_start, int in_end, int post_start, int post_end) {
    
    if(in_start>in_end)
    return null;
    TreeNode node = new TreeNode(postorder[post_end]);
    
    int idx = map.get(node.val);
    int n=idx-in_start;
    {
    if(idx<in_end)  
    node.right = treeForm(inorder, postorder, map, idx + 1, in_end, idx, post_end - 1);
    if(in_start<idx)
    node.left = treeForm(inorder, postorder, map, in_start, idx - 1, post_start,post_start+n-1);
    }
    return node;
  

}

  // input_section=================================================
  
  public static void display(TreeNode node) {
    if (node == null)
      return;
  
    StringBuilder sb = new StringBuilder();
    sb.append((node.left != null ? node.left.val : "."));
    sb.append(" -> " + node.val + " <- ");
    sb.append((node.right != null ? node.right.val : "."));
  
    System.out.println(sb.toString());
  
    display(node.left);
    display(node.right);
  
  }
  
  public static void solve() {
    int[] post = {2 ,5 ,11 ,6 ,7 ,4 ,9 ,15 ,12};
   
    int[] in={2 ,7 ,5 ,6 ,11 ,12 ,15 ,4 ,9};
  
    TreeNode root = buildTree(in, post);
    display(root);
  }
  
  public static void main(String[] args) {
    solve();
  }    
}
