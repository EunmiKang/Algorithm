package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author EunmiKang
 * 2016년 요일 맞추기
 *
 */

public class Problem_5515 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] days = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for (int i = 1; i <= T; i++) {
			String[] day = br.readLine().split(" ");
			int sum = 3;
			for (int j = 0; j < Integer.parseInt(day[0])-1; j++) {
				sum += days[j];
			}
			sum += Integer.parseInt(day[1]);
			System.out.println(sum);
			System.out.println("#" + i + " " + sum % 7);
		}
		br.close();
	}
}
