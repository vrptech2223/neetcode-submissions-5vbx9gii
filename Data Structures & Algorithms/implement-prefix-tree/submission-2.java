class PrefixTree {

    private TrieNode r;

    public PrefixTree() {
        r=new TrieNode();
         
    }

    public void insert(String word) {
        TrieNode curr=r;
        for(char c : word.toCharArray())
        {
            int i = c - 'a';
            if(curr.child[i]==null)
            {
                curr.child[i]=new TrieNode();
                
            }
            curr=curr.child[i];
        }

        curr.eow=true;
    }

    public boolean search(String word) {
        TrieNode curr=r;
        for(char c : word.toCharArray())
        {
            int i = c - 'a';
            if(curr.child[i]!=null)
                curr=curr.child[i];
        }

        return curr.eow;

    }

    public boolean startsWith(String prefix) {
        TrieNode cur = r;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (cur.child[i] == null) {
                return false;
            }
            cur = cur.child[i];
        }
        return true;
    }
}

public class TrieNode{
    TrieNode[] child=new TrieNode[26];
    boolean eow=false;
}
