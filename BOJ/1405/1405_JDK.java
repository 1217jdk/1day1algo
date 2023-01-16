import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N;
    double prob;
    double[] probs;
    boolean[][] visited;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    probs = new double[4];
    visited = new boolean[N * 2 + 1][N * 2 + 1];
    
    for(int i = 0; i < 4; i++) {
      prob = Double.parseDouble(st.nextToken());
      probs[i] = prob / 100;
    }

    double answer = simple(visited, probs, N, N, 1, 0);

    sb.append(answer);
    System.out.println(sb);
  }

  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  private static double simple(boolean[][] visited, double[] probs, int curX, int curY, double prob, int count) {
    if(visited[curY][curX])
      return 0;
    
    if(count == visited.length / 2)
      return prob;
    
    int nextX, nextY;
    double total = 0;

    visited[curY][curX] = true;
    for(int d = 0; d < dx.length; d++) {
      if(probs[d] == 0)
        continue;
      
      nextX = curX + dx[d];
      nextY = curY + dy[d];

      total += simple(visited, probs, nextX, nextY, prob * probs[d], count + 1);
    }

    visited[curY][curX] = false;
    return total;
  }
}