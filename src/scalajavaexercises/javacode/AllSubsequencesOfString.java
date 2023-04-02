package scalajavaexercises.javacode;

import java.util.ArrayList;
import java.util.List;

public class AllSubsequencesOfString {

    static List<String> subSequences = new ArrayList<>();
    public static void main(String[] args) {
        String input = "abc";

        getAllSubsequences(input, "");
        System.out.println(subSequences);
    }

    static void getAllSubsequences(String input, String ans) {

        if (input.length() == 0) {
            subSequences.add(ans);
            return;
        }

        getAllSubsequences(input.substring(1), ans + input.charAt(0));
        getAllSubsequences(input.substring(1), ans);

    }
}
