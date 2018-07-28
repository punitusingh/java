package algorithm.tries;

import java.util.HashMap;
import java.util.Map;

class TriNode {
    Map<Character, TriNode> children = new HashMap<>();
    int size;

    public void insert(String str, int index) {
        size++;
        if (index == str.length()) {
            return;
        }

        Character charAt = str.charAt(index);
        if (!children.containsKey(charAt)) {
            TriNode newNode = new TriNode();
            children.put(str.charAt(index), newNode);
        }

        index++;
        children.get(charAt).insert(str, index);
    }

    public void insert(String str) { //hack
        insert(str, 0);
    }

    public int find(String str) {
        return find(str, 0);
    }

    public int find(String str, int index) {
        if (index == str.length()) {
            return size;
        }

        Character c = str.charAt(index);
        if (children.containsKey(c)) {
            index++;
            return children.get(c).find(str, index);
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TriNode{");
        sb.append("children=").append(children);
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }
}

public class Tries {

    public static void main(String[] args) {
        TriNode triNode = new TriNode();
        triNode.insert("hack");
        triNode.insert("hack");
        triNode.insert("hack");
        triNode.insert("hack");
        triNode.insert("hackerrank");
        System.out.println(triNode);

        System.out.println(triNode.find("hac"));
        System.out.println(triNode.find("hak"));
        System.out.println(triNode.find("hack"));
        System.out.println(triNode.find("hackerrank"));
        System.out.println(triNode.find("hackerranks"));
    }
}
