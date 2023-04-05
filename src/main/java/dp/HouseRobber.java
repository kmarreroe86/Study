package dp;

public class HouseRobber {
    /**
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
     * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
     * it will automatically contact the police if two adjacent houses were broken into on the same night.
     * <p>
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
     * can rob tonight without alerting the police.
     */


    // https://youtu.be/ge_Fv2ZQAaE?list=PLSIpQf0NbcClDpWE58Y-oSJro_W3LO8Nb&t=600¡
    public static void main(String[] args) {
        System.out.println(robber(new int[]{2, 7, 9, 3, 2}));
    }

    public static int robber(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return A[0];

        int prev1 = Math.max(A[0], A[1]);
        int prev2 = A[0];

        for (int i = 2; i < A.length; i++) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + A[i], prev1);
            prev2 = tmp;
        }

        return prev1;
    }
}
