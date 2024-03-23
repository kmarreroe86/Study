package hackerrank;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlippingBits {


    public static void main(String[] args) {
        Long l = flippingBits(2147483647);
        System.out.println(l);
    }


    public static long flippingBits(long n) {

        String binaryStr = String.format("%32s", Long.toBinaryString(n)).replace(' ', '0');

        char[] characters = binaryStr.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            characters[i] = characters[i] == '0' ? '1' : '0';
        }
        return new BigInteger(String.valueOf(characters), 2).longValue();
    }
}
