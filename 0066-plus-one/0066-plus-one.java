class Solution {
    public int[] plusOne(int[] digits) {

        int n = digits.length;

        // start from last digit
        for (int i = n - 1; i >= 0; i--) {

            // if digit is less than 9, just add 1
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // if digit is 9, make it 0 and continue carry
            digits[i] = 0;
        }

        // if all digits were 9
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
