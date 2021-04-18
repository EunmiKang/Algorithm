package sw_expert_academy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 
 * @author EunmiKang
 * [S/W 문제해결 응용] 2일차 - 최대 상금
 * ::
 * 백트래킹
 * 불필요한 작업 빼주는 거 중요!!!!
 * -> 이 문제에서는 checked 배열 활용한 부분 참고!
 *
 */
public class Solution1244 {
	private static int[] nums;
	private static int N, len, max;
	private static boolean[][] checked;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input1244.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		String[] input;
		for (int tn = 1; tn <= T; tn++) {
			// 입력
			input = br.readLine().split(" ");
			len = input[0].length();
			nums = new int[len];
			for (int i = 0; i < input[0].length(); i++) {
				nums[i] = input[0].charAt(i) - '0';
			}	//숫자판
			N = Integer.parseInt(input[1]);	//교환 횟수

			// 문제 풀이
			max = 0;
			checked = new boolean[N][(int)Math.pow(10, len)]; // 해당 depth에서 해당 숫자를 확인한 적 있는지 체크해놓는 배열
			dfs(0);

			// 출력
			System.out.println("#" + tn + " " + max);
		}
		br.close();
	}

	private static void dfs(int depth) {
		if (depth == N) {
			int num = arrayToInt(nums);
			if(num > max) {
				max = num;
			}
			return;
		}

		// 백트래킹 - 해당 depth에서 해당 숫자를 체크한적 있으면 중복 작업이므로 return
		if (checked[depth][arrayToInt(nums)]) {
			return;
		}

		checked[depth][arrayToInt(nums)] = true;	//해당depth에서 해당 숫자 작업했다고 체크해줍시당
		for (int i = 0; i < len-1; i++) {
			for (int j = i+1; j < len; j++) {
				swap(i, j);
				dfs(depth + 1);
				swap(i, j);
			}
		}
	}

	private static void swap(int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private static int arrayToInt(int[] arr) {
		int num = 0;
		for (int i = 0; i < len; i++) {
			num += arr[len - i - 1] * Math.pow(10, i);
		}
		return num;
	}
}
