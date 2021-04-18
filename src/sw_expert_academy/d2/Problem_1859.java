package sw_expert_academy.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 백만장자 프로젝트 */

public class Problem_1859 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 수
		for(int i=1; i<=T; i++) {
			long result = 0;
			int N = Integer.parseInt(br.readLine());
			String[] read_prices = br.readLine().split(" ");
			int[] prices = new int[N];	// N개의 매매가
			for(int j=0; j<N; j++) {
				prices[j] = Integer.parseInt(read_prices[j]);
			}
			
			int curr_max = prices[N-1];
			for(int j=N-2; j>=0; j--) {
				if(curr_max > prices[j]) {
					result += curr_max - prices[j];
				} else if(curr_max < prices[j]){
					curr_max = prices[j];
				}
			}
			System.out.println("#" + i + " " + result);
		}
		br.close();
	}
}
