import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N;
    int[][] nums;

    N = Integer.parseInt(br.readLine());
    nums = new int[N][N];
    
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++)
        nums[i][j] = Integer.parseInt(st.nextToken());
    }

    int answer = lottery(nums, N, 0, 0);
    sb.append(answer);
    System.out.println(sb);
  }

  private static int lottery(int[][] nums, int size, int startX, int startY) {
    List<Integer> sorted = new ArrayList<>();
    if(size == 1) {
      return nums[0][0];
    } else if(size == 2) {  
      for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 2; j++)
          sorted.add(nums[startY + i][startX + j]);
      }
    } else {
      int nextSize = size / 2;
      for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 2; j++)
          sorted.add(lottery(nums, nextSize, startX + nextSize * j, startY + nextSize * i));
      }
    }

    Collections.sort(sorted);
    return sorted.get(1);
  }
}