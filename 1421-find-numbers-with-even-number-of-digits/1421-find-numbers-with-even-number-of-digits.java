class Solution {
    public int findNumbers(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length;i++){
            String s=Integer.toString(nums[i]);
            int l=s.length();
            if(l%2==0)
            c++;
        }
        return c;

    }
}
       