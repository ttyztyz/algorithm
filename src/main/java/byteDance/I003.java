package byteDance;

import org.junit.Test;

import java.util.HashMap;

public class I003 {


    @Test
    public void test01() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        // 从左到右，连续的字符串，不重复的子串最长长度
        // 固定左边，往右滑动，记录经历的每个字符及其位置
        // 遇到重复的字符，找出重复位置，重置开始计算长度的下标
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0; // 记录开始计算长度的下标，初始为0
        int prev;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // 遍历到s.charAt(i)了，遇到重复的字符
            if (map.containsKey(s.charAt(i))) {
                // 先取之前出现的位置
                prev = map.get(s.charAt(i));
                // 重新计算开始计算长度的下标
                // 如果重复字符出现在start之前，不用管，继续往后走就行了
                // 如果重复字符出现在start之后了，起始坐标需要重置了，那就从重复字符+1的位置继续计算
                start = start > prev ? start : prev + 1;
            }
            // 记录下当前字符位置
            map.put(s.charAt(i), i);
            // 计算最长
            res = Math.max(res, i - start + 1);
        }
        return res;

    }
}
