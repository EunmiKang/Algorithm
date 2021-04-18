package sw_expert_academy.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 파스칼의 삼각형 */

public class Problem_2005 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 개수
		for(int i=1; i<=T; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + i + "\n");
			int N = Integer.parseInt(br.readLine());
			int[][] pascal = new int[N][N];
			pascal[0][0] = 1;
			sb.append(pascal[0][0]);
			for(int r=1; r<N; r++) {
				sb.append("\n");
				for(int c=0; c<=r; c++) {
					if(c==0 || c==r) {	// boundary
						pascal[r][c] = 1;
						sb.append(pascal[r][c]);
						if(c==0) {
							sb.append(" ");
						}
					} else {
						pascal[r][c] = pascal[r-1][c-1] + pascal[r-1][c];
						sb.append(pascal[r][c] + " ");
					}
				}
			}
			System.out.println(sb);
		}
		br.close();
	}
}
