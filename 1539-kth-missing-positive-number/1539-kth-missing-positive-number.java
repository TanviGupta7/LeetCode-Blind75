class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missingCount = 0;
        int j = 0;

        for (int i = 1; ; i++) {
            if (j < arr.length && arr[j] == i) {
                j++; // number exists
            } else {
                missingCount++; // number is missing
                if (missingCount == k)
                    return i;
            }
        }
    }
}
