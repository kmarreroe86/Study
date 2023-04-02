package hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/simple-text-editor/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

class Node2 {
    int operation;
    Object parameter;

    Node2(int operation, Object parameter) {
        this.operation = operation;
        this.parameter = parameter;
    }
}

public class SimpleTextEditor {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String regex = "\\d+";

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        Queue<Node2> operations = new LinkedList<Node2>();

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nk = scanner.nextLine().split(" ");
            Node2 n;
            if (nk.length == 2) {
                if (nk[1].matches(regex)) {
                    n = new Node2(Integer.parseInt(nk[0]), Integer.parseInt(nk[1]));
                } else {
                    n = new Node2(Integer.parseInt(nk[0]), nk[1]);
                }
            } else {
                n = new Node2(Integer.parseInt(nk[0]), null);
            }
            operations.add(n);
        }
        scanner.close();


        /*operations.stream().forEach(o -> {
            System.out.print(o.operation + " ");
            System.out.print(o.parameter.toString());
            System.out.println();
        });*/
        Stack<String> status = new Stack<>();
        status.push("");
        for (Node2 oper : operations) {
            switch (oper.operation) {
                case 1:
                    status.push(status.peek().concat(oper.parameter.toString()));
                    break;
                case 2:
                    int idx = status.peek().length() - ((Integer)oper.parameter).intValue();
                    String shorted = status.peek().substring(0, idx);
                    System.out.print(shorted);
                    status.push(shorted);
                    break;
                case 3:
                    int index = ((Integer)oper.parameter).intValue() - 1;
                    System.out.println(status.peek().charAt(index));
                    break;
                case 4:
                    status.pop();
                    break;
            }
        }


    }
}
