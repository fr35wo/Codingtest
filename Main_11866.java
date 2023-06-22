package bak;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11866 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(); // n명의 사람
		int k = input.nextInt(); // k번째 제거
		int counter = 0;

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) { // 1부터 n까지의 숫자를 큐에 넣은 후,
			queue.offer(i);
		}

		System.out.print("<");
		while (!queue.isEmpty()) { // 이렇게 큐에 남아있는 원소가 1이 아닐때까지 반복하고, 큐에 남아있는 마지막 원소는 그냥 poll하기만 하면 된다.
			for (int i = 0; i < k - 1; i++) { // 큐의 첫번째 원소부터 k-1번째 숫자를 큐에서 빼고 맨 뒤에 추가한다.
				queue.offer(queue.poll());
			}
			System.out.print(queue.poll()); // k번째인 원소는 아예 큐에서 제거해버린다.

			if (!queue.isEmpty()) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}
}
