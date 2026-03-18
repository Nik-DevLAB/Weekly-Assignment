import java.util.*;

public class problemstatement {

    static void find(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int comp = target - num;

            if (map.containsKey(comp)) {
                System.out.println(num + " + " + comp);
            }

            map.put(num, 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {500, 300, 200};
        find(arr, 500);
    }
}