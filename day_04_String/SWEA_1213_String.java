import java.io.*;

public class SWEA_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int T = 1; T <= 10; T++) {
            int num = Integer.parseInt(br.readLine());
            String pattern = br.readLine();
            String text = br.readLine();

            int result = patternMatching(text.toCharArray(), pattern.toCharArray());

            System.out.println("#" + T + " " + result);
        }
    }

    public static int patternMatching(char[] text, char[] pattern) { // 패턴매칭 메서드 생성
        int cnt = 0;
        // i : 패턴 비교 시작 위치
        // j : 문자 하나씩 비교하는 인덱스
        start: for (int i = 0; i < text.length - pattern.length + 1; i++) { // 문자의 길이 - 패턴의 길이 + 1
            pattern: for (int j = 0; j < pattern.length; j++) {
                if (text[i + j] != pattern[j]) {
                    continue start;
                }
            }
            // 이 영역에 들어오면 패턴매칭 성공
            cnt ++;
        }
        return cnt;
    }
}