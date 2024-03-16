import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 상근이가 가지고 있는 숫자 카드의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 숫자 카드에 적힌 정수 배열 입력
        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        // 숫자 카드를 정렬하여 이진 탐색을 위해 준비
        Arrays.sort(cards);

        // 몇 개의 숫자 카드를 구해야 할지 입력
        int M = Integer.parseInt(br.readLine());
        
        // 구해야 할 숫자들을 배열에 입력
        st = new StringTokenizer(br.readLine());
        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        // 이진 탐색을 통해 상근이가 가지고 있는 숫자 카드 중 해당하는 수가 몇 개인지 찾기
        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            int count = binarySearch(cards, target);
            sb.append(count).append(" ");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }

    // 이진 탐색을 통해 해당하는 수가 몇 개인지 찾는 메서드
    private static int binarySearch(int[] cards, int target) {
        int left = 0;
        int right = cards.length - 1;
        int count = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = cards[mid];

            if (midValue == target) { // 해당하는 수를 찾았을 때
                count++;
                // 중복된 수가 있을 수 있으므로, 왼쪽과 오른쪽을 모두 확인하여 개수 측정
                int leftPointer = mid - 1;
                int rightPointer = mid + 1;

                // 왼쪽으로 이동하며 중복된 수 확인
                while (leftPointer >= 0 && cards[leftPointer] == target) {
                    count++;
                    leftPointer--;
                }

                // 오른쪽으로 이동하며 중복된 수 확인
                while (rightPointer < cards.length && cards[rightPointer] == target) {
                    count++;
                    rightPointer++;
                }
                break;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return count;
    }
}