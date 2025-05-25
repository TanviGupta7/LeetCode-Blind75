import java.util.*;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        int length = 0;
        boolean usedMiddle = false;

        // Count frequency of each word
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        for (String word : countMap.keySet()) {
            String rev = new StringBuilder(word).reverse().toString();

            if (word.equals(rev)) {
                // Palindromic word like "cc"
                int freq = countMap.get(word);
                length += (freq / 2) * 4;
                if (!usedMiddle && freq % 2 == 1) {
                    length += 2;
                    usedMiddle = true;
                }
            } else if (word.compareTo(rev) < 0 && countMap.containsKey(rev)) {
                // Ensure each asymmetric pair is only processed once
                int pairs = Math.min(countMap.get(word), countMap.get(rev));
                length += pairs * 4;
            }
        }

        return length;
    }
}

/*class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        int length = 0;
        boolean usedMiddle = false;

        // Count frequency of each word
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        for (String word : countMap.keySet()) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (word.equals(reversed)) {
                int freq = countMap.get(word);
                int pairs = freq / 2;
                length += pairs * 4;
                countMap.put(word, freq % 2); // update remaining count

                if (!usedMiddle && countMap.get(word) > 0) {
                    length += 2;
                    usedMiddle = true;
                }

            } else if (countMap.containsKey(reversed)) {
                int freq1 = countMap.get(word);
                int freq2 = countMap.get(reversed);
                int pairs = Math.min(freq1, freq2);
                length += pairs * 4;
                countMap.put(word, freq1 - pairs);
                countMap.put(reversed, freq2 - pairs);
            }
        }

        return length;
    }
}
*/