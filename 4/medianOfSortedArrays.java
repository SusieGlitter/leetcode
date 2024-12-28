class Solution {
    public int kthNumber(int[] nums1, int[] nums2, int k) {
        int i = 0, j = 0;
        while (k != 0) {
            if (i == nums1.length)
                return nums2[j+k];
            if (j == nums2.length)
                return nums1[i+k];
            int ii = Math.min(nums1.length - 1, i + (k - 1) / 2);
            int jj = Math.min(nums2.length - 1, j + (k - 1) / 2);
            if (nums1[ii] >= nums2[jj]) {
                k -= jj + 1 - j;
                j = jj + 1;
            } else {
                k -= ii + 1 - i;
                i = ii + 1;
            }
        }
        if (i == nums1.length)
            return nums2[j];
        if (j == nums2.length)
            return nums1[i];
        return Math.min(nums1[i], nums2[j]);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        return (kthNumber(nums1, nums2, length / 2) + kthNumber(nums1, nums2, (length - 1) / 2)) / 2.0;
    }
}

public class medianOfSortedArrays {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = { 3 };
        int[] nums2 = { 1,2,4,5,6,7,8 };
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }
}