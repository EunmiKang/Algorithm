package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author 
 * EunmiKang 
 * 마법사 상어와 비바라기
 * :: 
 * 삼성 기출 
[입력 예제] 
5 4
0 0 1 0 2
2 3 2 1 0
4 3 2 9 0
1 0 2 9 0
8 8 2 1 0
1 3
3 4
8 1
4 8
 */
public class Main21610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);	//격자 가로세로
		int M = Integer.parseInt(input[1]);	//이동 정보 수
		
		int[][] A = new int[N][N];	//격자 물의 양
		for(int r=0; r<N; r++) {
			input = br.readLine().split(" ");
			for(int c=0; c<N; c++) {
				A[r][c] = Integer.parseInt(input[c]);
			}
		}
		
		/* ←, ↖, ↑, ↗, →, ↘, ↓, ↙ */
		int[][] d_info = {{}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}}; 
		int d, s; //이동 방향, 거리
		ArrayList<Cloud> clouds = new ArrayList<>(); //비구름 위치
		boolean[][] gone = new boolean[N][N]; //구름 사라진 위치인지 여부
 		/* 처음 비구름 위치: (N, 1), (N, 2), (N-1, 1), (N-1, 2) - 나는 0 ~ (N-1)이라서 1씩 뺌 */
		clouds.add(new Cloud(N-1, 0));
		clouds.add(new Cloud(N-1, 1));
		clouds.add(new Cloud(N-2, 0));
		clouds.add(new Cloud(N-2, 1));
		
		/* 이동 */
		for(int i=0; i<M; i++) {
			input = br.readLine().split(" ");
			d = Integer.parseInt(input[0]);
			s = Integer.parseInt(input[1]);
			s %= N;
			
			int clouds_N = clouds.size();
			for(int j=0; j<clouds_N; j++) {
				/* 1. 모든 구름이 d 방향으로 s칸 이동한다. */
				Cloud cloud = clouds.get(j);
				cloud.r += d_info[d][0] * s;
				cloud.c += d_info[d][1] * s;
				
				if(cloud.r >= N) {
					cloud.r -= N;
				} else if(cloud.r < 0) {
					cloud.r += N;
				}
				
				if(cloud.c >= N) {
					cloud.c -= N;
				} else if(cloud.c < 0) {
					cloud.c += N;
				}
				
				/* 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다. */
				A[cloud.r][cloud.c]++;
				
				/* 3. 구름이 모두 사라진다. (여기서는 사라진 위치만 체크하고, 실제로 list에서 빼내는 건 for문 나가서 한꺼번에 (106줄) */
				gone[cloud.r][cloud.c] = true;
			}
			
			/* 4. 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다. 물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
			 *    이때는 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다.
			 *    예를 들어, (N, 2)에서 인접한 대각선 칸은 (N-1, 1), (N-1, 3)이고, (N, N)에서 인접한 대각선 칸은 (N-1, N-1)뿐이다. */
			for(int j=0; j<clouds_N; j++) {
				Cloud cloud = clouds.get(j);
				
				int cnt = 0;
				for(int k=2; k<9; k=k+2) { //대각선 체크
					int diagonalR = cloud.r + d_info[k][0];
					int diagonalC = cloud.c + d_info[k][1];
					if(isInBound(diagonalR, diagonalC, N) && A[diagonalR][diagonalC] > 0) {
						cnt++;
					}
				}
				A[cloud.r][cloud.c] += cnt;
			}
			
			/* 3. 구름이 모두 사라진다. */
			clouds.clear();
			
			/* 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다. */
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(A[r][c] >= 2 && !gone[r][c]) {
						clouds.add(new Cloud(r, c));
						A[r][c] -= 2;
					}
				}
			}

			//사라진 구름 배열 초기화
			for(int r=0; r<N; r++) {
				Arrays.fill(gone[r], false);
			}
		}
		br.close();
		
		//M번의 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합
		int ans = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				ans += A[r][c];
			}
		}
		
		System.out.println(ans);
	}
	
	public static class Cloud {
		int r;
		int c;
		
		public Cloud() {
			
		}
		
		public Cloud(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return r + "," + c;
		}
	}
	
	public static boolean isInBound(int r, int c, int N) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
