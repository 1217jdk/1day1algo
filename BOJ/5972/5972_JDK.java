import java.util.*;
import java.io.*;

class Main {
  static class Adj implements Comparable<Adj>{
    int end;
    int cost;

    public Adj(int end, int cost) {
      this.end = end;
      this.cost = cost;
    }

    public int compareTo(Adj o) {
      return this.cost - o.cost;
    }
  }
  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N, M;
    int[] dijk;
    List<Map<Integer, Integer>> adjs = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    dijk = new int[N];
    Arrays.fill(dijk, Integer.MAX_VALUE);
    for(int i = 0; i < N; i++)
      adjs.add(new HashMap<>());

    int A, B, C;
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      A = Integer.parseInt(st.nextToken()) - 1;
      B = Integer.parseInt(st.nextToken()) - 1;
      C = Integer.parseInt(st.nextToken());

      if(!adjs.get(A).containsKey(B) || (adjs.get(A).containsKey(B) && adjs.get(A).get(B) > C)) {
        adjs.get(A).put(B, C);
        adjs.get(B).put(A, C);
      }
    }

    Adj front;
    Map<Integer, Integer> curAdjs;
    PriorityQueue<Adj> pq = new PriorityQueue<>();

    dijk[0] = 0;
    pq.offer(new Adj(0, 0));
    
    while(!pq.isEmpty()) {
      front = pq.poll();

      if(front.cost > dijk[front.end])
        continue;
      
      curAdjs = adjs.get(front.end);
      for(int next: curAdjs.keySet()) {
        if(dijk[next] > dijk[front.end] + curAdjs.get(next)) {
          dijk[next] = dijk[front.end] + curAdjs.get(next);
          pq.offer(new Adj(next, dijk[next]));
        }
      }
    }

    sb.append(dijk[N - 1]);
    System.out.println(sb);
  }
}