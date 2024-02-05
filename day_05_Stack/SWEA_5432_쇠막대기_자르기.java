import java.util.*;
import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stackStr = new Stack<>();
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            int res = 0;
            String beforeStr = null; // 이전의 괄호 저장
            for (int i = 0; i < str.length(); i++) {
                String k = String.valueOf(str.charAt(i));
                if (k.equals("(")) { // 여는 괄호일 때
                    stackStr.add("("); // Stack에 괄호를 저장
                } else if (beforeStr.equals("(")) { // 닫는 괄호일 때, 이전 괄호가 여는 괄호였을 경우
                    stackStr.pop();
                    res += stackStr.size();
                } else { // 닫는 괄호일 때, 이전 괄호가 닫는 괄호였을 경우
                    stackStr.pop();
                    res++;
                }
                beforeStr = k;
            }
            System.out.println("#" + t + " " + res);
        }
    }
}