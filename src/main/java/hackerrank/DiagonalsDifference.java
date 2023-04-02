package hackerrank;

// https://www.youtube.com/watch?v=ef0ts1cVWYc&list=PLU_sdQYzUj2nKXYskiYlKQIKknqu4H5ti&ab_channel=NickWhite
public class DiagonalsDifference {

    public static void main(String[] args) {
        int[][]matrix = new int[][] {{1,2,3}, {4,5,6}, {9,8,9}};
        System.out.println(absoluteDifference(matrix));

    }

    private static int absoluteDifference(int[][]matrix) {
        int diagonalOneAcc = 0;
        int diagonalTwoAcc = 0;
        int i = 0, j = 0;
        while(i < matrix.length && j < matrix[0].length) {
            diagonalOneAcc += matrix[i][j];
            i++;
            j++;
        }

        i = 0;
        j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0) {
            diagonalTwoAcc += matrix[i][j];
            i++;
            j--;
        }

        return Math.abs(diagonalOneAcc - diagonalTwoAcc);
    }
}
