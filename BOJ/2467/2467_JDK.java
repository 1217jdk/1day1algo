import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N;
    int[] values;

    N = Integer.parseInt(br.readLine());
    values = new int[N];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++)
      values[i] = Integer.parseInt(st.nextToken());

    int sol1, sol2, sum, res, ans1, ans2;
    int left, right, mid;
    res = Integer.MAX_VALUE;
    ans1 = values[0];
    ans2 = values[1];
    for(int i = 0; i < N - 1; i++) {
      sol1 = values[i];

      left = i + 1;
      right = values.length - 1;
      while(left <= right) {
        mid = (right + left) / 2;
        sol2 = values[mid];
        sum = sol1 + sol2;

        if(Math.abs(sum) < Math.abs(res)) {
          res = sum;
          ans1 = sol1;
          ans2 = sol2;
        }

        if(sum < 0)
          left = mid + 1;
        else
          right = mid - 1;
      }
    }

    sb.append(ans1).append(" ").append(ans2);
    System.out.println(sb);
  }
}