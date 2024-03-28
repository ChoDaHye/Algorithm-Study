package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Marble_12845{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());	// 카드의 개수를 입력받는다
		String[] arr = br.readLine().split(" ");	// 입력받은 레벨을 나누어서 배열로 저장
		
		int i;
		int max = 0, sum = 0;
		for(i=0; i<n; i++) {
			int L = Integer.parseInt(arr[i]);	// String으로 저장된 레벨을 int로 변환해준다
			
			// 최대값을 가진 카드(max)와 다른 카드를 합치면 레벨이 작은 카드는 사라진다.
			// 따라서 max를 제외한 모든 카드는 한번씩만 더해지고
			// 이어서 max카드를 max가 다른 카드와 맺을 관계의 수(n-1) 만큼 더한다면 답(result)이 된다.
			// 이 result는 결국 max를 포함한 모든 카드를 한번씩 다 더하고 max를 (n-2)만큼 더한 값과 같다.
			
			sum += L;	// 모든 카드 레벨의 합을 구한다
			
			if(max < L) {
				max = L;	// 레벨 중 최대값을 구한다
			}
		}
		
		int result = sum + (max*(n-2));
		System.out.println(result);
	}
	
}
출처: https://kkangsman.tistory.com/8 [The Kkang's man:티스토리]