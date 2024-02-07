import java.io.*;
import java.util.*;

public class SWEA_퍼펙트_셔플 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t= 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            Queue<String> queue = new LinkedList<>();
            Queue<String> queue2 = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < (n+1)/2; i++) { // 카드를 반으로 나눔, 카드의 개수가 
                queue.add(st.nextToken());      // 홀수일 땐 앞쪽이 한장 많도록 설정
            }
            for (int i = 0; i < n/2; i++) {
                queue2.add(st.nextToken());
            }

            while (true) {
                if (!queue.isEmpty()) sb.append(queue.poll()).append(" ");
                else break;
                if (!queue2.isEmpty()) sb.append(queue2.poll()).append(" ");
                else break;
            }
            res.append("#" + t + " " + sb).append("\n");
        }
        System.out.println(res);
    }
}