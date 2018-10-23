package reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFS {
	final int MAX_N = 30;
	public boolean[][] map;
	public boolean[] visited;
	Stack stack;
	
	public DFS() {
		map = new boolean[MAX_N+1][MAX_N+1];
		visited = new boolean[MAX_N+1];
		stack = new Stack(MAX_N);
	}
	
	public DFS(int N) {
		map = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		stack = new Stack(N);
	}
	
	public void run_dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		stack.push(start);
		while(!stack.isEmpty()) {
			int top = stack.peek();
			boolean pop_flag = true;
			for(int i=1; i<map.length; i++) {
				if((top != i) && map[top][i] && !visited[i]) {	// 방문하지않은 연결된 점 발견하면 방문 후 스택에 삽입
					visited[i] = true;
					System.out.print(i + " ");
					stack.push(i);
					pop_flag = false;
					break;
				}
			}
			if(pop_flag) {	// 방문하지 않은 연결된 점 없음
				stack.pop();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for (int i = 1; i <= T; i++) {
			String[] datas = br.readLine().split(" ");
			int N = Integer.parseInt(datas[0]); // 정점의 개수
			int start = Integer.parseInt(datas[1]);	// 시작 정점
			DFS dfs = new DFS(N);
			String connected = br.readLine();
			while(!connected.equals("-1 -1")) {	// 정점 간 연결 관계 체크
				String[] vertices = connected.split(" ");
				dfs.map[Integer.parseInt(vertices[0])][Integer.parseInt(vertices[1])] = true;
				dfs.map[Integer.parseInt(vertices[1])][Integer.parseInt(vertices[0])] = true;
				connected = br.readLine();
			}
			System.out.print("#" + i + " ");
			dfs.run_dfs(start);
			System.out.println();
		}
	}
}
