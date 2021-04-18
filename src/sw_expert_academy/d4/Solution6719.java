package sw_expert_academy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @author EunmiKang
 * 성수의 프로그래밍 강좌 시청
 * ::
 * dfs로 풀었다가 시간 초과 뜸 ^^;
 *
 */
public class Solution6719 {
	private static double ability;
	private static int[] classes;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_6719.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] line;
		int N, K;
		
		for(int tn=1; tn<=T; tn++) {
			line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			K = Integer.parseInt(line[1]);
			classes = new int[N];
			
			line = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				classes[i] = Integer.parseInt(line[i]);
			}
			
			solveAbility(N, K);
			
			System.out.print("#" + tn + " ");
			System.out.printf("%.6f\n", ability);
		}
		br.close();
	}
	
	public static void solveAbility(int N, int K) {
		/* 가질수 있는 최대수치를 구하는 것이기 때문에 큰 거 K개를 오름차순으로 선택해서 구하면 됨! */
		
		//정렬
		Arrays.sort(classes);
		
		ability = 0;
		for(int i=N-K; i<N; i++) {
			ability = (ability + classes[i])/2;
		}
	}
}
