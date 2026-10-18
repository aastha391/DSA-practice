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
    static class Tuple{
        TreeNode node;
        int row;
        int col;

        public Tuple(TreeNode node,int row,int col){
            this.node=node;
            this.row=row;
            this.col=col;
        }
    }

    static List<List<Integer>> result;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        result=new ArrayList<>();
        solve(root);
        return result;
    }

    static void solve(TreeNode root){
        Queue<Tuple> q=new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple it=q.poll();
            TreeNode node=it.node;
            int row=it.row;
            int col=it.col;

            if(!map.containsKey(row)){
                map.put(row,new TreeMap<>());
            }

            if(!map.get(row).containsKey(col)){
                map.get(row).put(col,new PriorityQueue<>());
            }

            map.get(row).get(col).add(node.val);

            if(node.left!=null){
                q.add(new Tuple(node.left,row-1,col+1));
            }

            if(node.right!=null){
                q.add(new Tuple(node.right,row+1,col+1));
            }
        }

        for(TreeMap<Integer,PriorityQueue<Integer>> ans:map.values()){
            List<Integer> subList=new ArrayList<>();
            for(PriorityQueue<Integer> nodes:ans.values()){
                while(!nodes.isEmpty()){
                    subList.add(nodes.poll());
                }
            }
            result.add(subList);
        }
    }
}