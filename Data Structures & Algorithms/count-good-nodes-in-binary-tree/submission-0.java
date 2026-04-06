class Solution {
    public int goodNodes(TreeNode root) {

        int res = 0;

        // Queue will store: node + max so far
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, root.val));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int maxSoFar = p.max;

            if (node.val >= maxSoFar) {
                res++;
            }

            int newMax = Math.max(maxSoFar, node.val);

            if (node.left != null) {
                q.offer(new Pair(node.left, newMax));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, newMax));
            }
        }

        return res;
    }
}

// Helper class
class Pair {
    TreeNode node;
    int max;

    Pair(TreeNode n, int m) {
        node = n;
        max = m;
    }
}