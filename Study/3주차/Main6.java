import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main6 {
		// 필드 변수 선언
    static int n, m;        // 미로의 행과 열의 크기
    static int[][] maze;    // 미로의 구조를 저장하는 2차원 배열
    static int[][] visited; // 방문 여부와 이동 거리를 기록하는 2차원 배열
		
		// 방향 이동을 위한 배열 선언
    static int[] dr = {-1, 1, 0, 0};  // 상, 하 이동
    static int[] dc = {0, 0, -1, 1};  // 좌, 우 이동

    public static void main(String[] args) throws IOException {
		    // 입력을 위한 BufferedReader와 StringTokenizer 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 미로의 크기(n, m) 입력 받기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // 미로 및 방문 배열 초기화
        maze = new int[n + 1][m + 1];
        visited = new int[n + 1][m + 1];
        // 미로 정보 입력 받기
        for (int i = 1; i <= n; i++) {
		        // 한줄씩 읽어서 문자를 숫자로 변환하여 미로 배열에 저장
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                maze[i][j] = line.charAt(j - 1) - '0';
            }
        }
        // BFS 탐색을 위한 큐 선언
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1));   // 시작점을 큐에 추가         
        visited[1][1] = 1;        // 시작점의 이동 거리를 1로 설정 (방문 표시)
        // 큐가 비어있지 않은 동안 반복
        while (!q.isEmpty()) {
	          // 큐에서 현재 위치를 꺼냄
            Point now = q.poll();
            // 현재 위치에서 4방향으로의 이동을 시도
            for (int i = 0; i < 4; i++) {
		            // 다음 위치를 계산 (상, 하, 좌, 우)
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                // 계산된 다음 위치가 미로 범위 내에 있는지 확인
                if (nc <= 0 || nc > m || nr <= 0 || nr > n) continue;
                // 다음 위치를 방문하지 않았고, 이동할 수 있는 경로인지 확인 (벽이 아닌지)
                if (visited[nr][nc] == 0 && maze[nr][nc] == 1) {
		                // 다음 위치를 방문했다고 표시하고, 현재 위치에서의 이동 횟수에 1을 더해 기록
                    visited[nr][nc] = visited[now.r][now.c] + 1;
                    // 다음 위치를 큐에 추가하여 이동 가능한 경로로 고려
                    q.add(new Point(nr, nc));
                }
            }
        }
        // 목표지점(n-1, m-1)까지 도달하는데 필요한 최소 이동 횟수 출력
        System.out.println(visited[n][m]);
    }
}

// row, col 좌표를 나타내는 클래스. 
// 이 클래스의 인스턴스는 미로 내의 특정 위치를 나타내기 위해 사용
// 'r'은 row(행)의 위치를, 'c'는 col(열)의 위치를 나타낸다.
class Point {
    int r, c;
    // r 미로의 행 위치를 나타내는 정수.
     // c 미로의 열 위치를 나타내는 정수.
    Point(int r, int c) {
        this.r = r;  // 현재 인스턴스의 'r' 필드에 매개변수로 받은 행 위치를 할당한다.
        this.c = c;  // 현재 인스턴스의 'c' 필드에 매개변수로 받은 열 위치를 할당한다.
    }
}