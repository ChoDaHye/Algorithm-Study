import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        // 입력을 더 빠르게 받기 위해 BufferedReader와 StringTokenizer 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N과 K를 입력 받음. N은 사람의 수, K는 제거되는 순서
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 사람들을 순서대로 저장할 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 1부터 N까지의 번호를 큐에 차례대로 추가
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        // 결과를 저장할 StringBuilder. 요세푸스 순열을 문자열 형태로 만듦
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        // K번째를 찾기 위한 카운터
        int cnt = 1;
        while (queue.size() != 1) {
            if(cnt == K) {
                // K번째일 경우 큐에서 제거하고 결과 문자열에 추가
                sb.append(queue.poll()).append(", ");
                cnt = 1; // 카운터 리셋
            } else {
                // K번째가 아닐 경우 큐의 맨 뒤로 이동
                queue.offer(queue.poll());
                cnt++;
            }
        }
        // 마지막 남은 요소를 결과 문자열에 추가
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}