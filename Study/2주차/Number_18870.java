import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Number_18870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 입력 받을 숫자의 개수

        int[] array = new int[n]; // 원본 배열
        int[] arraySort = new int[n]; // 정렬될 배열
        HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>(); // 압축할 값을 저장할 HashMap

        // 배열 입력
        for(int i = 0; i < n; i++) {
            array[i] = arraySort[i] = sc.nextInt(); // 입력 받은 숫자를 원본 배열과 정렬 배열에 저장
        }

        // 배열 정렬
        Arrays.sort(arraySort); // arraySort 배열을 오름차순으로 정렬

        // 배열의 압축값을 map에 저장
        int rank = 0; // 순위를 저장할 변수, 0부터 시작

        for(int value : arraySort) {
            if(!rankMap.containsKey(value)) { // 현재 값이 map에 없으면 추가
                rankMap.put(value, rank); // 현재 숫자의 순위를 매김
                rank++; // 다음 숫자를 위해 순위 증가
            }
        }

        // 원본 배열의 순서대로 해당 압축 값을 출력
        StringBuilder sb = new StringBuilder();
        for(int value : array) {
            sb.append(rankMap.get(value)).append(' '); // 원본 배열의 값을 통해 순위를 찾아서 추가
        }

        System.out.println(sb); // 결과 출력
    }
}