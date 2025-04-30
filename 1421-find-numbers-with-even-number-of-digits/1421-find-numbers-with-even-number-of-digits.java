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























       /* int ans=0;
        for(int i=0;i<=nums.length;i++){
        ans=evenDigits(i);
        }
        return ans;
    }
    public int evenDigits(int num){
        int n=num,even=0,c=0;
        while(num!=0){
            ++c;
            if(c%2==0)
            ++even;
            n=n/10;
        }
        return even;
    }
}*/