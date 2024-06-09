package dynamic;


import java.util.Scanner;

/**
 * @author ZhangXing
 * @title 小明的背包5
 * @link https://www.lanqiao.cn/problems/1178/learning/?page=1&first_category_id=1
 * @Date 2024年6月9日15:00:39
 * @tag 动态规划 背包问题
 */
public class lanqiao1178 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // N组物品
        int V = scan.nextInt(); // 背包容量

        int[] s = new int[N]; // 每组物品里面的数量
        int[][] v = new int[101][101]; // 每件物品体积
        int[][] w= new int[101][101]; // 每件物品价值

        for(int i = 0; i < N; i++) {
            s[i] = scan.nextInt();
            for(int j = 0; j < s[i]; j++) {
                w[i][j] = scan.nextInt();
                v[i][j] = scan.nextInt();
            }
        }

        int[][] dp = new int [N+1][V+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= V; j++) {
                dp[i][j] = dp[i-1][j];
                for(int k = 0; k < s[i-1]; k++) {
                    if (j >= w[i-1][k]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i-1][k]] + v[i-1][k]);
                    }
                }
            }
        }

        System.out.println(dp[N][V]);
        scan.close();
    }

}
