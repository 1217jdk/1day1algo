import java.util.*;
import java.io.*;

class Main {
  static class Num implements Comparable<Num>{
    int num;
    int abs;

    public Num(int num) {
      this.num = num;
      this.abs = Math.abs(num);
    }

    @Override
    public int compareTo(Num o) {
      if(this.abs == o.abs)
        return this.num - o.num;
      else
        return this.abs - o.abs;
    }
  }
  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N, op;
    PriorityQueue<Num> heap = new PriorityQueue<>();

    N = Integer.parseInt(br.readLine());
    for(int i = 0; i < N; i++) {
      op = Integer.parseInt(br.readLine());

      if(op == 0) {
        if(heap.isEmpty())
          sb.append(0).append("\n");
        else
          sb.append(heap.poll().num).append("\n");
      } else {
        heap.offer(new Num(op));
      }
    }
    
    System.out.println(sb);
  }
}