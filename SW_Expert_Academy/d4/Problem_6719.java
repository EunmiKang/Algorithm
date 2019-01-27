package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @author EunmiKang
 * 성수의 프로그래밍 강좌 시청
 * ::
 * dfs로 풀었다가 시간 초과 뜸 ^^;
 *
 */
public class Problem_6719 {
	public static Integer[] classes;

	public static double count(int N, int K) {
		double count = 0;
		for (int i = N - K; i < N; i++) {
			count = (count + classes[i]) / 2;
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] line;
		int N, K;
		for (int tn = 1; tn <= T; tn++) {
			line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			K = Integer.parseInt(line[1]);

			classes = new Integer[N];
			line = br.readLine().split(" ");

			for (int i = 0; i < N; i++) {
				classes[i] = Integer.parseInt(line[i]);
			}

			// 오름차순으로 정렬
			Arrays.sort(classes);

			System.out.println("#" + tn + " " + count(N, K));
		}
		br.close();
	}
}
