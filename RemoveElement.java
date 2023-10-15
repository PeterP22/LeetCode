import java.util.Arrays;

public class RemoveElement
{
    /*
    Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
    Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
    Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
    Return k.
     */
    public int remove(int[] nums, int val)
    {
        int j = 0; // pointer to keep track of the index of the next element that is not equal to val

        // iterate through the array
        for (int i = 0; i < nums.length; i++)
        {
            // if the current element is not equal to val, set the element at index j to the current element and increment j
            if (nums[i] != val)
            {
                nums[j] = nums[i];
                j++;
            }
        }

        // return j which is the number of elements in nums which are not equal to val
        return j;
    }

    public static void main(String[] args)
    {
        RemoveElement solution = new RemoveElement();
        int[] nums = {3, 2, 2, 3, 7, 3, 4, 4, 3, 3, 3, 3, 7};
        int val = 3;

        System.out.println("Original array: " + Arrays.toString(nums));
        System.out.println("Length of original array: " + nums.length);

        int newLength = solution.remove(nums, val);

        int[] modifiedArray = Arrays.copyOf(nums, newLength);

        System.out.println("Array after removing " + val + ": " + Arrays.toString(modifiedArray));
        System.out.println("New length of the array: " + newLength);
    }
}
