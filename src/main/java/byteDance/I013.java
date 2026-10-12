package byteDance;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class I013 {

    @Test
    public void test() {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    /***
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 存储基本+特殊情况
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        List<String> special = Arrays.asList("I","X","C");
        int res = 0;
        String temp;
        for (int i = 0; i < s.length(); i++) {
            // 先判断两位的是否满足
            temp = String.valueOf(s.charAt(i));
            if (special.contains(temp) && i + 1 < s.length() && map.containsKey(temp + s.charAt(i + 1))) {
                res +=map.get(temp + s.charAt(i + 1));
                i++;
            } else {
                res += map.get(temp);
            }
        }
        return res;
    }

}
