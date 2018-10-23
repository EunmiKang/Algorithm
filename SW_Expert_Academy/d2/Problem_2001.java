package d2;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/* 파리 퇴치 */

public class Problem_2001 {
	public static int count(int[][] area, int row, int column, int M) {
		int sum = 0;
		for (int r = row; r < row + M; r++) {
			for (int c = column; c < column + M; c++) {
				sum += area[r][c];
			}
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for (int i = 1; i <= T; i++) {
			String[] N_M = br.readLine().split(" ");
			int N = Integer.parseInt(N_M[0]);
			int M = Integer.parseInt(N_M[1]);
			int[][] area = new int[N][N];
			for (int r = 0; r < N; r++) {
				String[] line = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					area[r][c] = Integer.parseInt(line[c]);
				}
			}

			int max = 0;
			for (int r = 0; r <= N - M; r++) {
				for (int c = 0; c <= N - M; c++) {
					int curr_count = count(area, r, c, M);
					if (curr_count > max) {
						max = curr_count;
					}
				}
			}
			
			System.out.println("#" + i + " " + max);
		}
		br.close();
	}
}
