import java.util.*;

public class Main3 {
    // 그래프를 나타내는 인접 행렬
    static int[][] graph = new int[1001][1001];
    // 노드(정점)의 개수
    static int V;
    // 간선의 개수
    static int E;
    // 각 노드의 방문 여부를 체크할 배열
    static boolean[] visited = new boolean[1001];
    
    // 깊이 우선 탐색(DFS) 함수
    public static void dfs(int index) {
        // 현재 노드가 이미 방문된 경우 함수 종료
        if(visited[index]) return;
        // 현재 노드를 방문 처리
        visited[index] = true;
        // 현재 노드와 연결된 모든 노드를 순회
        for(int i = 1; i <= V; i++) {
            // 현재 노드와 i번 노드가 연결되어 있고, 아직 방문하지 않았다면 DFS 수행
            if(graph[index][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        // 노드와 간선의 개수 입력
        V = sc.nextInt();
        E = sc.nextInt();
        
        // 간선 정보 입력받아 그래프 구성
        for(int i = 0; i < E; i++) {
            int a = sc.nextInt(); // 간선의 한 끝
            int b = sc.nextInt(); // 다른 한 끝
            
            // 무방향 그래프이므로 양쪽 방향으로 연결
            graph[a][b] = graph[b][a] = 1;
        }
        
        int result = 0; // 연결 요소의 개수
        
        // 모든 노드에 대해 방문하지 않았다면 DFS 수행
        for(int i = 1; i <= V; i++) {
            if(!visited[i]) {
                dfs(i); // DFS 수행
                result++; // 새로운 연결 요소 발견
            }
        }
        
        // 연결 요소의 총 개수 출력
        System.out.println(result);
        
        sc.close();
    }
}
