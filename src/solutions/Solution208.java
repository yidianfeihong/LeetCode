package solutions;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class Solution208 {

    public static void main(String[] args) {


    }

//
//    class Trie {
//
//        List<String> wordList;
//
//        public Trie() {
//            wordList = new ArrayList<>();
//        }
//
//        public void insert(String word) {
//            wordList.add(word);
//            wordList.sort(this::compareWord);
//        }
//
//        public boolean search(String word) {
//            for (String str : wordList) {
//                if (str.equals(word)) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        public boolean startsWith(String prefix) {
//            for (String currentWord : wordList) {
//                int compareResult = compareWord(currentWord, prefix);
//                if (compareResult > 0) {
//                    return currentWord.startsWith(prefix);
//                } else if (compareResult == 0) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        public int compareWord(String wordA, String wordB) {
//            int lenA = wordA.length();
//            int lenB = wordB.length();
//            int len = Math.min(lenA, lenB);
//            for (int i = 0; i < len; i++) {
//                if (wordA.charAt(i) > wordB.charAt(i)) {
//                    return 1;
//                } else if (wordA.charAt(i) < wordB.charAt(i)) {
//                    return -1;
//                }
//            }
//            return Integer.compare(lenA, lenB);
//        }
//    }


    class Trie {

        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
        }

        public void insert(String word) {
            Trie tree = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (tree.children[index] == null) {
                    tree.children[index] = new Trie();
                }
                tree =  tree.children[index];
            }
            tree.isEnd = true;
        }

        public boolean search(String word) {
            Trie tree = searchPrefix(word);
            return tree != null && tree.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        public Trie searchPrefix(String prefix) {
            Trie tree = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (tree.children[index] == null) {
                    return null;
                }
                tree = tree.children[index];
            }
            return tree;
        }
    }
}
