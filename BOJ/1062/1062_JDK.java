import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N, K;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    char cur;
    String str;
    Set<Character> alphas;
    List<Set<Character>> words = new ArrayList<>();
    for(int i = 0; i < N; i++) {
      str = br.readLine();
      alphas = new HashSet<>();
      
      for(int j = 0; j < str.length(); j++) {
        cur = str.charAt(j);

        if("antci".indexOf(cur) == -1)
          alphas.add(cur);
      }

      words.add(alphas);
    }

    boolean[] selected;
    selected = new boolean[26];
    selected['a' - 'a'] = true;
    selected['c' - 'a'] = true;
    selected['i' - 'a'] = true;
    selected['n' - 'a'] = true;
    selected['t' - 'a'] = true;

    if(K >= 5)
      comb(words, selected, K, 5, 0);

    sb.append(max);
    System.out.println(sb);
  }

  static int max = 0;
  private static void comb(List<Set<Character>> words, boolean[] selected, int K, int count, int cur) {
    if(count == K) {
      int res = 0;
      boolean readable;
      
      for(Set<Character> set: words) {
        readable = true;
        for(char c: set) {
          if(!selected[c - 'a']) {
            readable = false;
            break;
          }
        }
        if(readable)
          res++;
      }
      if(max < res)
        max = res;

      return;
    }

    for(int i = cur; i < 26; i++) {
      if(!selected[i]) {
        selected[i] = true;
        comb(words, selected, K, count + 1, i);
        selected[i] = false;
      }
    }
  }
}