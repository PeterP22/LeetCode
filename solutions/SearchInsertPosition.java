package solutions;

public class SearchInsertPosition
{
    // Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. You must write an algorithm with O(log n) runtime complexity.
    public int searchLinearInsert(int[] nums, int target)
    {
        // loop through the array
        for (int i = 0; i < nums.length; i++)
        {
            // if the current element is greater than or equal to the target, return the index of the current element
            if (nums[i] >= target)
            {
                return i;
            }
        }
        // if the target is greater than all the elements in the array, return the length of the array
        return nums.length;
    }

    public int searchBinaryInsert(int[] nums, int target)
    {
        // use binary search on the already sorted array init
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left; // if the target is not found, return the index where it would be if it were inserted in order
    }

    public static void main(String[] args)
    {
        // this will be in linear time which is O(n) but we want to do it in O(log n) time
        SearchInsertPosition solution = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        // print the full array out
        System.out.print("The array is: [");
        for (int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i]);
            if (i < nums.length - 1)
            {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("The index of " + target + " is " + solution.searchLinearInsert(nums, target) + " using linear search.");

        // since the array is already sorted we can use binary search to find the index of the target which satisfies the time complexity
        // test the binary search solution with different inputs
        System.out.println("The index of " + target + " is " + solution.searchBinaryInsert(nums, target)+ " using binary search.");

        // make another array and test the solution with that
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target2 = 10;
        System.out.print("The array is: [");
        for (int i = 0; i < nums2.length; i++)
        {
            System.out.print(nums2[i]);
            if (i < nums2.length - 1)
            {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("The index of " + target2 + " is " + solution.searchLinearInsert(nums2, target2) + " using linear search.");
        System.out.println("The index of " + target2 + " is " + solution.searchBinaryInsert(nums2, target2)+ " using binary search.");
    }
}
