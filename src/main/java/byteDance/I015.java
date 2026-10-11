package byteDance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class I015 {

    @Test
    public void test01() {
        System.out.println(threeSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{0,0,0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //三数之和
        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        // 都没负数或者0，肯定没结果
        if (nums[0] > 0) {
            return result;
        }
        int rest;
        int left;
        int right;
        int sum;
        // 转换问题为两数之和的问题
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                //当前值 = 前值，相当于两数之和的结果没变，因此最终结果也是重复，所以直接跳过
                continue;
            }
            // 转为两数之和
            rest = -nums[i];
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
               sum = nums[left] + nums[right];
               if (sum == rest) {
                   result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                   // 题目要求不能重复结果，所以有一个结果之后，需要主动自检左+1和右-1
                   while (left < right && nums[left] == nums[left + 1]) {
                       left++;
                   }
                   while (left < right && nums[right] == nums[right - 1]) {
                       right--;
                   }
                   // 自检完了，都在最后一个重复答案的位置
                   left++;
                   right--;
               }  else if (sum > rest) {
                   // 太大了，右边往里走
                   right--;
               } else {
                   // 太小了，左边往里走
                   left++;
               }

            }
        }
        return result;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        //三数之和
        List<List<Integer>> result = new ArrayList<>();
        return  result;
    }

}
