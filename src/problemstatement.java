import java.util.*;

class LRU extends LinkedHashMap<String, String> {
    int cap;

    LRU(int cap) {
        super(cap, 0.75f, true);
        this.cap = cap;
    }

    protected boolean removeEldestEntry(Map.Entry<String, String> e) {
        return size() > cap;
    }
}

public class problemstatement {

    static LRU L1 = new LRU(2);
    static LRU L2 = new LRU(5);

    static String get(String key) {
        if (L1.containsKey(key)) return "L1 HIT";

        if (L2.containsKey(key)) {
            L1.put(key, L2.get(key));
            return "L2 HIT → promoted";
        }

        L2.put(key, "DATA");
        return "DB HIT";
    }

    public static void main(String[] args) {
        System.out.println(get("A"));
        System.out.println(get("A"));
        System.out.println(get("B"));
        System.out.println(get("C"));
    }
}