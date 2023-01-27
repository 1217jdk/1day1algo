import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N;
    int[][] adjs;

    N = Integer.parseInt(br.readLine());
    adjs = new int[N][N];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++)
        adjs[i][j] = Integer.parseInt(st.nextToken());
    }
    
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        for(int k = 0; k < N; k++) {
          if(adjs[j][i] == 1 && adjs[i][k] == 1)
            adjs[j][k] = 1;
        }
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++)
        sb.append(adjs[i][j]).append(" ");
      sb.setLength(sb.length() - 1);
      sb.append("\n");
    }
    System.out.println(sb);
  }
}