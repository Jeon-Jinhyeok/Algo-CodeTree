import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
public class Main {

    public static class Cell implements Comparable<Cell>{
        int y, x, n;

        public Cell(int y, int x, int n){
            this.y = y;
            this.x = x;
            this.n = n;
        }

        @Override
        public int compareTo(Cell o){
            if(this.n != o.n){
                return Integer.compare(this.n, o.n);
            }

            if(this.y != o.y){
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.x, o.x);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] grid = new int[n][n];

        Cell[] cells = new Cell[n*n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                cells[i*n+j] = new Cell(i, j, grid[i][j]);
            }
        }
        
        Arrays.sort(cells);

        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], 1);
        }

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        
        int maxValue = -1;
        for(int i = 0; i < cells.length; i++){
            Cell c = cells[i];
            int y = c.y;
            int x = c.x;

            for(int d = 0; d < 4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];

                if(0 <= ny && ny < n && 0 <= nx && nx < n && grid[y][x] < grid[ny][nx]){
                    dp[ny][nx] = Math.max(dp[ny][nx], dp[y][x] + 1);
                    maxValue = Math.max(dp[ny][nx], maxValue);
                }
            }
        }
        System.out.println(maxValue);
    }
}