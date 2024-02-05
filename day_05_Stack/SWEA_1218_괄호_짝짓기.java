import java.io.*;
import java.util.Stack;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        for (int T = 1; T <= 10; T++) {
            Stack<String> stackStr = new Stack<>();
            int K = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int err = 1; // error 없는 상태
 
            for (int i = 0; i < K; i++) {
                String k = String.valueOf(str.charAt(i));
 
                // 여는 괄호들은 Stack에 저장
                if (k.equals("(") || k.equals("[") || k.equals("{") || k.equals("<")) {
                    stackStr.add(k);
                } else if (k.equals(")")) { // 닫는 괄호의 경우 짝이 맞지 않으면 바로 중단
                    if (!("(").equals(stackStr.pop())) {
                        err = 0; // error 있는 상태
                        break;
                    }
                } else if (k.equals("]")) {
                    if (!("[").equals(stackStr.pop())) {
                        err = 0;
                        break;
                    }
                } else if (k.equals("}")) {
                    if (!("{").equals(stackStr.pop())) {
                        err = 0;
                        break;
                    }
                } else if (k.equals(">")) {
                    if (!("<").equals(stackStr.pop())) {
                        err = 0;
                        break;
                    }
                }
            }
 
            sb.append("#" + T + " " + err).append("\n");
        }
        System.out.print(sb);
    }
}