package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 패턴 마디의 길이 */

public class Problem_2007 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			String string = br.readLine();
			int count = 1;
			String word = string.charAt(0) + "";
			for (int j = 1; j < string.length(); j++) {
				int end = j + word.length();
				if (string.length() < end) {
					end = string.length();
				}
				if (!string.substring(j, end).equals(word)) {
					count++;
					word += string.charAt(j);
				} else {
					break;
				}
			}
			System.out.println("#" + i + " " + count);
		}
		br.close();
	}
}
