package byteDance;

import org.junit.Test;

import java.util.HashSet;
import java.util.Stack;

public class I041 {

    @Test
    public void firstMissingPositive() {

        int[] nums = new int[] { 1 };
        System.out.println(firstMissingPositive(nums));

        nums = new int[] { 2 };
        System.out.println(firstMissingPositive(nums));

        nums = new int[] { 7,8,9,11,12 };
        System.out.println(firstMissingPositive(nums));

    }

    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 1;

        for (int num : nums) {
            set.add(num);
            if (num == result) {
                while (set.contains(result)) {
                    result += 1;
                }
            }
        }

        return result;

    }
}
