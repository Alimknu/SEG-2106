import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int n = 0;
		try (Scanner s = new Scanner(System.in)) {
			while (true) {
				System.out.println("Enter the number of Queens :");
				n = s.nextInt();
				if (n == 2 || n == 3) {
					System.out.println("No Solution possible for " + n + " Queens. Please enter another number");
				} else
					break;
			}
		}

		int threads = 10;

		long timestamp1 = System.currentTimeMillis();

		System.out.println("Solution to " + n + " queens using hill climbing search:");

		ThreadGroup group = new ThreadGroup("ThreadGroup");

		HillClimbingSearch[] hcs = new HillClimbingSearch[threads];

		for (int i = 0; i < threads; i++) {

			hcs[i] = new HillClimbingSearch(n);
			new Thread(group, hcs[i]).start();

		}

		while (group.activeCount() == threads)
			;

		// Printing the solution
		long timestamp2 = System.currentTimeMillis();

		long timeDiff = timestamp2 - timestamp1;

		group.interrupt();
		int counter = 0;
		while (counter < threads) {
			if (hcs[counter].getFinalSolution() != null) {
				group.interrupt();
				hcs[counter].printState(hcs[counter].getFinalSolution());
				counter = threads;
			}
			counter++;
		}

		System.out.println("Execution Time: " + timeDiff + " ms");

	}
}