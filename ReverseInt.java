public class ReverseInt
{
    public static int reverseBasic(int x) {
        boolean isNegative = false;
        if(x < 0) {
            isNegative = true;
            x = -x;
        }

        String xString = Integer.toString(x);

        StringBuilder reversedString = new StringBuilder();
        for(int i = xString.length() - 1; i >= 0; i--) {
            reversedString.append(xString.charAt(i));
        }

        int reversedInt = 0;
        try {
            reversedInt = Integer.parseInt(reversedString.toString());
        } catch(NumberFormatException e) {
            return 0;
        }

        if(isNegative) {
            reversedInt = -reversedInt;
        }

        return reversedInt;
    }


    public static int reverseEnhanced(int x)
    {
        long reversed = 0; // use a long to store the reversed integer to avoid overflow

        // while loop to reverse the integer
        while(x != 0)
        {
            reversed = reversed * 10 + x % 10; // multiply reversed by 10 to shift the digits to the left and add the last digit of x to the end of reversed
            x /= 10; // divide x by 10 to remove the last digit


            // check for overflow and return 0 if overflow occurs
            if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE)
            {
                return 0;
            }
        }

        // return the reversed integer
        return (int) reversed;
    }

    public static void main(String[] args)
    {
        System.out.println(reverseBasic(123));
        System.out.println(reverseBasic(-123));
        System.out.println(reverseBasic(120));
        System.out.println(reverseBasic(0));
        System.out.println(reverseBasic(1534236469));

        // test the enhanced solution with different inputs
        System.out.println(reverseEnhanced(123));
        System.out.println(reverseEnhanced(-123));
        System.out.println(reverseEnhanced(120));
        System.out.println(reverseEnhanced(0));
        System.out.println(reverseEnhanced(1534236469));
    }
}
