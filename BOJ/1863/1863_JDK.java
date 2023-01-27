import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n;
    Deque<Integer> stk = new ArrayDeque<>();

    n = Integer.parseInt(br.readLine());

    int index, height, count;
    count = 0;
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      index = Integer.parseInt(st.nextToken());
      height = Integer.parseInt(st.nextToken());

      while(!stk.isEmpty() && stk.peek() > height)
        stk.pop();

      if(height == 0)
        continue;

      if(stk.isEmpty() || stk.peek() < height) {
        stk.push(height);
        count++;
      }
    }

    sb.append(count);
    System.out.println(sb);
  }
}