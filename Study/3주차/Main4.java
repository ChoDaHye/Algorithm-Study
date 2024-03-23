import java.util.*;

public class Main4 {
    // 그래프를 나타내는 인접 행렬
	static int[][] graph = new int[1001][1001];
	// 노드의 개수
	static int V;
	// 간선의 개수
	static int E;
	// 각 노드의 방문 여부를 체크할 배열
	static boolean[] visited = new boolean[1001];
	
	// DFS 함수
	public static void dfs(int index) {
	    // 이미 방문한 노드라면 더 이상 탐색하지 않음
		if(visited[index]) return;
		else {
			visited[index] = true; // 현재 노드를 방문 처리
			for(int i = 1; i <= V; i++) {
			    // 현재 노드와 연결된 노드에 대해 DFS 탐색 실행
				if(graph[index][i] == 1) {
					dfs(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		// 노드와 간선의 개수를 입력 받음
		V = sc.nextInt();
		E = sc.nextInt();
		
		// 간선 정보 입력 받아 인접 행렬에 저장
		for(int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			// 무방향 그래프이므로 양쪽 방향으로 간선 연결
			graph[a][b] = graph[b][a] = 1;
		}
		
		int result = 0; // 연결 요소의 개수
		
		// 모든 노드에 대해 DFS 실행하여 연결 요소 탐색
		for(int i = 1; i <= V; i++) {
			if(!visited[i]) { // 아직 방문하지 않은 노드에 대해 DFS 실행
				dfs(i);
				result++; // 새로운 연결 요소 발견
			}
		}
		
		System.out.println(result); // 연결 요소의 총 개수 출력
		
		sc.close();
	}
}