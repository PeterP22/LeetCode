package solutions;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Step 1: Ensure nums1 is the shorter array.
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;

        // Step 2: Start binary search on the shorter array, nums1.
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;

            // Step 5: Iterative Step (adjusting the partition)
            if (i < m && nums2[j-1] > nums1[i]) {
                // Increase i (move partition to the right in nums1)
                imin = i + 1;
            } else if (i > 0 && nums1[i-1] > nums2[j]) {
                // Decrease i (move partition to the left in nums1)
                imax = i - 1;
            } else {
                // Found the correct partition.

                // Step 4: Handle edge cases.
                int maxOfLeft;
                if (i == 0) {
                    maxOfLeft = nums2[j-1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i-1];
                } else {
                    maxOfLeft = Math.max(nums1[i-1], nums2[j-1]);
                }

                // Odd total number of elements.
                if ((m + n) % 2 == 1) {
                    return maxOfLeft;
                }

                int minOfRight;
                if (i == m) {
                    minOfRight = nums2[j];
                } else if (j == n) {
                    minOfRight = nums1[i];
                } else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }

                // Even total number of elements.
                return (maxOfLeft + minOfRight) / 2.0;
            }
        }

        return 0.0; // This line should not be reached.
    }

    // test code
    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}

