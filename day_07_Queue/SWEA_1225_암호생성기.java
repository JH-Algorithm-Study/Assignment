import java.io.*;
import java.util.*;

public class SWEA_암호생성기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();
        StringTokenizer st;

        for (int t= 0; t < 10; t++) {
            int T = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            int front = 0;
            int rear = 8;
            int c = 0;
            while (true) {
                // 나머지로 cycle을 구현, (c % 5) - 1 => [1, 2, 3, 4, 5]를 반복하며 빼는 것과 같다
                if (queue.peek() - (c % 5) - 1 > 0 ) queue.add(queue.poll() - (c % 5) - 1);
                else {
                    queue.poll();
                    while (!queue.isEmpty()) {
                        sb.append(queue.poll()).append(" ");
                    }
                    sb.append(0);
                    break;
                }
                front ++;
                rear ++;
                c ++;
            }
            res.append("#" + T + " " + sb).append("\n");
        }
        System.out.println(res);
    }
}
