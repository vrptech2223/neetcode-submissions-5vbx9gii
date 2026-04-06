class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            // Try matching subtree from this node
            if (isSameTree(node, subRoot)) return true;

            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }

        return false;
    }

    // Iterative BFS comparison (NO recursion)
    private boolean isSameTree(TreeNode a, TreeNode b) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(a);
        q.offer(b);

        while (!q.isEmpty()) {
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();

            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;

            if (n1.val != n2.val) return false;

            q.offer(n1.left);
            q.offer(n2.left);
            q.offer(n1.right);
            q.offer(n2.right);
        }

        return true;
    }
}