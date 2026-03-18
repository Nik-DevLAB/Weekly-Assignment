import java.util.*;

class Bucket {
    int tokens = 5;
    long last = System.currentTimeMillis();

    boolean allow() {
        long now = System.currentTimeMillis();
        if (now - last > 1000) {
            tokens = 5;
            last = now;
        }

        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }
}

public class problemstatement {

    static Map<String, Bucket> map = new HashMap<>();

    static boolean check(String client) {
        map.putIfAbsent(client, new Bucket());
        return map.get(client).allow();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println(check("user1"));
        }
    }
}