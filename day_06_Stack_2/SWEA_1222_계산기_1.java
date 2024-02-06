import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int T = 1; T <= 10; T++) {
            int testLine = Integer.parseInt(br.readLine());
            String str = br.readLine();
            StringBuilder sb = new StringBuilder(); // 후위표기식을 저장하는 위치
            Stack<Character> stackChar = new Stack<>(); // 후위표기식 변환할 때 연산자를 저장하는 곳
            Stack<Integer> stackInt = new Stack<>(); // 후위표기식 계산할 때 숫자를 저장하는 곳

            // 중위표기식 -> 후위표기식
            for (int i = 0; i < testLine; i++) {
                if (str.charAt(i) >= '0' && (str.charAt(i) <= '9')) { // 1. 숫자일 때
                    sb.append(str.charAt(i));
                } else if ((!stackChar.isEmpty()) && str.charAt(i) == ')') { // 2. 닫는 괄호일 때
                    while (stackChar.peek() != '(') { // 여는 괄호일 때까지 stack을 빼냄
                        sb.append(stackChar.pop());
                    }
                    stackChar.pop(); // 여는 괄호도 빼냄

                } else { // 3. 위에 해당되지 않는 경우
                    stackChar.add(str.charAt(i)); // 스택에 더함
                }
            }
            while (!(stackChar.isEmpty())) sb.append(stackChar.pop());

            // 후위연산 계산기
            for (int i = 0; i < sb.length(); i++) { 
                if (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
                    stackInt.add((int) sb.charAt(i) - '0'); // char을 int형으로 변환
                } else if (sb.charAt(i) == '+') {
                    stackInt.add(stackInt.pop() + stackInt.pop());
                }
            }
            int res = stackInt.pop();
            System.out.println("#" + T + " " + res);
        }
    }
}