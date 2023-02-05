import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N;
    long[][] answer = new long[1][1];

    for(int t = 0; t < 1000; t++) {
      N = Integer.parseInt(br.readLine());
      if(N == 0)
        break;
      
      answer = new long[N + 1][N + 1];
      answer[N][0] = 1;

      dp(answer, 0, 0);
      sb.append(answer[0][0]).append("\n");
    }

    System.out.println(sb);
  }

  private static long dp(long[][] answer, int W, int H) {
    if(answer[W][H] == 0) {
      long sum = 0;

      if(H != 0)
        sum += dp(answer, W + 1, H - 1);
      if(W + H < answer.length - 1)
        sum += dp(answer, W, H + 1);

      answer[W][H] = sum;
    }
    return answer[W][H];
  }
}