import java.util.*;
import java.io.*;

public class Main1 {
    // 그래프의 간선 정보를 저장할 배열
	static int Edge_arr[][];
    // 노드의 방문 여부를 체크할 배열
	static boolean Visited_arr[];
    // 노드의 개수
	static int N;
    // 간선의 개수
	static int M;
    // 시작 노드
	static int V;
    // DFS 탐색에서 사용할 카운터 (사용되지 않는 변수로 보임, 삭제 가능)
    static int count;
    // BFS 탐색을 위한 큐
	static Queue<Integer> que = new LinkedList<>();

    // BFS 탐색 메서드
	public static void BFS(int start) {
		que.offer(start);	
		Visited_arr[start] = true;
		System.out.print(start + " ");

		while( !que.isEmpty() ) {
			start = que.poll();

			for(int i=1; i<=N; i++) {
				if(Edge_arr[start][i] == 1 && !Visited_arr[i]) {
					que.offer(i);
					Visited_arr[i] = true;
					System.out.print(i + " ");
				}
			}
		}	
	}

    // DFS 탐색 메서드
	public static void DFS(int start) {
		Visited_arr[start] = true;
		System.out.print(start + " ");

		for(int i=1; i<=N; i++) {
			if(Edge_arr[start][i] == 1 && !Visited_arr[i]) {
				DFS(i);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

        // N, M, V 입력 받기
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

        // 배열 초기화
		Edge_arr = new int[1001][1001];
		Visited_arr = new boolean[1001];

        // 간선 정보 입력 받기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

            // 무방향 그래프이므로 양방향으로 설정
			Edge_arr[x][y] = Edge_arr[y][x] = 1;
		}

        // DFS 실행
		DFS(V);
		System.out.println();

        // 방문 배열 초기화 후 BFS 실행
		Visited_arr = new boolean[1001];
		BFS(V);
	} 
}