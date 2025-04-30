class Solution {
    public int findNumbers(int[] nums) {
        
 int ans=0;
        for(int i=0;i<nums.length;i++){
        ans+=evenDigits(nums[i]);
        }
        return ans;
    }
    public int evenDigits(int num){
        int even=0,c=0;
        while(num!=0){
            ++c;
            num=num/10;
        }
        if(c%2==0)
        ++even;
        return even;
    }
}
       