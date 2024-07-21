/**
 * @author ZhangXing
 * @title 最后一个单词长度
 * @link https://leetcode.cn/problems/length-of-last-word
 * @Date 2024年7月21日15点33分
 * @tag 字符串
 */
public class LeetCode58 {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        int len = 0;

        while (s.charAt(end) == ' ' ) {
            end --;
        }
        while (s.charAt(end) != ' ') {
            len++;
        }

        return len;
    }
}
