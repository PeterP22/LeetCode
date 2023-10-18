package solutions;

public class FindFirstOccurrenceInString
{
    /*
    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Example 1:

    Input: haystack = "sadbutsad", needle = "sad"
    Output: 0
    Explanation: "sad" occurs at index 0 and 6.
    The first occurrence is at index 0, so we return 0.
    Example 2:

    Input: haystack = "leetcode", needle = "leeto"
    Output: -1
    Explanation: "leeto" did not occur in "leetcode", so we return -1.
    Constraints:

    1 <= haystack.length, needle.length <= 104
    haystack and needle consist of only lowercase English characters.
    Related Topics
    Two Pointers
    String
    String Matching
     */

    public int findFirstStringOccurrence(String s, String needle)
    {
        // loop through the string
        for (int i = 0; i < s.length(); i++)
        {
            // if the current substring is equal to the needle
            if (s.startsWith(needle, i))
            {
                // return the index
                return i;
            }
        }

        // if we get here, we didn't find the needle
        return -1;
    }

    public static void main(String[] args)
    {
        FindFirstOccurrenceInString solution = new FindFirstOccurrenceInString();
        System.out.println(solution.findFirstStringOccurrence("sadbutsad", "sad"));
        System.out.println(solution.findFirstStringOccurrence("leetcode", "leeto"));
    }
}
