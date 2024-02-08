import java.io.*;
import java.util.*;

public class 삽입정렬2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] data = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                data[j] = Integer.parseInt(st.nextToken());
            }

            for (int k = 0; k < data.length - 1; k++) {
                for (int l = k; l >= 0; l--) {
                    if (data[l] > data[l + 1]) {
                        int tmp = data[l];
                        data[l] = data[l + 1];
                        data[l + 1] = tmp;
                    }
                }
            }
            sb.append("#" + i + " ");
            for (int k = 0; k < data.length; k++) {
                sb.append(data[k]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}