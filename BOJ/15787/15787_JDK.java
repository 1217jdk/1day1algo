import java.util.*;
import java.io.*;

class Main {  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N, M;
    List<boolean[]> trains = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    for(int i = 0; i < N; i++) {
      trains.add(new boolean[20]);
    }

    int op, train, seat;
    boolean[] curTrain;
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      op = Integer.parseInt(st.nextToken());
      train = Integer.parseInt(st.nextToken()) - 1;
      
      switch(op) {
        case 1:
          seat = Integer.parseInt(st.nextToken()) - 1;
          trains.get(train)[seat] = true;
          break;
        case 2:
          seat = Integer.parseInt(st.nextToken()) - 1;
          trains.get(train)[seat] = false;
          break;
        case 3:
          curTrain = trains.get(train);
          for(int j = curTrain.length - 2; j >= 0; j--)
            curTrain[j + 1] = curTrain[j];
          curTrain[0] = false;
          break;
        case 4:
          curTrain = trains.get(train);
          for(int j = 1; j < curTrain.length; j++)
            curTrain[j - 1] = curTrain[j];
          curTrain[curTrain.length - 1] = false;
          break;
      }
    }

    int res;
    Set<Integer> cross = new HashSet<>();
    for(int i = 0; i < trains.size(); i++) {
      res = toInt(trains.get(i));
      cross.add(res);
    }

    sb.append(cross.size());
    System.out.println(sb);
  }

  private static int toInt(boolean[] arr) {
    int res = 0;
    for(int i = 0; i < arr.length; i++) {
      if(arr[i])
        res += Math.pow(2, i);
    }

    return res;
  }
}