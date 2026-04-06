class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while (current != null) {
            if (p.val < current.val && q.val < current.val) {
                // Both nodes are in left subtree
                current = current.left;
            } else if (p.val > current.val && q.val > current.val) {
                // Both nodes are in right subtree
                current = current.right;
            } else {
                // Split point found, this is LCA
                return current;
            }
        }

        return null; // This line is never really reached if both nodes exist in tree
    }
}