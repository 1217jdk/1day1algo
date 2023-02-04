import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
;
    int[] sizes = new int[3];
    Queue<String> que = new ArrayDeque<>();
    Set<String> set = new HashSet<>();

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < 3; i++)
      sizes[i] = Integer.parseInt(st.nextToken());

    int gap;
    String front, volumes;
    int[] cur = new int[3], temp = new int[3];
    boolean[] answer = new boolean[201];
    
    sb.append("0.0.").append(sizes[2]);
    volumes = sb.toString();
    que.offer(volumes);
    sb.setLength(0);

    set.add(volumes);
    answer[sizes[2]] = true;
    while(!que.isEmpty()) {
      front = que.poll();
      
      st = new StringTokenizer(front, ".");
      for(int i = 0; i < 3; i++)
        cur[i] = Integer.parseInt(st.nextToken());

      for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
          if(i == j)
            continue;

          if(cur[i] != 0 && cur[j] != sizes[j]) {
            for(int k = 0; k < 3; k++)
              temp[k] = cur[k];

            gap = sizes[j] - cur[j];
            if(cur[i] < gap) {
              temp[i] = 0;
              temp[j] += cur[i];
            } else {
              temp[i] = cur[i] - gap;
              temp[j] = sizes[j];
            }

            for(int k = 0; k < 3; k++)
              sb.append(temp[k]).append(".");
            sb.setLength(sb.length() - 1);

            volumes = sb.toString();
            sb.setLength(0);
            
            if(!set.contains(volumes)) {
              set.add(volumes);
              que.offer(volumes);
              if(temp[0] == 0)
                answer[temp[2]] = true;
            }
          }
        }
      }
    }

    for(int i = 0; i < answer.length; i++) {
      if(answer[i])
        sb.append(i).append(" ");
    }
    sb.setLength(sb.length() - 1);
    System.out.println(sb);
  }
}