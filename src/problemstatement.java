import java.util.*;

public class problemstatement {

    static Map<String, Integer> views = new HashMap<>();
    static Map<String, Set<String>> users = new HashMap<>();
    static Map<String, Integer> sources = new HashMap<>();

    static void process(String url, String user, String source) {
        views.put(url, views.getOrDefault(url, 0) + 1);

        users.putIfAbsent(url, new HashSet<>());
        users.get(url).add(user);

        sources.put(source, sources.getOrDefault(source, 0) + 1);
    }

    public static void main(String[] args) {
        process("/news", "u1", "google");
        process("/news", "u2", "facebook");
        process("/sports", "u1", "google");

        System.out.println("Views: " + views);
        System.out.println("Unique Users: " + users);
        System.out.println("Sources: " + sources);
    }
}