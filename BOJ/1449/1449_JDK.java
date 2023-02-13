import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N, L;
    int[] leaks;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken()) - 1;

    leaks = new int[N];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++)
      leaks[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(leaks);

    int count, tape;
    count = 0;
    tape = 0;
    for(int leak: leaks) {
      if(leak <= tape)
        continue;

      count++;
      tape = leak + L;
    }

    sb.append(count);
    System.out.println(sb);
  }
}