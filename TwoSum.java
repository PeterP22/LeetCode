import java.util.HashMap;

public class TwoSum
{
    // given an array of integers called numbers an integer called target, return the indices of the two numbers that add up to target
    // assume that each input would have exactly one solution, and you may not use the same element twice
    // you can return the answer in any order

    public static int[] twoSumBasic(int[] numbers, int target)
    {
        int[] result = new int[2];
        for(int i = 0; i < numbers.length; i++)
        {
            for(int j = i + 1; j < numbers.length; j++)
            {
                if(numbers[i] + numbers[j] == target)
                {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static int[] twoSumOptimized(int[] numbers, int target)
    {
        // create a hashmap to store the numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // key = number, value = index

        // iterate through the array
        for (int i = 0; i < numbers.length; i++)
        {
            int complement = target - numbers[i]; // calculate the complement of the current number which is the number that would add up to the target
            // if the hashmap contains the complement of the current number, return the indices of the current number and its complement
            if (map.containsKey(complement))
            {
                return new int[] {map.get(complement), i};
            }
            // otherwise, add the current number and its index to the hashmap
            else
            {
                map.put(numbers[i], i);
            }
        }
        // if no solution is found, return an empty array and print an error message
        throw new IllegalArgumentException("No solution found.");
    }

    public static void main(String[] args)
    {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSumBasic(numbers, target);
        System.out.println(result[0] + " " + result[1]);

        // test the optimized solution with different inputs
        int[] numbers2 = {3, 3, 4};
        int target2 = 6;
        int[] result2 = twoSumOptimized(numbers2, target2);
        System.out.println(result2[0] + " " + result2[1]);
    }
}
