import java.util.*;
import java.io.*;

class Main {
  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = 0, N = 0;
    long answer = 0;
    long[] costs;
    Deque<Long> stk;

    T = Integer.parseInt(br.readLine());

    for(int t = 0; t < T; t++) {
      N = Integer.parseInt(br.readLine());

      answer = 0;
      costs = new long[N];
      stk = new ArrayDeque<>();
      
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++) {
        costs[i] = Integer.parseInt(st.nextToken());
      }

      for(int i = costs.length - 1; i >= 0; i--) {
        if(!stk.isEmpty() && stk.peek() > costs[i]) {
          answer += stk.peek() - costs[i];
        } else {
          stk.push(costs[i]);
        }
      }
      sb.append(answer).append("\n");
    }

    System.out.println(sb);
  }
}