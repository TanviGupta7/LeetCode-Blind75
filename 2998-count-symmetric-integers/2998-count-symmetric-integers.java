class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++){
            String s=Integer.toString(i);
            int l=s.length();
            if(l%2==0){
                int mid=l/2;
                String s1=s.substring(0,mid);
                String s2=s.substring(mid);
                int sum1=0,sum2=0;
                for(int j=0;j<s1.length();j++){
                    char ch=s1.charAt(j);
                    sum1=sum1+(ch-'0');
                }
                for(int j=0;j<s2.length();j++){
                    char ch=s2.charAt(j);
                    sum2=sum2+(ch-'0');
                }
                String Sum1=Integer.toString(sum1);
                String Sum2=Integer.toString(sum2);
                int result=Sum1.compareTo(Sum2);
                if(result==0)
                count++;
            }
        }
        return count;
        
    }
}