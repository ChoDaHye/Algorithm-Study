import java.util.*;
import java.io.*;
// 백준 11399

public class Main1 {
    public static void main(String[] args) throws IOException {
        // 입력을 위한 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 번째 입력값인 N을 읽어 정수로 변환
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        // N개의 정수를 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 배열을 오름차순으로 정렬
        Arrays.sort(arr); // O(N log N)

        int time = 0;
        for (int i = 0; i < N; i++) {
            // 각 요소에 대해 (요소 값) * (남은 요소 수)를 시간에 더함
            time += (arr[i] * (N - i));
        }
        // 최종 시간 출력
        System.out.println(time);
    }
}

