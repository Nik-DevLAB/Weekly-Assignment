import java.util.*;

class problemstatement {

    private Map<String, Integer> userMap = new HashMap<>();
    private Map<String, Integer> attemptCount = new HashMap<>();

    // Check availability
    public boolean checkAvailability(String username) {
        attemptCount.put(username, attemptCount.getOrDefault(username, 0) + 1);
        return !userMap.containsKey(username);
    }

    // Register user
    public void register(String username, int userId) {
        if (!checkAvailability(username)) {
            System.out.println("Username already taken!");
            return;
        }
        userMap.put(username, userId);
        System.out.println("Registered successfully!");
    }

    // Suggest alternatives
    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            suggestions.add(username + i);
        }

        suggestions.add(username.replace("_", "."));

        return suggestions;
    }

    // Most attempted username
    public String getMostAttempted() {
        String maxUser = null;
        int max = 0;

        for (String user : attemptCount.keySet()) {
            if (attemptCount.get(user) > max) {
                max = attemptCount.get(user);
                maxUser = user;
            }
        }

        return maxUser + " (" + max + " attempts)";
    }

    public static void main(String[] args) {
        problemstatement uc = new problemstatement();

        uc.register("john_doe", 1);

        System.out.println(uc.checkAvailability("john_doe")); // false
        System.out.println(uc.checkAvailability("jane_smith")); // true

        System.out.println(uc.suggestAlternatives("john_doe"));
        System.out.println("Most attempted: " + uc.getMostAttempted());
    }
}