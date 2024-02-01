import java.io.*;
import java.util.*;

public class SWEA_1989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        for (int T = 1; T <= num; T++) {
            String line = br.readLine(); // 문자열을 입력 받음
            int k = line.length(); // 문자열의 길이를 저장
            String[] arr = new String[line.length()]; // 문자열을 문자 하나하나 쪼개서 배열에 넣음
            for (int j = 0; j < line.length(); j++) {
                arr[j] = String.valueOf(line.charAt(j));
            }
            System.out.println("#" + T + " " + palindrome(arr, k));
        }
    }

    public static int palindrome(String[] arr, int k) { // 회문을 판별하는 메서드 생성
        int frontNum = (k-1) / 2; // 중앙을 기준으로 앞의 인덱스
        int backNum = k / 2; // 중앙을 기준으로 뒤의 인덱스
        int err = 1;

        while (true) {  // 문자열의 앞부분과 뒷부분을 비교
            if (--frontNum >= 0 && ++backNum < k) {
                if (!(arr[frontNum].equals(arr[backNum]))) {
                    err = 0;
                    break;
                }
            } else {  // 문자열의 시작과 끝까지 검사를 마친 경우 반복을 종료
                break;
            }
        }
        return err;
    }
}