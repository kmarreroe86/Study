package scalaAndJavaExercices.javacode;

public class AllPermutationsOfString {

    public static void main(String[] args) {
        String input = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Permutations of: " + input + ": ");

        permutations(input, 0, input.length() - 1);
    }

    static void permutations(String str, int left, int right) {
        if (left == right) System.out.println(str);

        for(int i = left; i <= right; i++) {
            String swappedStr = swap(str, left, i);
            permutations(swappedStr, left + 1, right);
        }
    }

    private static String swap(String str, int i, int j) {
        char tmp;
        char[] charArr = str.toCharArray();
        tmp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = tmp;
        return String.valueOf(charArr);
    }
}
