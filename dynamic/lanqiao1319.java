package dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZhangXing
 * @title 蓝桥舞会
 * @link https://www.lanqiao.cn/problems/1319/learning/?page=1&first_category_id=1
 * @Date 2024年6月17日16:21:13
 * @tag 动态规划 树形DP
 */
public class lanqiao1319 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] happiness = new int[n+1];
        for(int i = 1; i <= n; i++) {
            happiness[i] = sc.nextInt();
        }

        List<Integer>[] tree = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        int[][] dp = new int[n+1][2];
        for(int i = 1; i <= n; i++) {
            dp[i][1] = happiness[i];
        }

        dfs(1, -1, tree, dp, happiness);
        System.out.println(Math.max(dp[1][0], dp[1][1]));

    }

    private static void dfs(int u, int parent, List<Integer>[] tree, int[][] dp, int[] happiness) {
        dp[u][0] = 0;  // 不选当前节点
        dp[u][1] = happiness[u];  // 选当前节点

        for (int v : tree[u]) {
            if (v != parent) {  // 避免回到父节点
                dfs(v, u, tree, dp, happiness);
                dp[u][0] += Math.max(dp[v][0], dp[v][1]);  // 不选当前节点，子节点可以选也可以不选
                dp[u][1] += dp[v][0];  // 选当前节点，子节点不能选
            }
        }
    }
}
