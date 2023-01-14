import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = 0;
    int[] sizes, dp;

    n = Integer.parseInt(br.readLine());
    sizes = new int[n];
    dp = new int[n];
    dp[0] = 1;

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      sizes[i] = Integer.parseInt(st.nextToken());
    }

    int max = 0, answer = 0;
    for(int i = 1; i < sizes.length; i++) {
      max = 0;
      for(int j = 0; j < i; j++) {
        if(sizes[j] >= sizes[i])
          continue;

        if(max < dp[j])
          max = dp[j];
      }
      dp[i] = max + 1;
      if(answer < dp[i]) answer = dp[i];
    }

    sb.append(answer);
    System.out.println(sb);
  }
}