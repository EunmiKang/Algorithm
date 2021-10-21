package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 
 * @author 
 * EunmiKang 
 * 상어 초등학교
 * :: 
 * 삼성 기출 
[입력 예제] 
3
4 2 5 1 7
3 1 9 4 5
9 8 1 2 3
8 1 9 3 4
7 2 3 4 8
1 9 2 5 7
6 5 2 3 4
5 1 9 2 8
2 9 3 1 4
 */
public class Main21608 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int NN = N*N;	//학생수
		HashMap<Integer, ArrayList<Integer>> likeMap = new HashMap<>();
		int[] stus = new int[NN];
		for(int i=0; i<NN; i++) {
			input = br.readLine().split(" ");
			{
				int stu = Integer.parseInt(input[0]);
				ArrayList<Integer> likeList = new ArrayList<>();
				for(int j=1; j<5; j++) {
					likeList.add(Integer.parseInt(input[j]));
				}
				stus[i] = stu;
				likeMap.put(stu, likeList);
			}
		}
		br.close();
		
		int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
		//좌석 정해주기
		int[][] seatMap = new int[N][N];
		//첫 번째 친구는 고정 좌석~ (1,1)
		seatMap[1][1] = stus[0];
		for(int i=1; i<NN; i++) {
			/* 1. 비어있는 칸 중에서 좋아하는 학생이 가장 많은 인접한 칸으로 자리를 정한다. */
			int stu = stus[i];	//자리 정해줄 학생 번호
			int maxCnt = 0;	//좋아하는 학생 인접 칸 max
			ArrayList<Seat> seats = new ArrayList<>();
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(seatMap[r][c] == 0) {
						int cnt = 0;
						for(int d=0; d<4; d++) {
							int adjR = r + dir[d][0];
							int adjC = c + dir[d][1];
							if(isInBound(adjR,adjC,N) && seatMap[adjR][adjC] != 0) {
								//인접한 칸에 좋아하는 애 있음
								if(likeMap.get(stu).contains(seatMap[adjR][adjC])) {
									cnt++;
								}
							}
						}
						if(cnt >= maxCnt) {
							if(cnt > maxCnt) {
								maxCnt = cnt;
								seats.clear();
							}
							seats.add(new Seat(r, c));
						}
					}
				}
			}
			int seatsSize = seats.size();
			if(seatsSize == 1) {
				seatMap[seats.get(0).r][seats.get(0).c] = stu;
			} else {
				/* 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다. */
				//인접한 칸들 비어있는 칸 수 체크해주고, max값 체크
				maxCnt = 0;	//비어있는 인접 칸 max
				for(int si=0; si<seatsSize; si++) {
					Seat seat = seats.get(si);
					int r = seat.r, c = seat.c;
					int cnt = 0;
					for(int d=0; d<4; d++) {
						int adjR = r + dir[d][0];
						int adjC = c + dir[d][1];
						if(isInBound(adjR,adjC,N) && seatMap[adjR][adjC] == 0) {
							cnt++;
						}
					}
					if(cnt > maxCnt) {
						maxCnt = cnt;
					}
					seat.adjEmpty = cnt;
				}
				//maxCnt만 남기고 나머지 다 제거
				for(int si=0; si<seats.size(); si++) {
					Seat seat = seats.get(si);
					if(seat.adjEmpty < maxCnt) {
						seats.remove(seat);
						si--;
					}
				}
				
				if(seatsSize == 1) {
					seatMap[seats.get(0).r][seats.get(0).c] = stu;
				} else {
					/* 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다. */
					Collections.sort(seats, new Comparator<Seat>() {

						@Override
						public int compare(Seat s1, Seat s2) {
							if(s1.r != s2.r) {
								return s1.r - s2.r;
							} else {
								return s1.c - s2.c;
							}
						}
					});
					
					seatMap[seats.get(0).r][seats.get(0).c] = stu;
				}
				
			}
		}
		
		//만족도 조사
		//인접한 칸에 앉은 좋아하는 학생의 수가 0이면 학생의 만족도는 0, 1이면 1, 2이면 10, 3이면 100, 4이면 1000이다.
		int result = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				int cnt = 0;
				ArrayList<Integer> likeList = likeMap.get(seatMap[r][c]);
				for(int d=0; d<4; d++) {
					int adjR = r + dir[d][0];
					int adjC = c + dir[d][1];
					if(isInBound(adjR,adjC,N) && likeList.contains(seatMap[adjR][adjC])) {
						cnt++;
					}
				}
				if(cnt > 0) {
					result += (Math.pow(10, cnt-1));
				}
			}
		}
		
		System.out.println(result);
	} 
	
	public static class Seat {
		int r;
		int c;
		int adjEmpty = 0;	//인접한 비어있는 칸 수
		
		public Seat() {
			
		}
		
		public Seat(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "(" + r + "," + c + ") " + adjEmpty;
		}
	}
	
	public static boolean isInBound(int r, int c, int n) {
		return r>=0 && r<n && c>=0 && c<n;
	}
}
