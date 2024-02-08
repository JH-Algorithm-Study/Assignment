import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int maxTime = 0; // 붕어빵의 마지막 손님이 오는 시간
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken()); // 붕어빵을 사러 오는 손님들의 시간을 arr배열에 담음
                if (maxTime < arr[j]) maxTime = arr[j];
            }

            int[] people = new int[maxTime + 1]; // 매 시간마다 몇명씩 오는지 구함
            for (int j = 0; j < n; j++) {
                people[arr[j]]++;
            }

            for (int j = 1; j <= maxTime; j++) { // 매 시간의 누적합
                people[j] += people[j - 1];
            }

            boolean isPossible = true;
            int fishBread = 0;
            for (int j = 0; j <= maxTime; j++) {
                if (j != 0 && j % m == 0) fishBread += k; // m으로 나누어떨어질 경우 붕어빵을 만들어냄
                if (fishBread < people[j]) {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) sb.append("#" + i + " Impossible").append("\n");
            else sb.append("#" + i + " Possible").append("\n");
        }
        System.out.print(sb);
    }
}