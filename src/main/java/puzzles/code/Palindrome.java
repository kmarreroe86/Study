package puzzles.code;


import puzzles.tests.PalindromeTest;

public class Palindrome {

    /**
     * Write a program to check if a number is palindrome or not. If palindrome, return true else return false.
     * <p>
     * What is a palindrome number?
     * Palindrome number is a number which reads the same forward and backward. Example :  121 reads the same forward and backward. 324 is not a palindrome number.
     * <p>
     * Need to test it against following input :
     * checkPalindrome(121) → true
     * checkPalindrome(223) → false
     * checkPalindrome(333) → true
     * checkPalindrome(987) → false
     */

    public boolean checkPalindrome(int n) {

        // Solution 1
//        String str = String.valueOf(n);
//        StringBuilder sb = new StringBuilder(str);
//
//        return sb
//                .reverse()
//                .toString()
//                .equals(str);

        // Solution 2
        int interator = n;
        int newNumber = 0;
        while (interator > 0) {
            int remainder = interator % 10;
            newNumber = newNumber * 10 + remainder;
            interator /= 10;
        }

        return newNumber == n;
    }

    public static void main(String[] args) {
        PalindromeTest.checkOutput();
    }
}
