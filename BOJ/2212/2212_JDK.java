import java.util.*;
import java.io.*;

class Main {
  static int max;
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N, K, pos;
    int[] sensors;
    
    N = Integer.parseInt(br.readLine());
    K = Integer.parseInt(br.readLine());
    sensors = new int[N];
    
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      pos = Integer.parseInt(st.nextToken());
      sensors[i] = pos;
    }
    Arrays.sort(sensors);

    int left, right, gap, answer;
    List<Integer> gaps = new ArrayList<>();
    answer = sensors[sensors.length - 1] - sensors[0];
    left = sensors[0];
    for(int i = 1; i < sensors.length; i++) {
      right = sensors[i];
      gap = right - left;

      if(gap != 0)
        gaps.add(gap);

      left = right;
    }
    Collections.sort(gaps, Collections.reverseOrder());

    if(gaps.size() < K) {
      answer = 0;
    } else {
      for(int i = 1; i < K; i++) {
        answer -= gaps.get(i - 1);
      }
    }

    sb.append(answer);
    System.out.println(sb);
  }
}