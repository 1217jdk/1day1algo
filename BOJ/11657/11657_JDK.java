import java.util.*;
import java.io.*;

class Main {
  static class Adj {
    int start;
    int end;
    long cost;

    public Adj(int start, int end, int cost) {
      this.start = start;
      this.end = end;
      this.cost = cost;
    }
  }
  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N, M, A, B, C;
    long[] bf;
    Adj[] adjs;
    
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    bf = new long[N];
    adjs = new Adj[M];
    Arrays.fill(bf, Integer.MAX_VALUE);

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      A = Integer.parseInt(st.nextToken()) - 1;
      B = Integer.parseInt(st.nextToken()) - 1;
      C = Integer.parseInt(st.nextToken());

      adjs[i] = new Adj(A, B, C);
    }

    boolean cycle;
    bf[0] = 0;
    cycle = isCycle(adjs, bf);

    if(cycle) {
      sb.append(-1);
    } else {
      for(int i = 1; i < bf.length; i++) {
        if(bf[i] == Integer.MAX_VALUE)
          sb.append(-1);
        else
          sb.append(bf[i]);
        sb.append("\n");
      }
    }

    System.out.println(sb);
  }

  private static boolean isCycle(Adj[] adjs, long[] bf) {
    Adj adj;
    
    for(int i = 0; i <= bf.length; i++) {
      for(int j = 0; j < adjs.length; j++) {
        adj = adjs[j];

        if(bf[adj.start] != Integer.MAX_VALUE && bf[adj.end] > bf[adj.start] + adj.cost) {
          if(i == bf.length)
            return true;

          bf[adj.end] = bf[adj.start] + adj.cost;
        }
      }
    }
    return false;
  }
}