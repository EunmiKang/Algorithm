package sw_expert_academy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author EunmiKang 
 * 격자판의 숫자 이어 붙이기
 * ::
 * 완전 탐색, dfs, 방향 이동
 *
 */
public class Solution2819 {
	private static int count;
	private static int[][] mat;
	private static int[][] dir ={{0, 1}, {0, -1}, {1, 0}, {-1, 0}};	//동서남북 방향
	private static boolean[] checked;	//이미 count된 숫자인지 판단하기 위한 확인 flag 배열

	private static boolean isInBound(int r, int c, int x, int y) {
		return x >= 0 && y >= 0 && x < r && y < c;
	}

	private static void run(int r, int c, int depth, String numStr) {
		if (depth == 7) {
			int num = Integer.parseInt(numStr);
			if(!checked[num]) {	//아직 count 되지 않은 새로운 숫자면 count up!
				checked[num] = true;
				count++;
			}
			return;
		}
		
		/* 동서남북 방향으로 가봅시당 */	
		for(int i=0; i<4; i++) {
			if(isInBound(4, 4, r+dir[i][0], c+dir[i][1])) {	//가려는 방향이 경계 안에 속하면
				run(r+dir[i][0], c+dir[i][1], depth + 1, numStr + mat[r][c]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_2819.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] input;
		for (int tn = 1; tn <= T; tn++) {
			mat = new int[4][4];
			for (int r = 0; r < 4; r++) {
				input = br.readLine().split(" ");
				for (int c = 0; c < 4; c++) {
					mat[r][c] = Integer.parseInt(input[c]);
				}
			}

			count = 0;
			checked = new boolean[10000000];	//7자리 수까지 담아야 해..★
			for(int r = 0; r<4; r++) {
				for(int c = 0; c<4; c++) {
					run(r, c, 0, "");
				}
			}

			System.out.println("#" + tn + " " + count);
		}
		br.close();
	}
}
