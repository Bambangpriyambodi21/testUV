import java.lang.reflect.Array;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        String[] input = {"cook", "save", "taste", "aves", "vase", "state", "map"};
        groupAnagrams(input);
    }

    public static void groupAnagrams(String[] input) {
        String[][] hasil = new String[input.length][input.length];
        int[] ukuran = new int[input.length];
        int total = 0;

        for (String str : input) {
            boolean added = false;
            for (int i = 0; i < total; i++) {
                if (isAnagram(hasil[i][0], str)) {
                    hasil[i][ukuran[i]++] = str;
                    added = true;
                    break;
                }
            }
            if (!added) {
                hasil[total][ukuran[total]++] = str;
                total++;
            }
        }

        System.out.println("[");
        for (int i = 0; i < total; i++) {
            System.out.print(" [");
            for (int j = 0; j < ukuran[i]; j++) {
                if (hasil[i][j] != null) {
                    if (j==ukuran[i]-1){
                        System.out.print("'"+hasil[i][j]+"'");
                    }else {
                        System.out.print("'" + hasil[i][j] + "'," + " ");
                    }
                }
            }
            System.out.println("],");
        }
        System.out.println("]");
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            counts[str1.charAt(i) - 'a']++;
            counts[str2.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
