import java.util.*;
import java.io.*;

class Main {
  static int count;
  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N, M;
    int[][] board, res;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N][M];
    res = new int[N][M];

    String str;
    for(int i = 0; i < N; i++) {
      str = br.readLine();
      for(int j = 0; j < M; j++)
        board[i][j] = str.charAt(j) - '0';
    }
    for(int i = 0; i < N; i++) {
      str = br.readLine();
      for(int j = 0; j < M; j++)
        res[i][j] = str.charAt(j) - '0';
    }

    int min = N > M ? M : N;
    count = 0;
    for(int i = 0; i < min / 2; i++) {
      for(int j = 0; j < (N - 1) / 2; j++) {
        for(int k = 0; k < (M - 1) / 2; k++)
          corner(board, res, M - k * 2, N - j * 2, k, j);
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(board[i][j] != res[i][j]) {
          count = -1;
          break;
        }
      }
      if(count == -1)
        break;
    }

    sb.append(count);
    System.out.println(sb);
  }
  
  private static void corner(int[][] board, int[][] res, int sizeX, int sizeY, int startX, int startY) {
    int curX, curY;

    for(int i = 0; i < 2; i++) {
      for(int j = 0; j < 2; j++) {
        curX = startX + j * (sizeX - 1);
        curY = startY + i * (sizeY - 1);

        if(board[curY][curX] != res[curY][curX]) {
          change(board, curX - j * 2, curY - i * 2);
          count++;
        }
      }
    }
  }

  private static void change(int[][] board, int startX, int startY) {
    for(int i = startY; i < startY + 3; i++) {
      for(int j = startX; j < startX + 3; j++)
        board[i][j] = (board[i][j] + 1) % 2;
    }
  }
}