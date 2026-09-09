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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       List<List<Integer>> res=new ArrayList<>();
       List<Integer> currentpath=new ArrayList<>();
       dfs(root,targetSum,currentpath,res);
       return res;
    }

    public static void dfs(TreeNode node,int remainingsum,List<Integer> path,List<List<Integer>> res) {
        if(node==null)
        return ;

        path.add(node.val);
        remainingsum-=node.val;

        if(node.left==null && node.right==null){
            if(remainingsum==0){
                res.add(new ArrayList<>(path));
            }
        }
        else{
            dfs(node.left,remainingsum,path,res);
            dfs(node.right,remainingsum,path,res);
        }
        path.remove(path.size()-1);
    }
}