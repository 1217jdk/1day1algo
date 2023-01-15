import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N;
    int[][] costs;

    N = Integer.parseInt(br.readLine());
    costs = new int[N][N];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++)
        costs[i][j] = Integer.parseInt(st.nextToken());
    }

    boolean[][] exist;
    exist = new boolean[N][N];

    select(costs, exist, 0, 0);

    sb.append(min);
    System.out.println(sb);
  }

  static int min = Integer.MAX_VALUE;
  static int[] dx = {0, -1, 0, 1, 0};
  static int[] dy = {-1, 0, 0, 0, 1};
  private static void select(int[][] costs, boolean[][] exist, int sum, int count) {
    if(count == 3) {
      if(min > sum)
        min = sum;
      return;
    }

    int nextX, nextY, subSum;
    boolean able;
    for(int i = 1; i < costs.length - 1; i++) {
      for(int j = 1; j < costs.length - 1; j++) {
        subSum = 0;
        able = true;
        
        for(int d = 0; d < dx.length; d++) {
          nextX = j + dx[d];
          nextY = i + dy[d];
          
          if(exist[nextY][nextX]) {
            able = false;
            break;
          }
        }
        
        if(able) {
          for(int d = 0; d < dx.length; d++) {
            nextX = j + dx[d];
            nextY = i + dy[d];
            subSum += costs[nextY][nextX];
            exist[nextY][nextX] = true;
          }
          select(costs, exist, sum + subSum, count + 1);
          for(int d = 0; d < dx.length; d++) {
            nextX = j + dx[d];
            nextY = i + dy[d];
            exist[nextY][nextX] = false;
          }
        }
      }
    }
  }
}