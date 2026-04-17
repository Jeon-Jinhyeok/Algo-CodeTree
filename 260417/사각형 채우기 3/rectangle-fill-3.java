import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int MOD = 1000000007;

        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[1] = 2;

        if(n >= 2)
            dp[2] = 7;

        for(int i = 3; i <= n; i++){
            dp[i] = (3 * dp[i-1] + dp[i-2] - dp[i-3] + MOD) % MOD;
        }

        System.out.println(dp[n] % MOD);
        sc.close();
    }
}