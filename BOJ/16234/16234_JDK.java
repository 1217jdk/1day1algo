import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = 0, L = 0, R = 0;
        int[][] population;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        population = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                population[i][j] = Integer.parseInt(st.nextToken());
        }

        int nx = 0, ny = 0, gap = 0, front = 0, curNum = 0, count = 0, total = 0, day = -1;
        boolean end = false;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        List<Integer> unites;
        int[][] uniteNum;
        boolean[][] visited;
        Queue<Integer> que;

        while(!end) {
            day++;

            curNum = 0;
            end = true;
            unites = new ArrayList<>();
            uniteNum = new int[N][N];
            visited = new boolean[N][N];
            que = new ArrayDeque<>();

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        uniteNum[i][j] = curNum;
                        count = 1;
                        total = population[i][j];
                        que.offer(i * N + j);

                        while(!que.isEmpty()) {
                            front = que.poll();

                            for(int d = 0; d < dx.length; d++) {
                                nx = front % N + dx[d];
                                ny = front / N + dy[d];

                                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx]) {
                                    gap = Math.abs(population[front / N][front % N] - population[ny][nx]);

                                    if(gap >= L && gap <= R) {
                                        visited[ny][nx] = true;
                                        uniteNum[ny][nx] = curNum;
                                        count++;
                                        total += population[ny][nx];
                                        que.offer(ny * N + nx);

                                        end = false;
                                    }
                                }
                            }
                        }
                        unites.add(total / count);
                        curNum++;
                    }
                }
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++)
                    population[i][j] = unites.get(uniteNum[i][j]);
            }
        }
        sb.append(day);
        System.out.println(sb);
    }
}
