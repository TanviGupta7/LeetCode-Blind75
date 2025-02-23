class Solution {
    public static int[] twoSum(int[] nums, int target) {

        //OPTIMAL APPROACH- ONE PASS HASHMAP:

        Map<Integer,Integer> map =new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];

            if(map.containsKey(diff))
                return new int[]{map.get(diff),i};
    
            map.put(nums[i],i);
        }
            return null;
    }
}
            
           
    /* NAIVE APPROACH    
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) { // j starts from i+1 to avoid duplicate checks
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j}; // Correct way to return an array
            }
        }
    }
    return new int[]{}; // Return an empty array if no solution is found
} O(n^2), O(1)
} */ 

/*MODIFYING NAIVE such that it is cache friendly-
 public int[] twoSum(int[] nums, int target) {
          int a[] = new int [2];
        for(int i = 1; i < nums.length; i++){
            for(int j = i; j < nums.length; j++) {
                if(nums[j-i]+nums[j]== target){
                    a[0] = j-i;
                    a[1] =j;
                    return a;
                }
            }
        }

        return a;
    }
     runs fewer times than a typical O(n²) approach. 
Why Does It Run in 0 ms?
Small Input Size:
If nums.length is small (e.g., ≤1000), modern CPUs can handle brute-force approaches quickly due to branch prediction and CPU caching.
Early Exit Optimization:
Your approach returns as soon as it finds a solution, which means it doesn’t always execute the full O(n²) complexity.
Efficient Memory Access:
The pattern nums[j - i] + nums[j] may improve cache locality, reducing memory latency.

    */


        /*
        int le = nums.length;
        int[] result = new int[2]; // Array to store the indices of the two numbers
        
        for (int i = 0; i < le; i++) {
            int a = nums[i];
            for (int j = i + 1; j < le; j++) {
                int b = nums[j];
                int sum = a + b;
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    return result; // Return the indices if a pair is found
                }
            }
        }
        return new int[]{-1, -1}; // Return {-1, -1} if no pair is found
    }

    public static void main(String args[]) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int[] indices = twoSum(nums, target); // Get the indices from the twoSum method
        if (indices[0] != -1 && indices[1] != -1) {
            System.out.println("Indices: " + indices[0] + ", " + indices[1]);
        } else {
            System.out.println("No solution.");
        }
        */
    
