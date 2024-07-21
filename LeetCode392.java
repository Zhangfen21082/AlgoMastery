/**
 * @author ZhangXing
 * @title 判断子序列
 * @link https://leetcode.cn/problems/is-subsequence/
 * @Date 2024年7月21日15点58分
 * @tag 字符串
 */

public class LeetCode392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0; // 指向 s
        int j = 0; // 指向 t

        // 遍历 s 和 t
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // 移动 s 的指针
            }
            j++; // 始终移动 t 的指针
        }

        // 如果 i 达到 s 的长度，说明 s 中的所有字符都被匹配了
        return i == s.length();
    }

    public static void main(String[] args) {
        LeetCode392 solution = new LeetCode392();
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(solution.isSubsequence(s, t)); // 输出: true

        s = "axc";
        t = "ahbgdc";
        System.out.println(solution.isSubsequence(s, t)); // 输出: false
    }
}

