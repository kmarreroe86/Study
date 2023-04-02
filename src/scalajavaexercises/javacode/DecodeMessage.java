package scalajavaexercises.javacode;

import java.util.HashMap;
import java.util.Map;

/*Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
You can assume that the messages are decodable. For example, '001' is not allowed.
* */
public class DecodeMessage {

    public static void main(String[] args) {
        Map<Integer, Character> alphabet = new HashMap() {{
            put(1, 'a');
            put(2, 'b');
            put(3, 'c');
            put(4, 'd');
            put(5, 'e');
            put(6, 'f');
            put(7, 'g');
            put(8, 'h');
            put(9, 'i');
            put(10, 'j');
            put(11, 'k');
            put(12, 'l');
            put(13, 'm');
            put(14, 'n');
            put(15, 'o');
            put(16, 'p');
            put(17, 'q');
            put(18, 'r');
            put(19, 's');
            put(20, 't');
            put(21, 'u');
            put(22, 'v');
            put(23, 'w');
            put(24, 'x');
            put(25, 'y');
            put(26, 'z');
        }};

        String message = "12713"; // "111";
        System.out.println(decodeDp(message));
    }

    public static int decodeDp(String message) {
        int msgLen = message.length();
        int[] decodeCount = new int[msgLen + 1];

        decodeCount[0] = 1;
        decodeCount[1] = 1;

        for (int i = 2; i < msgLen + 1; i++) {
            if (message.charAt(i - 1) > '0')
                decodeCount[i] = decodeCount[i - 1];

            if ((message.charAt(i - 2) < '2') || (message.charAt(i - 2) == '2' && message.charAt(i - 1) < '7'))
                decodeCount[i] = decodeCount[i] + decodeCount[i - 2];
        }

        return decodeCount[msgLen];
    }

}
