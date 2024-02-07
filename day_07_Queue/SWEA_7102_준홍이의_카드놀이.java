import java.io.*;
import java.util.*;

public class SWEA_준홍이의_카드놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t= 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] dp = new int[n + m + 1]; // [0, 1, 2, ... , n + m]

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i+j]++; // 카드 숫자 세기
                }
            }

            int maxInt = 0; // 최댓값 찾기
            for (int i = 1; i <= n+m; i++) {
                if (maxInt < dp[i]) maxInt = dp[i];
            }

            for (int i = 1; i <= n+m; i++) { // 최댓값 뽑기
                if (maxInt == dp[i]) sb.append(i).append(" ");
            }
            res.append("#" + t + " " + sb).append("\n"); // 결과값에 담기
        }
        System.out.println(res);
    }
}
