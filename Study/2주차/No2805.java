import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2805 {
    static int[] trees; // 전역 변수로 나무들의 높이를 저장할 배열 선언

    // main 메서드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무의 길이

        trees = new int[N]; // 나무의 높이를 저장할 배열 초기화
        int max = 0; // 나무의 최대 높이
        int min = 0; // 최소 높이 (이분 탐색의 하한값)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken()); // 나무 높이 입력
            max = Math.max(trees[i],max); // 최대 나무 높이 갱신
        }

        // 이분 탐색 시작
        while(min < max){
            int mid = (min + max) / 2; // 중간값 계산
            long sum = cutting(mid); // 중간값을 사용해 절단 후 얻을 수 있는 나무 길이의 합 계산

            // 목표 길이보다 적으면 더 많이 잘라야 하므로 상한값을 낮춤
            if(sum < M){
                max = mid;
            }else{ // 목표 길이보다 많으면 덜 잘라야 하므로 하한값을 높임
                min = mid + 1;
            }
        }
        System.out.println(min - 1); // 최적의 절단 높이 출력
    }

    // 절단 메서드: 주어진 높이로 나무들을 잘랐을 때 얻을 수 있는 나무 길이의 총합을 반환
    static long cutting(int height){
        long result = 0;
        for(int i = 0; i < trees.length; i++){
            if(trees[i] > height){
                result += trees[i] - height;
            }
        }
        return result;
    }
}