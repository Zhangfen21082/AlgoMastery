/**
 * @author ZhangXing
 * @title 找出字符串中第一个匹配项的下标
 * @link https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string
 * @Date 2024年7月21日15点47分
 * @tag 字符串 KMP
 */
public class LeetCode28 {
    private static final int MAX_SIZE = 1000; // 可以根据需要调整

    public static void getNext(String targetStr, int[] next) {
        int j = 0, k = -1;
        next[0] = -1;

        while (j < targetStr.length()) {
            if (k == -1 || targetStr.charAt(j) == targetStr.charAt(k)) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }

    public static int KMP(String mainStr, String targetStr) {
        int[] next = new int[MAX_SIZE];
        int i = 0, j = 0;

        getNext(targetStr, next);

        while (i < mainStr.length() && j < targetStr.length()) {
            if (j == -1 || mainStr.charAt(i) == targetStr.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j >= targetStr.length()) {
            return i - targetStr.length(); // 返回目标串在主串中的第一个字符的位置
        } else {
            return -1; // 找不到返回 -1
        }
    }

    public static void main(String[] args) {
        String mainStr = "ababcababcabc";
        String targetStr = "abc";

        int position = KMP(mainStr, targetStr);
        System.out.println("Position: " + position);
    }
}
