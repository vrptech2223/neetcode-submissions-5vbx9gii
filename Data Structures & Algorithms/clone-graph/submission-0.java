/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
         if (node == null) return null;
        Map<Node,Node> m =new HashMap<>();
        Queue<Node> q =new LinkedList<>();
        m.put(node, new Node(node.val));
        q.add(node);

        while(!q.isEmpty())
        {
           Node curr= q.poll();
           for(Node ne: curr.neighbors)
           {

                if(!m.containsKey(ne))
                {
                    m.put(ne,new Node(ne.val));
                    q.offer(ne);
                }
                m.get(curr).neighbors.add(m.get(ne));

           }


            

        }
        return m.get(node);
    }
}