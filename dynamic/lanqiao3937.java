package dynamic;

import java.util.Scanner;

/**
 * @author ZhangXing
 * @title 小明的背包4
 * @link https://www.lanqiao.cn/problems/1178/learning/?page=1&first_category_id=1
 * @Date 2024年6月9日14:55:52
 * @tag 动态规划 背包问题
 */

public class lanqiao3937 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // 物品数量
        int V = scan.nextInt(); // 背包体积
        int M = scan.nextInt(); // 背包重量
        int[] arr_V = new int[N]; // 体积数组
        int[] arr_M = new int[N]; // 重量数组
        int[] arr_W = new int[N]; // 价值数组
        for(int i=0; i<N; i++) {
            arr_V[i] = scan.nextInt();
            arr_M[i] = scan.nextInt();
            arr_W[i] = scan.nextInt();
        }

        // dp[i][j]表示体积为i，重量为j时的价值
        // dp[0][...]=dp[...][0]为初始情况，如果没有物品或背包容量为0时价值为0
        int[][] dp = new int[V+1][M+1];

        for(int i = 1; i <= N; i++) {
            // 倒着走
            for(int j = V; j >= arr_V[i-1]; j--) {
                for(int k = M; k >= arr_M[i-1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-arr_V[i-1]][k-arr_M[i-1]] + arr_W[i-1]);
                }
            }
        }
        System.out.println(dp[V][M]);
        scan.close();
    }
    }

