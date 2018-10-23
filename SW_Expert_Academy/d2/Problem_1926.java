package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 간단한 369 게임 */

public class Problem_1926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		for(int i=1; i<=N; i++) {
			String curr_num = i + "";
			if(curr_num.contains("3") || curr_num.contains("6") || curr_num.contains("9")) {
				for(int j=0; j<curr_num.length(); j++) {
					if(curr_num.charAt(j) == '3' || curr_num.charAt(j) == '6' || curr_num.charAt(j) == '9') {
						sb.append("-");
					}
				}
				sb.append(" ");
			} else {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);
	}
}
