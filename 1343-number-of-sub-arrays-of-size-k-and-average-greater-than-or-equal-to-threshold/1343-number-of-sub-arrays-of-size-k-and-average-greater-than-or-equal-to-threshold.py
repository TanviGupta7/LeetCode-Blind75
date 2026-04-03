class Solution:
    def numOfSubarrays(self, arr, k, threshold):
        
        target = k * threshold  # avoid division
        
        # first window sum
        window_sum = sum(arr[:k])
        count = 0

        # check first window
        if window_sum >= target:
            count += 1

        # slide window
        for i in range(k, len(arr)):
            window_sum += arr[i]
            window_sum -= arr[i - k]

            if window_sum >= target:
                count += 1

        return count