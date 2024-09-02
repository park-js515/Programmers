import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

public class Trie {
    private TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = this.rootNode;

        for (int i = 0; i < word.length(); i++) {
            node = node.getChildNodes().
                    computeIfAbsent(word.charAt(i), key -> new TrieNode());
        }
        node.setIsLastChar(true);
    }

    boolean contains(String word) {
        TrieNode node = this.rootNode;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node = node.getChildNodes().get(ch);

            if (node == null) {
                return false;
            }
        }

        return node.isLastChar();
    }

    void delete(String word) {
        delete(this.rootNode, word, 0);
    }

    private void delete(TrieNode node, String word, int index) {
        char ch = word.charAt(index);
        TrieNode childNode = node.getChildNodes().get(ch);
        if (childNode == null) {
            System.out.println("There is no \"" + word + "\" in this Trie.");
            return;
        }

        index++;
        if (index == word.length()) {
            if (!childNode.isLastChar()) {
                System.out.println("There is no \"" + word + "\" in this Trie.");
                return;
            }

            if (!childNode.getChildNodes().isEmpty()) {
                childNode.setIsLastChar(false);
            } else {
                node.getChildNodes().remove(ch);
            }
        } else {
            delete(childNode, word, index);

            if (!childNode.isLastChar() && childNode.getChildNodes().isEmpty()) {
                node.getChildNodes().remove(ch);
            }
        }
    }

    void print() {
        Queue<Map<Character, TrieNode>> queue = new ArrayDeque<>();
        queue.add(rootNode.getChildNodes());

        while (!queue.isEmpty()) {
            for (Map.Entry<Character, TrieNode> entry : queue.poll().entrySet()) {
                System.out.println(entry.getKey());
                queue.add(entry.getValue().getChildNodes());
            }
        }
    }
}