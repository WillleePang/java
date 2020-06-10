package com.willlee.leetcode.problems201_300;

import java.util.HashMap;

public class Leetcode208 {

}

class Trie {
    class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        TrieNode node = root;
        for (char cur : word.toCharArray()) {
            if (!node.containsKey(cur)) {
                node.put(cur, new TrieNode());
            }
            node = node.get(cur);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public TrieNode searchPrefix(String word) {
        if (word == null || word.isEmpty()) {
            return null;
        }
        TrieNode node = root;
        for (char cur : word.toCharArray()) {
            if (node.containsKey(cur)) {
                node = node.get(cur);
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if there is any word in the trie that starts with the given
     * prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

class Trie1 {
    public class TrieNode {
        public int path;
        public int end;
        public HashMap<Character, TrieNode> next;

        public TrieNode() {
            path = 0;
            end = 0;
            next = new HashMap<>();
        }
    }

    private TrieNode root;

    public Trie1() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.equals(""))
            return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch)) {
                node.next.put(ch, new TrieNode());
            }
            node = node.next.get(ch);
            node.path++;
        }
        node.end++;
    }

    public boolean search(String word) {
        if (word == null || word.equals(""))
            return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch))
                return false;
            node = node.next.get(ch);
        }
        if (node.end == 0)
            return false;
        return true;
    }

    public boolean startsWith(String word) {
        if (word == null || word.equals(""))
            return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch))
                return false;
            node = node.next.get(ch);
        }
        return true;
    }

    public void delete(String word) {
        if (word == null || word.equals("") || !search(word))
            return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (--node.next.get(ch).path == 0) {
                node.next.remove(ch);
                return;
            }
            node = node.next.get(ch);
        }
        node.end--;
    }
}

class Trie2 {
    private class TrieNode {
        private TrieNode[] next;
        private boolean isEnd;

        public TrieNode() {
            next = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie2() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tmp = root;
        for (char c : word.toCharArray()) {
            int n = c - 'a';
            if (tmp.next[n] == null)
                tmp.next[n] = new TrieNode();
            tmp = tmp.next[n];
        }
        tmp.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tmp = root;
        for (char c : word.toCharArray()) {
            int n = c - 'a';
            if (tmp.next[n] == null)
                return false;
            tmp = tmp.next[n];
        }
        return tmp.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given
     * prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for (char c : prefix.toCharArray()) {
            int n = c - 'a';
            if (tmp.next[n] == null)
                return false;
            tmp = tmp.next[n];
        }
        return true;
    }
}
