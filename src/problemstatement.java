import java.util.*;

public class problemstatement {

    static Map<String, Set<String>> index = new HashMap<>();

    static List<String> ngrams(String text, int n) {
        String[] words = text.split(" ");
        List<String> list = new ArrayList<>();

        for (int i = 0; i <= words.length - n; i++) {
            list.add(String.join(" ", Arrays.copyOfRange(words, i, i + n)));
        }
        return list;
    }

    static void addDoc(String id, String text) {
        for (String g : ngrams(text, 3)) {
            index.putIfAbsent(g, new HashSet<>());
            index.get(g).add(id);
        }
    }

    static void check(String text) {
        Map<String, Integer> count = new HashMap<>();

        for (String g : ngrams(text, 3)) {
            if (index.containsKey(g)) {
                for (String doc : index.get(g)) {
                    count.put(doc, count.getOrDefault(doc, 0) + 1);
                }
            }
        }

        System.out.println("Similarity: " + count);
    }

    public static void main(String[] args) {
        addDoc("doc1", "this is a sample document for testing plagiarism");
        addDoc("doc2", "this document is used for plagiarism detection testing");

        check("this is a plagiarism test document");
    }
}