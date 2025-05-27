class Solution{
    public int differenceOfSums(int n, int m){
        int ans=0;
        for(int i=1;i<=n;i++){
            if(i%m!=0)
            ans+=i;
            else
            ans-=i;
        }
        return ans;
    }
}
/*
class Solution {
    public int differenceOfSums(int n, int m) {
        int num1=0,num2=0,n1,m1;
        for(int i=1;i<=n;i++){
            n1=i;
            if(n1%m!=0)
            num1=num1+n1;
        }
        for(int j=1;j<=n;j++){
            m1=j;
            if(m1%m==0)
            num2=num2+m1;
        }
        return num1-num2;
    }
}*/
