
class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean eow = false; // end of word
}

public class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.child[i] == null) {
                curr.child[i] = new TrieNode();
            }
            curr = curr.child[i];
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        List<TrieNode> current = new ArrayList<>();
        current.add(root);

        for (char c : word.toCharArray()) {
            List<TrieNode> next = new ArrayList<>();

            for (TrieNode node : current) {
                if (c == '.') {
                    // Try all children
                    for (TrieNode childNode : node.child) {
                        if (childNode != null) {
                            next.add(childNode);
                        }
                    }
                } else {
                    // Normal character
                    TrieNode childNode = node.child[c - 'a'];
                    if (childNode != null) {
                        next.add(childNode);
                    }
                }
            }

            // No possible paths left
            if (next.isEmpty()) return false;

            current = next;
        }

        // Check if any node marks end of word
        for (TrieNode node : current) {
            if (node.eow) return true;
        }

        return false;
    }
}
