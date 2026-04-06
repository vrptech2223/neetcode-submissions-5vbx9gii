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
    public boolean isValidBST(TreeNode root) {

        
        int res = 0;
        Queue<Pair<TreeNode,Pair<Integer,Integer>>> q = new LinkedList<>();
        q.offer(new Pair<>(root, new Pair<>(Integer.MIN_VALUE,Integer.MAX_VALUE)));
        while(!q.isEmpty())
        {
            Pair<TreeNode,Pair<Integer,Integer>> p = q.poll();
            TreeNode node = p.getKey();
            Pair<Integer,Integer> val = p.getValue();
            int min = val.getKey();
            int max=val.getValue();
            if(node == null  ) continue;

            if(min < node.val && node.val < max)
            {
                q.offer(new Pair<>(node.left, new Pair<>(min,node.val)));
                q.offer(new Pair<>(node.right, new Pair<>(node.val,max)));

            } else {
                return false;
            }
        }

        return true;
        
        
    }
}
