// 백준 11047

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		
		//동전의 가치들을 배열에 저장
		for(int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		//조건에 충족하지 못할 경우 다시 K값을 되돌려야 하기때문에 따로 변수를 만든다.
		int now = K;
		int result = 0;
		//원하는 가치의 합이 딱 맞을때까지 반복
		while(now != 0) {
			for(int i = N - 1; i >= 0; i--) {
				if(now >= coin[i]) {
					result += (now / coin[i]);
					now %= coin[i];
					if(now < coin[0] && now != 0) {
						result = 0;
						now = K;
					}
				}
			}
		}
		System.out.println(result);
	}

}