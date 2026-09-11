// Last updated: 11/09/2026, 09:29:33
class WordNode {
    WordNode next;
    String word;
    int index;

    WordNode(String word, int index) {
        this.word = word;
        this.index = index;
    }
}
class TrieNode {
    TrieNode[] children;
    WordNode suffixHead;

    TrieNode() {
        children = new TrieNode[26];
    }
}
class WordFilter {
    private TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int i = 0; i < words.length; ++i)
            insertWord(words[i], i);
    }
    private void insertWord(String word, int index) {
        TrieNode trieNode = root;
        for (char c : word.toCharArray()) {
            if (trieNode.children[c - 'a'] == null)
                trieNode.children[c - 'a'] = new TrieNode();

            trieNode = trieNode.children[c - 'a'];
            
            WordNode wordNode = new WordNode(word, index);
            wordNode.next = trieNode.suffixHead;
            trieNode.suffixHead = wordNode;
        }
    }
    public int f(String pref, String suff) {
        TrieNode trieNode = root;
        for (char c : pref.toCharArray()) {
            if (trieNode.children[c - 'a'] == null)
                return -1;

            trieNode = trieNode.children[c - 'a'];
        }
        WordNode wordNode = trieNode.suffixHead;
        while (wordNode != null) {
            if (wordNode.word.endsWith(suff))
                return wordNode.index;

            wordNode = wordNode.next;
        }
        return -1;
    }
}