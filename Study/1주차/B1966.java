import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    // 테스트 케이스의 수와 각 케이스에 대한 문서의 수(N), 확인하고 싶은 문서의 위치(M)
    static int tc;
    static int N, M;
    // 결과를 저장하기 위한 StringBuilder
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스의 수를 읽어옴
        tc = Integer.parseInt(br.readLine());
        
        // 각 테스트 케이스에 대해 실행
        for(int i = 0 ; i < tc ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 문서의 수와 확인하고 싶은 문서의 위치를 입력받음
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            StringTokenizer str = new StringTokenizer(br.readLine());
            
            // 문서와 그 중요도를 저장할 큐 생성
            LinkedList<int[]> q = new LinkedList<>();
            
            // 입력받은 중요도를 큐에 추가
            for(int j = 0; str.hasMoreTokens(); j++) {
                q.add(new int[] {j, Integer.parseInt(str.nextToken())});
            }
            
            // 인쇄된 문서의 수를 세기 위한 변수
            int count = 0;
            
            // 큐가 비어있지 않는 동안 반복
            while(!q.isEmpty()) {
                // 현재 문서를 큐에서 꺼냄
                int[] temp = q.poll();
                boolean check = true;
                
                // 큐에 남아있는 문서 중 현재 문서보다 중요도가 높은 문서가 있는지 확인
                for(int j = 0; j < q.size(); j++) {
                    if(temp[1] < q.get(j)[1]) {
                        // 중요도가 높은 문서가 있다면 현재 문서를 큐의 맨 뒤로 이동
                        q.add(temp);
                        
                        // j번째까지의 문서를 큐의 맨 뒤로 이동
                        for(int k = 0; k < j; k++)
                            q.add(q.poll());
                        
                        check = false;
                        break;
                    }
                }
                
                // 더 중요한 문서가 있어서 현재 문서를 큐의 뒤로 이동했다면 다음 반복으로 넘어감
                if(!check)
                    continue;
                
                // 현재 문서가 가장 중요도가 높아 인쇄되었다면 카운트 증가
                count++;
                
                // 인쇄된 문서가 확인하고 싶은 문서라면 반복 종료
                if(temp[0] == M)
                    break;
                
            }
            
            // 인쇄된 문서의 수를 결과에 추가
            sb.append(count).append("\n");
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}