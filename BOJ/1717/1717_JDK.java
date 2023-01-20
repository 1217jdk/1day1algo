import java.util.*;
import java.io.*;

class Main {
  static int max;
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n, m;
    int[] parents;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    parents = new int[n + 1];
    for(int i = 0; i <= n; i++)
      parents[i] = i;

    int op, num1, num2;
    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      op = Integer.parseInt(st.nextToken());
      num1 = Integer.parseInt(st.nextToken());
      num2 = Integer.parseInt(st.nextToken());

      switch(op) {
        case 0:
          union(parents, num1, num2);
          break;
        case 1:
          if(getParent(parents, num1) == getParent(parents, num2))
            sb.append("YES");
          else
            sb.append("NO");
          sb.append("\n");
          break;
      }
    }
    
    System.out.println(sb);
  }

  private static void union(int[] parents, int num1, int num2) {
    int parent, before, next;
    
    parent = getParent(parents, num1);
    before = num2;
    while(parents[before] != before) {
      next = parents[before];
      parents[before] = parent;
      before = next;
    }
    parents[before] = parent;
  }
  
  private static int getParent(int[] parents, int num) {
    while(parents[num] != num)
      num = parents[num];
    
    return num;
  }
}