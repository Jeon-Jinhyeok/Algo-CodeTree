import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int[][] starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt();
            starts[i][1] = sc.nextInt();
        }
        // Please write your code here.
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        Queue<Integer> q = new ArrayDeque<>();

        int count = 0;
        for(int[] p : starts){
            int y = p[0] - 1;
            int x = p[1] - 1;
            q.offer(y * n +x);
            grid[y][x] = 1;
            count++;
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            int y = cur / n;
            int x = cur % n;

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(0 <= ny && ny < n && 0 <= nx && nx < n && grid[ny][nx] == 0){
                    q.offer(ny * n + nx);
                    grid[ny][nx] = 1;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}