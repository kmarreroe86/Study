package recursion;

public class HanoiTowers {

	public static void move(int numberOfDiscs, char from, char to, char inter) {
		if (numberOfDiscs == 1) {
			System.out.println("Moving Disc 1 from " + from + " to " + to);
		} else {
			move(numberOfDiscs - 1, from, inter, to);
			System.out.println("Moving disc " + numberOfDiscs + " from " + from + " to " + to);
			move(numberOfDiscs - 1, inter, to, from);
		}

	}

	public static void main(String[] args) {

		move(3, 'A', 'C', 'B');

	}

}
