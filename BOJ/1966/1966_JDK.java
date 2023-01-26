import java.util.*;
import java.io.*;

class Main {
  static class Document {
    int index;
    int priority;

    public Document(int index, int priority) {
      this.index = index;
      this.priority = priority;
    }
  }
  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T, N, M;

    T = Integer.parseInt(br.readLine());

    int priority, cur, res;
    Document front;
    int[] counts;
    Queue<Document> que;
    for(int t = 0; t < T; t++) {
      cur = 0;
      res = 1;
      counts = new int[9];
      que = new ArrayDeque<>();
      
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++) {
        priority = Integer.parseInt(st.nextToken()) - 1;
        counts[priority]++;
        if(cur < priority)
          cur = priority;
        que.offer(new Document(i, priority));
      }
      
      while(!que.isEmpty()) {
        front = que.poll();
        
        if(front.priority == cur) {
          if(front.index == M) {
            sb.append(res).append("\n");
            break;
          }
          res++;

          counts[cur]--;
          while(counts[cur] == 0)
            cur--;
        } else {
          que.offer(front);
        }
      }
    }
    
    System.out.println(sb);
  }
}