package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 
 * @author EunmiKang
 * 문제 제목 붙이기
 *
 */
public class Solution7087 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		int ans, N;
		boolean[] title;
		String input;
		for(int tn=1; tn<=T; tn++) {
			//입력 및 문제 풀이
			N = Integer.parseInt(br.readLine().trim());
			title = new boolean[26];	//A~Z로 시작하는 단어 나왔나 안나왔나
			for(int i=0; i<N; i++) {
				input = br.readLine();
				title[input.charAt(0) - 'A'] = true;
			}
			
			for(ans = 0; ans<26; ans++) {
				if(!title[ans]) {
					break;
				}
			}
			
			//출력
			System.out.println("#" + tn + " " + ans);
		}
		br.close();
	}
}
