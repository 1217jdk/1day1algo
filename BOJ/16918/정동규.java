import java.util.*;
import java.io.*;

class Main {
  static class Point{
    int x = 0;
    int y = 0;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int R = 0, C = 0, N = 0;
    char[][] initial;
    char[][][] answers;

    st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    answers = new char[4][R][C];

    Deque<Point> bombs;
    bombs = new ArrayDeque<>();

    initial = init(br, bombs, R, C);
    
    answers[0] = fill(R, C);
    answers[2] = answers[0];

    answers[3] = boom(bombs, R, C);
    answers[1] = boom(bombs, R, C);

    char[][] answer;
    if(N == 1)
      answer = initial;
    else
      answer = answers[N % 4];
    for(int i = 0; i < answer.length; i++) {
      for(int j = 0; j < answer[i].length; j++) 
        sb.append(answer[i][j]);
      sb.append("\n");
    }
    
    System.out.println(sb);
  }

  private static char[][] init(BufferedReader br, Deque<Point> bombs, int R, int C) throws IOException {
    String line;
    char[][] board;
    
    board = new char[R][C];
    
    for(int i = 0; i < R; i++) {
      line = br.readLine();
      for(int j = 0; j < C; j++) {
        board[i][j] = line.charAt(j);
        if(line.charAt(j) == 'O')
          bombs.offer(new Point(j, i));
      }
    }

    return board;
  }

  private static char[][] fill(int R, int C) {
    char[][] board;
    
    board = new char[R][C];
    for(int i = 0; i < R; i++)
      Arrays.fill(board[i], 'O');

    return board;
  }

  private static char[][] boom(Deque<Point> bombs, int R, int C) {
    int nextX = 0, nextY = 0;
    Point front;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    char[][] board;
    
    board = fill(R, C);
    while(!bombs.isEmpty()) {
      front = bombs.poll();
      board[front.y][front.x] = '.';

      for(int d = 0; d < dx.length; d++) {
        nextX = front.x + dx[d];
        nextY = front.y + dy[d];

        if(isValid(R, C, nextX, nextY))
          board[nextY][nextX] = '.';
      }
    }

    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[i].length; j++) {
        if(board[i][j] == 'O')
          bombs.offer(new Point(j, i));
      }
    }

    return board;
  }

  private static boolean isValid(int R, int C, int nextX, int nextY) {
    if(nextX >= 0 && nextX < C && nextY >= 0 && nextY < R)
      return true;
    return false;
  }
}