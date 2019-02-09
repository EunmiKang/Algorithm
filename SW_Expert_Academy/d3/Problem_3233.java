package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author EunmiKang
 * 정삼각형 분할 놀이
 * ::
 * 수학
 * ::
 * 범위 주의!
 *
 */
public class Problem_3233 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] input;
		for (int tn = 1; tn <= T; tn++) {
			input = br.readLine().split(" ");
			
			//1 3 5 7 ... A/B항까지의 합! -> 등차수열 합공식 사용해봅시다			
			System.out.println("#" + tn + " " + (long) Math.pow(Integer.parseInt(input[0]) / Integer.parseInt(input[1]), 2));
		}
		
		br.close();
	}
}
