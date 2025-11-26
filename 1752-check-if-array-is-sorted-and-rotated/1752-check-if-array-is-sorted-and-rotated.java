class Solution {
    public boolean check(int[] nums) {
        int count=0;//keeps a track of the no. of times the order of elements in the array is disrupted
        if (nums[0] < nums[nums.length - 1]) { //if 1st no. < last no. ie array is not rotated eg:  1 2 3 4 5 
            count++;
        }
        for(int i=0;i<nums.length-1;i++){ //iterates in the loop
            if(nums[i+1]<nums[i]){ //checks if the array is not sorted in ascending/increasing order : next no. < current
                count++; // non sorted array
            }
            if(count>1){ // either the array is not rotated or non sorted
                return false;
            }
        }
        return true;
    }
   
}