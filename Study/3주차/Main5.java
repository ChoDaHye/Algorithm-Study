import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Main5 {
    static int n, k; // 시작 위치(n)와 목표 위치(k)를 저장할 변수
    static int[] visited = new int[100001]; // 각 위치를 방문했는지, 그리고 몇 번만에 방문했는지 저장할 배열

    public static void main(String[] args) throws IOException {
        // 입력 처리를 위한 BufferedReader와 StringTokenizer 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받은 시작 위치와 목표 위치를 정수로 변환
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>(); // BFS 탐색을 위한 큐
        q.add(n); // 시작 위치를 큐에 추가
        visited[n] = 1; // 시작 위치를 방문했다고 표시 (시간은 1부터 시작)

        // BFS 탐색 시작
        while (!q.isEmpty()) {
            int now = q.poll(); // 현재 위치를 큐에서 꺼냄

            if (now == k) break; // 현재 위치가 목표 위치와 같다면 탐색 종료

            // 현재 위치에서 이동할 수 있는 다음 위치들: 현재 위치 - 1, 현재 위치 + 1, 현재 위치 * 2
            int[] next = {now - 1, now + 1, now * 2};
            for (int i = 0; i < 3; i++) {
                if(!isRange(next[i])) continue; // 다음 위치가 유효한 범위 내에 있는지 확인
                if (visited[next[i]] == 0) { // 다음 위치를 아직 방문하지 않았다면
                    visited[next[i]] = visited[now] + 1; // 현재 위치에서 한 번 더 이동했으므로 시간을 업데이트
                    q.add(next[i]); // 다음 위치를 큐에 추가
                }
            }
        }

        System.out.println(visited[k] - 1); // 실제 시간은 배열에 저장된 시간 - 1
    }

    // 주어진 위치 x가 유효한 범위(0 ~ 100000) 내에 있는지 확인하는 함수
    static boolean isRange(int x) {
        return x >= 0 && x <= 100000;
    }
}
