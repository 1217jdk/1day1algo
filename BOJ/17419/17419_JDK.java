import java.util.*;
import java.io.*;

class Main {
  static int max;
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N;
    String K;

    N = Integer.parseInt(br.readLine());
    K = br.readLine();

    int answer = 0;
    for(int i = 0; i < K.length(); i++) {
      if(K.charAt(i) == '1')
        answer++;
    }

    sb.append(answer);
    System.out.println(sb);
  }
}