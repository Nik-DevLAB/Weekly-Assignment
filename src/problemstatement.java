import java.util.*;

class Node {
    Map<Character, Node> child = new HashMap<>();
    Map<String, Integer> freq = new HashMap<>();
}

public class problemstatement {

    static Node root = new Node();

    static void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            cur.child.putIfAbsent(c, new Node());
            cur = cur.child.get(c);
            cur.freq.put(word, cur.freq.getOrDefault(word, 0) + 1);
        }
    }

    static void search(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.child.containsKey(c)) return;
            cur = cur.child.get(c);
        }

        System.out.println(cur.freq);
    }

    public static void main(String[] args) {
        insert("java");
        insert("javascript");
        insert("javafx");

        search("jav");
    }
}