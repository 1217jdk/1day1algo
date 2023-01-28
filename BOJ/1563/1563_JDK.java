import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N;
    int[][][] dp;
    N = Integer.parseInt(br.readLine());
    dp = new int[2][4][N];
    dp[0][1][0] = 1;
    dp[0][2][0] = 1;
    dp[1][0][0] = 1;

    for(int i = 1; i < N; i++) {
      for(int j = 0; j < 2; j++) {
        for(int k = 0; k < 4; k++) {
          switch(k) {
            case 0:
              if(j == 1) {
                for(int s = 0; s < 4; s++) {
                  dp[1][k][i] += dp[0][s][i - 1];
                  dp[1][k][i] %= 1000000;
                }                  
              }
              break;
            case 1:
              for(int s = 0; s < 4; s++) {
                dp[j][k][i] += dp[j][s][i - 1];
                dp[j][k][i] %= 1000000;
              }
              break;
            case 2:
              for(int s = 0; s < 2; s++) {
                dp[j][k][i] += dp[j][s][i - 1];
                dp[j][k][i] %= 1000000;
              }
              break;
            case 3:
              dp[j][k][i] = dp[j][k - 1][i - 1];
              break;
          }
        }
      }
    }

    int answer = 0;
    for(int i = 0; i < 2; i++) {
      for(int j = 0; j < 4; j++) {
        answer += dp[i][j][N - 1];
        answer %= 1000000;
      }
        
    }

    sb.append(answer);
    System.out.println(sb);
  }
}