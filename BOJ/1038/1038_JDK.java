import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N;
    PriorityQueue<Long> pq = new PriorityQueue<>();
    List<Long> decs = new ArrayList<>();

    N = Integer.parseInt(br.readLine());

    for(int i = 0; i < 10; i++)
      pq.offer((long)i);

    long front, max, prefix;
    while(!pq.isEmpty()) {
      front = pq.poll();
      decs.add(front);

      max = front % 10;
      prefix = front * 10;

      for(int i = 0; i < max; i++) {
        pq.offer(prefix + i);
      }
    }

    if(decs.size() > N)
      sb.append(decs.get(N));
    else
      sb.append(-1);
    System.out.println(sb);
  }
}