class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            //to eliminate half the array, we 1st identify which portion of array is sorted

            if(nums[low]<=nums[mid]){  //if left is sorted
                if(nums[low]<=target && target<=nums[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
            else{ // right half is sorted
                if(nums[mid]<=target && target<=nums[high])
                    low=mid+1;
                else
                    high=mid-1;
                }
            }
        
        return -1;
    }
}