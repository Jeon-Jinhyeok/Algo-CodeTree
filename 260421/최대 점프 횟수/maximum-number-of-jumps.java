import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[1] = 0;

        for(int i = 2; i < n+1; i++){
            for(int j = 1; j < i; j++){
                if(arr[j] + j >= i && dp[j] != Integer.MIN_VALUE){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxValue = -1;
        for(int each : dp){
            maxValue = Math.max(maxValue, each);
        }

        System.out.println(maxValue);
    }
}