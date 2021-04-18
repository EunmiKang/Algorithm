package sw_expert_academy.reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Queue {

	final int MAX_N = 100;
	public int[] queue;
	public int front;
	public int rear;

	public Queue() {
		queue = new int[MAX_N+1];
		front = 0;
		rear = 0;
	}

	public Queue(int N) {
		queue = new int[N+1];
		front = 0;
		rear = 0;
	}

	public boolean isEmpty() {
		return (front == rear);
	}

	public boolean isFull() {
		return ((rear + 1) % queue.length == front);
	}

	public boolean enqueue(int value) {
		if (isFull()) {
			System.out.println("queue overflow!");
			return false;
		}
		queue[rear] = value; 
		rear = (rear + 1) % queue.length;
		return true;
	}

	public Integer dequeue() {
		if (isEmpty()) {
			System.out.println("queue is empty!");
			return null;
		}
		int poll_value = queue[front];
		front = (front + 1) % queue.length;
		return poll_value;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine()); // 데이터 크기
			String[] values = br.readLine().split(" ");

			Queue queue = new Queue(N);
			for (int j = 0; j < N; j++) {
				queue.enqueue(Integer.parseInt(values[j]));
			}
			System.out.print("#" + i + " ");
			while (!queue.isEmpty()) {
				System.out.print(queue.dequeue() + " ");
			}
			System.out.println();
		}
	}
}
