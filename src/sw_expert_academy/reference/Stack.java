package sw_expert_academy.reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stack {
	private final int MAX_N = 100;
	public int[] stack;
	public int top;

	public Stack() {
		this.stack = new int[MAX_N];
		this.top = 0;
	}

	public Stack(int N) {
		this.stack = new int[N];
		this.top = 0;
	}

	public boolean isFull() {
		return (top == stack.length);
	}

	public boolean isEmpty() {
		return (top == 0);
	}

	public boolean push(int value) {
		if (isFull()) {
			System.out.println("stack overflow!");
			return false;
		}
		stack[top] = value;
		top++;
		return true;
	}
	
	public Integer peek() {
		if (isEmpty()) {
			System.out.println("stack is empty!");
			return null;
		}
		return stack[top-1];
	}

	public Integer pop() {
		if (isEmpty()) {
			System.out.println("stack is empty!");
			return null;
		}
		top--;
		return stack[top];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine()); // 데이터 크기
			String[] values = br.readLine().split(" ");
			
			Stack stack = new Stack(N);
			for (int j = 0; j < N; j++) {
				stack.push(Integer.parseInt(values[j]));
			}
			System.out.print("#" + i + " ");
			while(!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println();
		}
		br.close();
	}
}
