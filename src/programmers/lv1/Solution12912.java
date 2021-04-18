package programmers.lv1;

/**
 * 
 * @author 
 * EunmiKang 
 * Lv1.두 정수 사이의 합 
 * :: 
 * math
[입력 예제] 
a=3, b=5
a=3, b=3
a=5, b=3
 */

import java.util.Random;

public class Solution12912 {
	// 제출한 거
	public long solution1(int a, int b) {
		long answer = 0;

		if (a == b) {
			answer = a;
			return answer;
		}

		long min = a, max = b;
		if (a > b) {
			min = b;
			max = a;
		}

		if((max - min) % 2 == 1) { //max와 min 차가 홀수면 (min+max) * ((max-min+1)/2)
            answer = (min + max) * ((max - min + 1)/2);
        } else { //짝수면 (min+max)*((max-min+1)/2) + (min+max)/2
            answer = ( (min + max) * ((max - min + 1)/2) ) + ((min + max)/2);
        }  

		return answer;
	}

	public long solution2(int a, int b) {
		long answer = 0;

		int min = a, max = b;
		if (a > b) {
			min = b;
			max = a;
		}
		
		for (int i = min; i <= max; i++) {
			answer += i;
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution12912 test = new Solution12912();
		
		Random r = new Random();
		// -10,000,000 ~ 10,000,000 사이의 정수
		int a = r.nextInt((10000000) - (-10000000) + 1) + (-10000000);
		int b = r.nextInt((10000000) - (-10000000) + 1) + (-10000000);
		System.out.println("a:" + a + ", b:" + b);

		System.out.println(test.solution1(a, b));
		System.out.println(test.solution2(a, b));

	}
}
