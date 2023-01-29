import java.util.*;
import java.io.*;

class Main {
  static int count;
  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n, k, coin;
    int[] coins, dp;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    coins = new int[n];
    dp = new int[k + 1];
    dp[0] = 1;

    for(int i = 0; i < n; i++)
      coins[i] = Integer.parseInt(br.readLine());

    for(int i = 0; i < n; i++) {
      coin = coins[i];
      for(int j = coin; j <= k; j++)
        dp[j] += dp[j - coin];
    }
    
    sb.append(dp[k]);
    System.out.println(sb);
  }
}