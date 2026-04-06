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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> pq=new LinkedList<>();
        Queue<TreeNode> qq=new LinkedList<>();
        pq.offer(p);
        qq.offer(q);
        while(!pq.isEmpty() && !qq.isEmpty())
        {
            TreeNode p1= pq.poll();
            TreeNode p2=qq.poll();

             if (p1 == null && p2 == null) continue;

            if(p1!=null && p2 == null) return false;

            if(p2!=null && p1 == null) return false;

            if(p1.val != p2.val) return false;

          
                pq.offer(p1.left);
                qq.offer(p2.left);
                pq.offer(p1.right);
                qq.offer(p2.right);        
        }

        return pq.isEmpty() && qq.isEmpty();
        
    }
}
