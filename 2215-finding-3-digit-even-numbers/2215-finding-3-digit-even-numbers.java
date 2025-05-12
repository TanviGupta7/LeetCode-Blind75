import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new TreeSet<>();

        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i != j && j != k && i != k) {
                        int hundreds = digits[i];
                        int tens = digits[j];
                        int units = digits[k];

                        if (hundreds == 0) continue; // No leading 0
                        if (units % 2 != 0) continue; // Must be even

                        int number = hundreds * 100 + tens * 10 + units;
                        result.add(number);
                    }
                }
            }
        }

        // Convert Set to int[]
        int[] finalResult = new int[result.size()];
        int index = 0;
        for (int num : result) {
            finalResult[index++] = num;
        }

        return finalResult;
    }
}
