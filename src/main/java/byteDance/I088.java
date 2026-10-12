package byteDance;

import org.junit.Test;

public class I088 {


    @Test
    public void test() {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0, j = 0, cur = 0;
        int[] nums3 = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums3[cur++] = nums1[i++];
            } else {
                nums3[cur++] = nums2[j++];
            }
        }
        while (i < m) {
            nums3[cur++] = nums1[i++];
        }
        while (j < n) {
            nums3[cur++] = nums2[j++];
        }
        System.arraycopy(nums3, 0, nums1, 0, m + n);
    }

}
