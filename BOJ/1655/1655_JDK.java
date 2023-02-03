import java.util.*;
import java.io.*;

class Main {  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N;
    PriorityQueue<Integer> left, right;

    N = Integer.parseInt(br.readLine());
    left = new PriorityQueue<>(Collections.reverseOrder());
    right = new PriorityQueue<>();

    int num, gap;
    for(int i = 0; i < N; i++) {
      num = Integer.parseInt(br.readLine());

      left.offer(num);

      if(right.size() != 0 && left.peek() > right.peek())
        left.offer(right.poll());

      while(left.size() - 1 > right.size())
        right.offer(left.poll());

      sb.append(left.peek()).append("\n");
    }

    System.out.println(sb);
  }
}