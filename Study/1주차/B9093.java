public class Main {

	public static void main(String[] args) throws Exception {
		// 메인 메소드. 자바 프로그램의 실행 시작점

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// System.in을 통해 콘솔 입력을 받기 위한 BufferedReader 객체 생성

		StringBuilder sb = new StringBuilder();
		// 문자열을 빌드하기 위한 StringBuilder 객체 생성 (이 코드에서는 사용되지 않음)

		int T = Integer.parseInt(br.readLine());
		// 첫 번째 입력을 정수로 변환하여 T에 저장. T는 테스트 케이스의 수를 나타냄

		for(int t=0;t<T;t++) {
			// T만큼 반복. 각 반복은 하나의 테스트 케이스를 처리

			String[] split = br.readLine().split(" ");
			// 공백을 기준으로 입력된 문자열을 분리하여 배열에 저장

			for(int i=0;i<split.length;i++) {
				// 입력된 각 단어에 대해 반복

				String temp = new StringBuilder(split[i]).reverse().toString();
				// 현재 단어를 뒤집기 위해 StringBuilder 객체를 생성하고, reverse 메소드를 호출한 뒤, 문자열로 변환

				System.out.print(temp+" ");
				// 뒤집힌 단어를 공백과 함께 출력
			}
		}
	}
}