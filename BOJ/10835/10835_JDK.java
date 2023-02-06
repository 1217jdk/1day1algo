import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N;
    int[][] cards, scores;

    N = Integer.parseInt(br.readLine());
    cards = new int[2][N];
    scores = new int[N][N];
    for(int i = 0; i < N; i++)
      Arrays.fill(scores[i], -1);

    for(int i = 0; i < 2; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++)
        cards[i][j] = Integer.parseInt(st.nextToken());
    }

    dp(cards, scores, N, 0, 0);

    sb.append(scores[0][0]);
    System.out.println(sb);
  }

  private static int dp(int[][] cards, int[][] scores, int N, int left, int right) {
    if(left == N || right == N)
      return 0;

    if(scores[left][right] != -1)
      return scores[left][right];

    if(cards[0][left] > cards[1][right]) {
      scores[left][right] = cards[1][right] + dp(cards, scores, N, left, right + 1);
    } else {
      int dropLeft = dp(cards, scores, N, left + 1, right);
      int dropBoth = dp(cards, scores, N, left + 1, right + 1);

      scores[left][right] = dropLeft > dropBoth ? dropLeft : dropBoth;
    }

    return scores[left][right];
  }
}