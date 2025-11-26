import java.util.*;
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(n==0 || k==0) return;
        k=k%n;
        rev(nums,0,n-1);
        rev(nums,0,k-1);
        rev(nums,k,n-1);
        
    }
    void rev(int[] nums,int start, int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
/*int n=nums.length;
        if(n==0)
        return;  

        k=k%n; //min no of rotations needed

        int[] temp=new int[k];
        for(int i=n-k;i<n;i++){
            temp[i-n+k]=nums[i];
        }
        for(int i=n-k-1;i>=0;i--){
 // Shift the rest of the array elements to the right by k 
            nums[i+k]=nums[i];
        }
        for(int i=0;i<k;i++){
            nums[i]=temp[i];
        }*/
