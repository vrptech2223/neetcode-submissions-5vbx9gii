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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Queue<TreeNode> q1=new LinkedList<>();


        if( q.val < p.val )
        {
            int temp = p.val ;
            p.val=q.val;
            q.val=temp;
        }

        q1.offer(root);
        while(!q1.isEmpty())
        {
                TreeNode n=q1.poll();

                if(n.val == p.val || n.val ==q.val) return n;

                if(n.left == null || n.right == null ) continue;

                if( n.left.val == p.val && n.right.val == q.val) return n;

                if(p.val < n.val && q.val > n.val) return n;

                if(p.val < n.val  && q.val < n.val )
                {
                    q1.offer(n.left);
                }
                else  if(p.val > n.val && q.val > n.val)
                {
                    q1.offer(n.right);
                }

        }
        
        return null;


        
    }
}
