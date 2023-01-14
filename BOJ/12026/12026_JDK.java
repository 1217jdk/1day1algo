import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = 0;
    String road;
    int[] dp;
    Map<Character, Character> befores = new HashMap<>();
    befores.put('B', 'J');
    befores.put('O', 'B');
    befores.put('J', 'O');
    Map<Character, List<Integer>> map = new HashMap<>();
    map.put('B', new ArrayList<>());
    map.put('O', new ArrayList<>());
    map.put('J', new ArrayList<>());

    N = Integer.parseInt(br.readLine());
    dp = new int[N];
    
    road = br.readLine();
    for(int i = 0; i < road.length(); i++) {
      map.get(road.charAt(i)).add(i);
    }

    int index = 0, cost = 0, min = 0;
    char cur, before;
    for(int i = 1; i < dp.length; i++) {
      cur = road.charAt(i);
      before = befores.get(cur);

      min = Integer.MAX_VALUE;
      for(int j = 0; j < map.get(before).size(); j++) {
        index = map.get(before).get(j);
        
        if(index >= i)
          break;

        if(dp[index] == -1)
          continue;

        cost = dp[index] + (i - index) * (i - index);
        if(min > cost)
          min = cost;
      }
      if(min == Integer.MAX_VALUE)
        min = -1;

      dp[i] = min;
    }

    sb.append(dp[N - 1]);
    System.out.println(sb);
  }
}