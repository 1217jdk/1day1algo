import java.util.*;
import java.io.*;

class Main {
  static int answer;
  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int R, C, K;
    char[][] map;

    st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    
    String str;
    for(int i = 0; i < R; i++) {
      str = br.readLine();
      for(int j = 0; j < C; j++)
        map[i][j] = str.charAt(j);
    }

    map[R - 1][0] = 'T';
    dfs(map, K, 0, R - 1, 1);

    sb.append(answer);
    System.out.println(sb);
  }

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};
  private static void dfs(char[][] map, int K, int x, int y, int move) {
    int R, C;
    
    R = map.length;
    C = map[0].length;

    if(move == K) {
      if(x == C - 1 && y == 0)
        answer++;
      return;
    }

    int nextX, nextY;
    for(int d = 0; d < dx.length; d++) {
      nextX = x + dx[d];
      nextY = y + dy[d];
      
      if(isValid(R, C, nextX, nextY) && map[nextY][nextX] != 'T') {
        map[nextY][nextX] = 'T';
        dfs(map, K, nextX, nextY, move + 1);
        map[nextY][nextX] = '.';
      }
    }
  }

  private static boolean isValid(int R, int C, int x, int y) {
    if(x >= 0 && x < C && y >= 0 && y < R)
      return true;
    return false;
  }
}