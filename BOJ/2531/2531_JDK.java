import java.util.*;
import java.io.*;

class Main {
  static int max;
  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N, d, k, c;
    int[] sushies, counts;
    Set<Integer> selects;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken()) - 1;

    sushies = new int[N];
    counts = new int[d];
    selects = new HashSet<>();

    for(int i = 0; i < N; i++)
      sushies[i] = Integer.parseInt(br.readLine()) - 1;

    for(int i = 0; i < k; i++) {
      counts[sushies[i]]++;
      if(counts[sushies[i]] == 1)
        selects.add(sushies[i]);
    }

    int start, end, max, remove, add, size;
    start = 1;
    end = k;
    max = selects.size();
    while(start > 0) {
      remove = sushies[start - 1];
      start = (start + 1) % N;
      add = sushies[end];
      end = (end + 1) % N;
      
      counts[remove]--;
      if(counts[remove] == 0)
        selects.remove(remove);
      counts[add]++;
      if(counts[add] == 1)
        selects.add(add);

      size = selects.size();
      if(max <= size) {
        if(!selects.contains(c))
          size++;
        max = size;
      }
    }
    
    sb.append(max);
    System.out.println(sb);
  }
}