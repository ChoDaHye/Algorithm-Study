// 백준 1931
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MeetingRoom[] arr = new MeetingRoom[n];  //회의실 배열
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            arr[i] = new MeetingRoom(startTime, endTime);
        }
        Arrays.sort(arr);  //회의실을 종료 시간을 기준으로 정렬
        int count = 0;
        int time = 0;  //현재 시간
        for (int i = 0; i < n; i++) {
        //만약에 현재 시간이 i번째 회의 시작 시간보다 작거나 같으면 포함시킨다
            if (time <= arr[i].startTime) {  
                count++;
                time = arr[i].endTime;  //그리고 현재 시간은 i번째 회의가 끝난 시간이 된다
            }
        }
        System.out.print(count);
    }

    static class MeetingRoom implements Comparable<MeetingRoom> {  //회의실 클래스
        int startTime;  //시작 시간
        int endTime;  //종료 시간

        public MeetingRoom(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }


// 종료 시간을 내림차순으로 정렬하고 종료 시간이 같으면 시작 시간이 더 빠른게 앞으로 온다.
        @Override
        public int compareTo(MeetingRoom o) {
            if (endTime == o.endTime) return startTime - o.startTime;
            return endTime - o.endTime;
        }
    }
}