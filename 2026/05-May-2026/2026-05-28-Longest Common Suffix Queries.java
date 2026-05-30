class Solution {

    class TrieNode {

        TrieNode[] children = new TrieNode[26];

        int index = -1;
    }

    TrieNode root = new TrieNode();

    String[] words;

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        words = wordsContainer;

        int bestIndex = 0;

        // Find globally shortest word
        for (int i = 1; i < wordsContainer.length; i++) {

            if (wordsContainer[i].length() < wordsContainer[bestIndex].length()) {

                bestIndex = i;
            }
        }

        root.index = bestIndex;

        // Insert words into reversed Trie
        for (int i = 0; i < wordsContainer.length; i++) {

            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        // Process queries
        for (int i = 0; i < wordsQuery.length; i++) {

            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }

    private void insert(String word, int idx) {

        TrieNode node = root;

        String reversed = new StringBuilder(word).reverse().toString();

        for (char ch : reversed.toCharArray()) {

            int c = ch - 'a';

            if (node.children[c] == null) {

                node.children[c] = new TrieNode();
            }

            node = node.children[c];

            // First time filling node
            if (node.index == -1) {

                node.index = idx;
            }

            // Update if current word is shorter
            else if (words[idx].length() < words[node.index].length()) {

                node.index = idx;
            }
        }
    }

    private int search(String word) {

        TrieNode node = root;

        int ans = root.index;

        String reversed = new StringBuilder(word).reverse().toString();

        for (char ch : reversed.toCharArray()) {

            int c = ch - 'a';

            if (node.children[c] == null) {

                break;
            }

            node = node.children[c];

            ans = node.index;
        }

        return ans;
    }
}