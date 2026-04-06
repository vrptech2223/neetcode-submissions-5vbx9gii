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
    public List<Integer> rightSideView(TreeNode root) {
        

        Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        q.offer(new Pair<>(root,1));
        int ld=0;
        while(!q.isEmpty())
        {
            Pair<TreeNode,Integer> p=q.poll();
            if(p==null || p.getKey() == null) continue;
            TreeNode r=p.getKey();
            int depth=p.getValue();
            if(depth != ld)
            {
                res.add(r.val);
                ld=depth;
            }
            q.offer(new Pair<>(r.right,depth+1));
            q.offer(new Pair<>(r.left,depth+1));
        }
        
        return res;
    }
}
