import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Map<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isLastChar;

    public Map<Character, TrieNode> getChildNodes() {
        return this.childNodes;
    }

    public boolean isLastChar() {
        return this.isLastChar;
    }

    public void setIsLastChar(boolean isLastChar) {
        this.isLastChar = isLastChar;
    }
}
