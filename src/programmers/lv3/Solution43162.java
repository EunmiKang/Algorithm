package programmers.lv3;

/**
 * 
 * @author 
 * EunmiKang 
 * Lv3.네트워크
 * :: 
 * union, find 
[입력 예제] 
n=3, computers=[[1, 1, 0], [1, 1, 0], [0, 0, 1]]
n=3, computers=[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	
 */

import java.util.Arrays;

class Solution43162 {
	private int[] root;

	public int solution(int n, int[][] computers) {
		int answer = 0;

		// 0 ~ n-1 컴퓨터의 root 배열 (root들은 음수)
		root = new int[n];
		Arrays.fill(root, -1);

		for (int c1 = 0; c1 < n; c1++) {
			for (int c2 = c1 + 1; c2 < n; c2++) {
				if (computers[c1][c2] == 1) {
					union(c1, c2);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (root[i] < 0) {
				answer++;
			}
		}

		return answer;
	}

	private void union(int c1, int c2) {
		int rc1 = find(c1);
		int rc2 = find(c2);

		if (rc1 != rc2) {
			if (root[rc1] < root[rc2]) { // rc1이 깊이 더 깊어서 rc2를 rc1의 자식으로
				root[rc2] = rc1;
			} else {
				root[rc1] = rc2;
			}

			if (root[rc1] == root[rc2]) {
				root[rc2]--; // 깊이 하나 추가
			}
		}
	}

	private int find(int c) {
		if (root[c] < 0) { // 음수면 루트
			return c;
		}

		int r = find(root[c]);
		root[c] = r;
		return r;
	}
}
