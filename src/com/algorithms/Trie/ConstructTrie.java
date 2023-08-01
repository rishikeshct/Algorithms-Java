package Trie;

class TrieNode {
    private static final int ALPHABET_SIZE = 26;
    public TrieNode[] children;
    private boolean isEndOfWord;

    public String word;

    public TrieNode() {
        children = new TrieNode[ALPHABET_SIZE];
        isEndOfWord = false;
        word = null;
    }

    public void insert(String word) {
        TrieNode current = this;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (current.children[ch] == null) {
                current.children[ch] = new TrieNode();
            }
            current = current.children[ch];
        }
        current.isEndOfWord = true;
        current.word = word;
    }

    public boolean search(String word) {
        TrieNode current = this;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (current.children[ch] == null) {
                return false;
            }
            current = current.children[ch];
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = this;
        for (int i = 0; i < prefix.length(); i++) {
            int ch = prefix.charAt(i) - 'a';
            if (current.children[ch] == null) {
                return false;
            }
            current = current.children[ch];
        }
        return true;
    }
}

public class ConstructTrie {
    private TrieNode root;

    public ConstructTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return root.search(word);
    }

    public boolean startsWith(String prefix) {
        return root.startsWith(prefix);
    }

    public static void main(String[] args) {
        ConstructTrie trie = new ConstructTrie();
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("orange");

        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("banana")); // true
        System.out.println(trie.search("orange")); // true
        System.out.println(trie.search("grape")); // false

        System.out.println(trie.startsWith("ape")); // true
        System.out.println(trie.startsWith("ban")); // true
        System.out.println(trie.startsWith("ora")); // true
        System.out.println(trie.startsWith("gr")); // false
    }
}
