import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N, M, num, index;
    boolean[][] over = new boolean[2][];
    List<Integer> knows = new ArrayList<>();
    List<List<List<Integer>>> adjs = new ArrayList<>();
    for(int i = 0; i < 2; i++)
      adjs.add(new ArrayList<>());

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    over[0] = new boolean[N];
    over[1] = new boolean[M];
    for(int i = 0; i < N; i++)
      adjs.get(0).add(new ArrayList<>());
    for(int i = 0; i < M; i++)
      adjs.get(1).add(new ArrayList<>());

    st = new StringTokenizer(br.readLine());
    num = Integer.parseInt(st.nextToken());
    for(int i = 0; i < num; i++) {
      index = Integer.parseInt(st.nextToken()) - 1;
      over[0][index] = true;
      knows.add(index);
    }

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      num = Integer.parseInt(st.nextToken());
      for(int j = 0; j < num; j++) {
        index = Integer.parseInt(st.nextToken()) - 1;
        adjs.get(0).get(index).add(i);
        adjs.get(1).get(i).add(index);        
      }
    }

    int start;
    for(int i = 0; i < knows.size(); i++) {
      start = knows.get(i);
      dfs(adjs, over, start, 0);
    }

    int count = 0;
    for(int i = 0; i < over[1].length; i++) {
      if(!over[1][i])
        count++;
    }

    sb.append(count);
    System.out.println(sb);
  }

  private static void dfs(List<List<List<Integer>>> adjs, boolean[][] over, int cur, int type) {
    int nextType = (type + 1) % 2, nextIndex;
    List<Integer> curAdjs = adjs.get(type).get(cur);
    
    for(int i = 0; i < curAdjs.size(); i++) {
      nextIndex = curAdjs.get(i);
      
      if(over[nextType][nextIndex])
        continue;

      over[nextType][nextIndex] = true;
      dfs(adjs, over, nextIndex, nextType);
    }
  }
}