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
    public static int[] solve(TreeNode node){
        if(node==null) return new int[] {0,0};

        int[] left=solve(node.left);
        int[] right=solve(node.right);

        int robbed=node.val+left[0]+right[0];
        int notrobbed=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return new int[]{notrobbed,robbed};
    }
    public int rob(TreeNode root) {
        int[] res=solve(root);
        return Math.max(res[0],res[1]);
       }
}