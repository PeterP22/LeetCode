import java.util.HashMap;

public class RomanToInteger
{
    // create a hashmap to store the roman numerals and their values
    HashMap<String, Integer> map = new HashMap<String, Integer>(); // key = roman numeral, value = value of roman numeral

    // initialize the hashmap in the constructor
    public RomanToInteger()
    {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }


    public int romanToInt(String s)
    {
        // we take in a String and want to return an int

        // create a variable to store the total value
        int total = 0;

        for (int i = 0; i < s.length(); i++)
        {
            // get the value of the current character from the map
            int currentValue = map.get(String.valueOf(s.charAt(i)));

            // if we're not at the last character and the current value is less than the next value
            if (i < s.length() - 1 && currentValue < map.get(String.valueOf(s.charAt(i + 1))))
            {
                total -= currentValue;
            }
            else
            {
                total += currentValue;
            }
        }

        return total;
    }

    // test the solution with different inputs
    public static void main(String[] args)
    {
        RomanToInteger solution = new RomanToInteger();
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("IX"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}





