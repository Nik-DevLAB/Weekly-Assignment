import java.util.*;

class problemstatement {

    private Map<String, Integer> stock = new HashMap<>();
    private Map<String, Queue<Integer>> waitingList = new HashMap<>();

    public problemstatement() {
        stock.put("IPHONE15_256GB", 100);
        waitingList.put("IPHONE15_256GB", new LinkedList<>());
    }

    // Check stock
    public int checkStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }

    // Thread-safe purchase
    public synchronized void purchaseItem(String productId, int userId) {

        int available = stock.getOrDefault(productId, 0);

        if (available > 0) {
            stock.put(productId, available - 1);
            System.out.println("User " + userId +
                    " SUCCESS. Remaining: " + (available - 1));
        } else {
            waitingList.get(productId).add(userId);
            System.out.println("User " + userId +
                    " added to waiting list. Position: " +
                    waitingList.get(productId).size());
        }
    }

    public static void main(String[] args) {

        problemstatement manager = new problemstatement();

        // Simulate multiple users
        for (int i = 1; i <= 105; i++) {
            manager.purchaseItem("IPHONE15_256GB", i);
        }
    }
}