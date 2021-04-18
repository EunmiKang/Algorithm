package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @author 
 * EunmiKang 
 * 바이러스 
 * :: 
 * union, find 
[입력 예제] 
7
6
1 2
2 3
1 5
5 2
5 6
4 7
 */
public class Main2606 {
	static int[] root;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());
		root = new int[N + 1];
		Arrays.fill(root, -1);
		String[] input;
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			union(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		br.close();

		int c1root = find(1);
		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			if (find(i) == c1root) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static void union(int c1, int c2) {
		int rc1 = find(c1);
		int rc2 = find(c2);

		if (rc1 != rc2) {
			if (root[rc1] < root[rc2]) { // c1이 높이 더 높음 -> c2를 c1의 자식으로
				root[rc2] = rc1;
			} else {
				root[rc1] = rc2;
			}

			if (root[rc1] == root[rc2]) {
				root[rc2]--;
			}
		}
	}

	static int find(int c) {
		if (root[c] < 0) {
			return c;
		}

		int r = find(root[c]);
		root[c] = r;
		return r;
	}

}
