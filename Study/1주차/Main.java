import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력으로 주어지는 문자열의 개수를 받음
        int N = Integer.parseInt(br.readLine());
        // 문자열의 각 자리의 값을 확인할때는 char형태로 바꿔서 확인하기 때문에 스택도 Character형으로 해준다.
        Stack<Character> stack = new Stack<>();

        // 각 문자열에 대해 반복
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            int length = str.length();

            // 문자열의 각 문자에 대해 반복
            for(int j=0; j<length; j++) {
                char ch = str.charAt(j);
                
                // '(' 일 경우 스택에 push
                if(ch == '(') {
                    stack.push(ch);
                }
                // ')' 일 경우
                else {
                    int size = stack.size();
                    // 스택이 비어있을 경우 '('를 push하고 종료
                    if(size == 0) {
                        stack.push(ch);
                        break;
                    }
                    // 스택이 비어있지 않을 경우 '('를 pop
                    else {
                        stack.pop();
                    }
                }
            }

            // 스택이 비어있으면 괄호가 모두 맞는 경우
            if(stack.isEmpty()) {
                System.out.println("YES");
            }
            // 스택이 비어있지 않으면 괄호가 맞지 않는 경우
            else {
                System.out.println("NO");
            }

            // 스택 초기화
            stack.clear();
        }
    } // End Main
} // End Class