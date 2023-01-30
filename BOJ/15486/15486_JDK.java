import java.util.*;
import java.io.*;

class Main {
  static int count;
  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N;
    int[] dp;
    int[][] inputs;

    N = Integer.parseInt(br.readLine());
    dp = new int[N + 1];
    inputs = new int[2][N];
    
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      inputs[0][i] = Integer.parseInt(st.nextToken());
      inputs[1][i] = Integer.parseInt(st.nextToken());
    }

    int index, pay, max;
    max = 0;
    for(int i = 0; i < N; i++) {
      if(max < dp[i])
        max = dp[i];
      else
        dp[i] = max;
      
      index = inputs[0][i] + i;
      pay = max + inputs[1][i];
      if(index < dp.length && dp[index] < pay)
        dp[index] = pay;
    }
    
    for(int i = 0; i < dp.length; i++) {
      if(max < dp[i])
        max = dp[i];
    }

    sb.append(max);
    System.out.println(sb);
  }
}