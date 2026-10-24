/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        // if(root==null)
        // {
        //     return 0;
        // }
        // return 1+(countNodes(root.left)+countNodes(root.right));

        if(root==null) return 0;

        int lefth=leftHeight(root);
        int righth=rightHeight(root);

        if(lefth==righth){
            return ((1<<(lefth))-1);
        }

        else 
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    static int leftHeight(TreeNode node){
        int count=0;
        while(node!=null){
            count++;
            node=node.left;
        }
        return count;
    }

     static int rightHeight(TreeNode node){
        int count=0;
        while(node!=null){
            count++;
            node=node.right;
        }
        return count;
    }
}