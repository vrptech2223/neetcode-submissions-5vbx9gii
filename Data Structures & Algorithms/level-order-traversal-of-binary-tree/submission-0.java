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
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        q.offer(new Pair<>(root,0));
        while(!q.isEmpty())
        {
            Pair<TreeNode,Integer> p=q.poll();
            if(p==null || p.getKey() == null) continue;
            TreeNode r=p.getKey();
            int depth=p.getValue();
            if(res.size()-1 < depth)
            {
                res.add(depth,new ArrayList<>());
                res.get(depth).add(r.val);
            } else 
            {
                res.get(depth).add(r.val);
            }
            q.offer(new Pair<>(r.left,depth+1));
            q.offer(new Pair<>(r.right,depth+1));
        }
        
        return res;
    }
}
