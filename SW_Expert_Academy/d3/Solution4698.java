package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 
 * @author EunmiKang
 * 테네스의 특별한 소수
 * ::
 * A이상 B이하의 수 중에서 D를 포함한 소수인 것들의 개수 구하기
 * ::
 * 소수 미리 구해두기~0~
 * 
 */
public class Solution4698 {
	private static boolean[] isNotPrime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		int D, A, B, cnt, check;
		String[] input;

		// 소수 먼저 구해놓고 들어가실게요~ (시간 초과 방지)
		checkPrime(1000000); // 이 문제에서는 1000000이 최대 숫자
		
		for (int tn = 1; tn <= T; tn++) {
			// 입력 및 문제 풀이
			input = br.readLine().split(" ");
			D = Integer.parseInt(input[0]);
			A = Integer.parseInt(input[1]);
			B = Integer.parseInt(input[2]);

			// 문제 풀이
			cnt = 0;
			for (int i = A; i <= B; i++) {
				if (!isNotPrime[i]) {	//소수!
					check = i;
					while (check > 0) {
						if (check % 10 == D) {
							cnt++;
							break;
						}
						check /= 10;
					}
				}
			}

			// 출력
			System.out.println("#" + tn + " " + cnt);
		}
		br.close();
	}

	private static void checkPrime(int max) {
		isNotPrime = new boolean[max + 1];

		// 0, 1은 소수 아님
		isNotPrime[0] = true;
		isNotPrime[1] = true;

		int n;
		for (int i = 2; i <= Math.sqrt(max); i++) {
			if (!isNotPrime[i]) {
				for (int j = i; (n = i * j) <= max && n > i; j++) {
					isNotPrime[n] = true;
				}
			}
		}
	}
	
	/*private static void checkPrime2(int max) {
    	int k, tmp;
    	
    	isNotPrime = new boolean[max + 1];
    	 
    	 소수 체크(소수는 false) 
    	isNotPrime[0] = true;
    	isNotPrime[1] = true;
        for(int i=2; i<=max/2; i++) {
        	k = 2;
            while((tmp = i*k) <= max) {
            	isNotPrime[tmp] = true;
                k++;
            }
        }
    }*/
}
