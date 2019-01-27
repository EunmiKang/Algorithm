package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author EunmiKang
 * 최장 증가 부분 수열
 * ::
 * DP
 *
 */
public class Problem_3307 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int Tn = 1; Tn <= T; Tn++) {
				int N = Integer.parseInt(br.readLine());	// 수열 길이
				String[] inputNums = br.readLine().split(" ");
				int[] nums = new int[N];
				// 수열 초기화
				for(int i=0; i<N; i++) {
					nums[i] = Integer.parseInt(inputNums[i]);
				}
				
				int max = 0;
				int[] dp = new int[N];
				dp[0] = 1;
				
				for(int i=1; i<N; i++) {
					dp[i] = 1;
					for(int j=0; j<i; j++) {
						if(nums[i] > nums[j] && (dp[j] + 1) > dp[i]) {
							dp[i] = dp[j] + 1;
						}
					}
					
					max = Integer.max(max, dp[i]);
				}

				System.out.println("#" + Tn + " " + max);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
