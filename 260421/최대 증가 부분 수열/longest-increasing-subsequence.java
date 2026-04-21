import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n+1];
        for(int i = 1; i <= n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = 1;
            for(int j = 1; j < i; j++){
                if(nums[i] > nums[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int maxValue = -1;
        for(int each : dp){
            maxValue = Math.max(maxValue, each);
        }

        System.out.println(maxValue);

        br.close();
    }
}