package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main1 {
	
	// 변수 선언, 이 배열에 나중에 입력 받은 숫자들을 저장
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력한 숫자N을 읽어서 배열의 크기로 설정
		// 배열의 크기를 N으로 설정
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];	
		
		// 두번째 줄의 숫자들을 받아 배열에 저장
		// StringTokenizer을 사용하여 입력받은 문자를 공백으로 구분 (숫자들을 분리)
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
			
		// 이진 탐색은 정렬된 배열에서만 제대로 동작(오름차순)
		Arrays.sort(arr);
		
		// 세번째줄에 찾고 싶은 숫자의 개수(M)를 입력 받는다
		int M = Integer.parseInt(br.readLine());
		
		// 네번째 줄의 숫자을 확인
		st = new StringTokenizer(br.readLine(), " ");
		
		// 결과를 저장할 StringBuilder를 생성
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			
			// 찾고자 하는 값이 있을 경우 1, 없을 경우 0을 출력해야한다.
			if(search(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	
	/**
	 * @param key 찾으려는 값
	 * @return key와 일치하는 배열의 인덱스
	 */
	public static int search(int key) {
 
		int lo = 0;					// 탐색 범위의 왼쪽 끝 인덱스
		int hi = arr.length - 1;	// 탐색 범위의 오른쪽 끝 인덱스
 
		// lo가 hi보다 커지기 전까지 반복한다.
		while(lo <= hi) {
 
			int mid = (lo + hi) / 2;	// 중간위치를 구한다.
 
			// key값이 중간 위치의 값보다 작을 경우
			if(key < arr[mid]) {
				hi = mid - 1;
			}
			// key값이 중간 위치의 값보다 클 경우
			else if(key > arr[mid]) {
				lo = mid + 1;
			}
			// key값과 중간 위치의 값이 같을 경우
			else {
				return mid;
			}
		}
 
		// 찾고자 하는 값이 존재하지 않을 경우
		return -1;
 
	}
}
