import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N, K;
    int[] counts;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    counts = new int[33554432];
    
    init(counts);

    int answer = -1;
    for(int i = N - 1; i < counts.length; i++) {
      if(counts[i] <= K) {
        answer = i - (N - 1);
        break;
      }
    }

    sb.append(answer);
    System.out.println(sb);
  }

  private static void init(int[] counts) {
    counts[0] = 1;
    for(int i = 1; i <= counts.length; i++)
      count(counts, i);
  }
  
  private static int count(int[] counts, int N) {
    if(counts[N - 1] != 0)
      return counts[N - 1];

    if(N % 2 == 0)
      counts[N - 1] = count(counts, N / 2);
    else
      counts[N - 1] = count(counts, N / 2) + 1;

    return counts[N - 1];
  }
}