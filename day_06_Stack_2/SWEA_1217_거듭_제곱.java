import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 10; t++) {
            int T = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int result = factorial(n, m);
            System.out.println("#" + T + " " + result);
        }
    }

    public static int factorial(int n, int m) {
		if (m <= 0) return 1;
        return n * factorial(n, m - 1);
    }
}

/*
= 5 * factorial(5, 4)
= 5 * 5 * factorial(5, 3)
= 5 * 5 * 5 * factorial(5, 2)
= 5 * 5 * 5 * 5 * factorial(5, 1)
= 5 * 5 * 5 * 5 * 5 * 1
*/