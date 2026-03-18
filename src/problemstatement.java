import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, int ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl * 1000;
    }

    boolean isExpired() {
        return System.currentTimeMillis() > expiry;
    }
}

public class problemstatement {

    static Map<String, DNSEntry> cache = new HashMap<>();
    static int hits = 0, misses = 0;

    static String resolve(String domain) {
        DNSEntry entry = cache.get(domain);

        if (entry != null && !entry.isExpired()) {
            hits++;
            return "HIT → " + entry.ip;
        }

        misses++;
        String ip = "192.168.1." + new Random().nextInt(100);
        cache.put(domain, new DNSEntry(ip, 3));
        return "MISS → " + ip;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));

        Thread.sleep(4000); // expire

        System.out.println(resolve("google.com"));

        System.out.println("Hit Rate: " + (hits * 100.0 / (hits + misses)) + "%");
    }
}