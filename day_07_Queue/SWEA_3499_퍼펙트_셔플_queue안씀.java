import java.io.*;
import java.util.*;

public class SWEA_퍼펙트_셔플2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t= 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n]; // 배열 생성
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = st.nextToken();
            }

            int front = 0;
            int rear = (n + 1) / 2;
            int c = 0;
            for (int j = 0; j < n; j++) { // 홀수일 경우 앞, 짝수일 경우 뒤
                if (j % 2 == 0) sb.append(arr[front++]).append(" "); // 앞에서 한장
                else sb.append(arr[rear++]).append(" "); // 뒤에서 한장
            }
            res.append("#" + t + " " + sb).append("\n");
        }
        System.out.println(res);
    }
}