package scalaAndJavaExercices.javacode;

import java.util.HashMap;

public class SockMerchant {

    public static void main(String[] args) {
        var socks = new int[]{1, 2, 1, 2, 1, 3, 2};

        var socksMapping = new HashMap<Integer, Integer>();
        for (var sock : socks) {
            if (!socksMapping.containsKey(sock)) {
                socksMapping.put(sock, 1);
            } else {
                int qty = socksMapping.get(sock);
                socksMapping.put(sock, qty + 1);
            }
        }

        var pairs = 0;
        for (var qty: socksMapping.values()) {
            pairs += qty / 2;
        }

        System.out.println(String.format("Total pairs: %d", pairs));
    }
}
