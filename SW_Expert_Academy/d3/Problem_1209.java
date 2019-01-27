package d3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author EunmiKang
 * [S/W 문제해결 기본] 2일차 - Sum
 *
 */

public class Problem_1209 {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input_1209.txt"));
		String line = br.readLine(); // 테스트 케이스 수
		while(line != null) {
			int T = Integer.parseInt(line);
			int[][] matrix = new int[100][100];
			int max = 0;
			for (int r = 0; r < 100; r++) {
				String[] numbers = br.readLine().split(" ");
				for (int c = 0; c < 100; c++) {
					matrix[r][c] = Integer.parseInt(numbers[c]);
				}
			}
			
			/* 행의 합과 열의 합 확인 */
			for(int r=0; r<100; r++) {
				int sum_row = 0;
				int sum_col = 0;
				for(int c=0; c<100; c++) {
					sum_row += matrix[r][c];
					sum_col += matrix[c][r];
				}
				if(sum_row > max) {
					max = sum_row;
				}
				if(sum_col > max) {
					max = sum_col;
				}
			}
			
			/* 대각선 합 */
			int sum_LtoR = 0;
			int sum_RtoL = 0;
			for(int r=0; r<100; r++) {
				sum_LtoR += matrix[r][r];
				sum_RtoL += matrix[r][100-r-1];
			}
			if(sum_LtoR > max) {
				max = sum_LtoR;
			}
			if(sum_RtoL > max) {
				max = sum_RtoL;
			}
			System.out.println("#" + T + " " + max);
			line = br.readLine();
		}
		br.close();
	}
}
