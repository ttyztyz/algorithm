package byteDance;

import org.junit.Test;

import java.util.Arrays;

public class I283 {

    @Test
    public void test() {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 解题思路
     * 题目要求不复制数组，在数组原地操作
     * 就相当于我们推着0往后走，遇到0就去与数组后面不为零的第一个数进行交换
     * 记录数组后面不为零的第一个数的下标就行
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1 || nums.length == 0) {
            return;
        }
        int nonZeroIndex = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 0 && nonZeroIndex < nums.length) {
                if (nums[nonZeroIndex] == 0) {
                    nonZeroIndex++;
                    continue;
                }
                // 交换数字
                temp = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = temp;
                break;
            }
            nonZeroIndex++;
        }
    }

}
