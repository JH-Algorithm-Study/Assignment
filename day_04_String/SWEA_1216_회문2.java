import java.util.*;
import java.io.*;

public class SWEA_1216 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int T = 1; T <= 10; T++) {
        int num = Integer.parseInt(br.readLine());
        String[][] arr = new String[100][100];

        for (int i = 0; i < 100; i++) {
            String line = br.readLine(); // 한 줄을 읽어옴
            for (int j = 0; j < line.length(); j++) {
                arr[i][j] = String.valueOf(line.charAt(j)); // 각 문자를 배열에 저장
            }
        }
        
        int maxInt = 0;
        for (int i = 0; i < 100; i++) {

            for (int k = 1; k < 100; k++) { // 한 문자를 기준으로 대칭
                int tmp = 1;
                int frontNum = k;
                int backNum = k;
                for (int j = k; j < 99; j++) { // 한 문자를 기준으로 대칭
                    if (--frontNum >= 0 && ++backNum < 100) {
                        if (arr[i][frontNum].equals(arr[i][backNum])) { // 가로 -> tmp
                            tmp += 2; // 양쪽이 같은 경우 +2를 해줌
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (maxInt < tmp) {
                    maxInt = tmp;
                }
            }

            for (int k = 1; k < 100; k++) { // 한 문자를 기준으로 대칭
                int tmp3 = 1;
                int frontNum = k;
                int backNum = k;
                for (int j = k; j < 99; j++) { // 한 문자를 기준으로 대칭
                    if (--frontNum >= 0 && ++backNum < 100) {
                        if (arr[frontNum][i].equals(arr[backNum][i])) { // 세로 -> tmp3
                            tmp3 += 2;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (maxInt < tmp3) {
                    maxInt = tmp3;
                }
            }

            for (int k = 0; k < 99; k++) { // 두 문자를 기준으로 대칭
                int tmp2 = 2;
                if (arr[i][k].equals(arr[i][k + 1])) { //  두 문자가 같으면
                    int frontNum = k;
                    int backNum = k + 1;

                    for (int j = k; j < 99; j++) {
                        if (--frontNum >= 0 && ++backNum < 100) {
                            if (arr[i][frontNum].equals(arr[i][backNum])) { // 가로 -> tmp2
                                tmp2 += 2;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (maxInt < tmp2) {
                    maxInt = tmp2;
                }
            }

            for (int k = 0; k < 99; k++) { // 두 문자를 기준으로 대칭
                int tmp4 = 2;
                if (arr[k][i].equals(arr[k + 1][i])) { //  두 문자가 같으면
                    int frontNum = k;
                    int backNum = k + 1;

                    for (int j = k; j < 99; j++) {
                        if (--frontNum >= 0 && ++backNum < 100) {
                            if (arr[frontNum][i].equals(arr[backNum][i])) { // 세로 -> tmp4
                                tmp4 += 2;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (maxInt < tmp4) {
                        maxInt = tmp4;
                    }
                }
            }
        }
        System.out.println("#" + T + " " + maxInt);
        }
    }
}