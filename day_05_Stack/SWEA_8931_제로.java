import java.io.*;
import java.util.Stack;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int TestCase = Integer.parseInt(br.readLine()); // 테스트 케이스
        Stack<Integer> stackInt = new Stack<>(); // 스택 배열 생성
 
        for (int T = 1; T <= TestCase; T++) {
            int K = Integer.parseInt(br.readLine());
            int res = 0;
 
            for (int i = 0; i < K; i++) {
                int num = Integer.parseInt(br.readLine());
                if (num == 0) { // 0일 경우 스택에서 숫자를 빼냄
                    stackInt.pop();
                } else {
                    stackInt.add(num);
                }
            }
 
            while (!(stackInt.isEmpty())) { // 스택이 비어있지 않은 경우
                res += stackInt.pop(); // 숫자를 빼서 결과에 더함
            }
            sb.append("#" + T + " " + res).append("\n");
        }
        System.out.println(sb);
    }
}