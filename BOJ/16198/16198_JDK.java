import java.util.*;
import java.io.*;

class Main {
  static int max;
  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N;
    int[] weights;
    boolean[] selected;

    N = Integer.parseInt(br.readLine());
    weights = new int[N];
    selected = new boolean[N];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++)
      weights[i] = Integer.parseInt(st.nextToken());

    max = 0;
    perm(weights, selected, 0, 0);

    sb.append(max);
    System.out.println(sb);
  }

  private static void perm(int[] weights, boolean[] selected, int sum, int count) {
    if(count == weights.length - 2) {
      if(max < sum)
        max = sum;
      return;
    }
    
    int res = 0;
    
    for(int i = 1; i < weights.length - 1; i++) {
      if(selected[i])
        continue;

      selected[i] = true;
      res = getEnergy(weights, selected, i);
      
      perm(weights, selected, sum + res, count + 1);

      selected[i] = false;
    }
  }

  private static int getEnergy(int[] weights, boolean[] selected, int index) {
    int left = index - 1;
    int right = index + 1;

    while(selected[left])
      left--;
    while(selected[right])
      right++;

    return weights[left] * weights[right];
  }
}