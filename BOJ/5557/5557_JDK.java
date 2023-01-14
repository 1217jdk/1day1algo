import java.util.*;
import java.io.*;

class Main {
  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = 0;
    long answer = 0;
    int[] inputs;
    List<Map<Integer, Long>> count = new ArrayList<>();

    N = Integer.parseInt(br.readLine());
    inputs = new int[N];
    for(int i = 0; i < N; i++)
      count.add(new HashMap<>());
    
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      inputs[i] = Integer.parseInt(st.nextToken());
    }

    int index = 0, res = 0;
    index = inputs.length - 1;
    res = inputs[index];

    count.get(0).put(inputs[0], 1L);
    answer = dp(count, inputs, index - 1, res);

    sb.append(answer);
    System.out.println(sb);
  }

  private static long dp(List<Map<Integer, Long>> count, int[] inputs, int index, int res) {
    if(count.get(index).containsKey(res))
      return count.get(index).get(res);

    if(index == 0)
      return 0;

    int next = 0;
    long sum = 0;
    for(int i = -1; i < 2; i += 2) {
      next = res + i * inputs[index];
      if(next >= 0 && next <= 20)
        sum += dp(count, inputs, index - 1, res + i * inputs[index]);
    }
    
    count.get(index).put(res, sum);
    return sum;
  }
}