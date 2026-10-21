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
    class Pair{
        TreeNode node;
        int num;

        public Pair(TreeNode node,int num){
            this.node=node;
            this.num=num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        if(root==null) return 0;

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int first=0,last=0;
            int level=q.size();
            int idx=q.peek().num;
            for(int i=0;i<level;i++){
            Pair it=q.poll();
            int curr_idx=it.num-idx;
            TreeNode node=it.node;
            if(i==0) first=curr_idx;
            if(i==level-1) last=curr_idx;

            if(node.left!=null){
                q.add(new Pair(node.left,2*curr_idx+1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right,2*curr_idx+2));
            }
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}