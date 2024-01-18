import java.lang.reflect.Array;
import java.util.*;
public class Main {
    public static void groupAnagrams(String[] arr) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> grouped = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (String word : arr) {
            char[] wordChars = word.toCharArray();
            Arrays.sort(wordChars);
            String sortedWord = new String(wordChars);

            if (!grouped.containsKey(sortedWord)) {
                grouped.put(sortedWord, new ArrayList<>());
                list.add(sortedWord);
            }
            grouped.get(sortedWord).add(word);
        }

        for (String key : list) {
            result.add(grouped.get(key));
        }

        System.out.println("[");
        for (int i=0;i< result.size();i++){
            System.out.println(" "+result.get(i));
        }
        System.out.println("]");

    }
    public static void main(String[] args) {
        String[] input = {"cook", "save", "taste", "aves", "vase", "state", "map"};
        groupAnagrams(input);
        }
    }
