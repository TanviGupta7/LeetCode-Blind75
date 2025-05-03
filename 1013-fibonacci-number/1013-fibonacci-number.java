class Solution {
    public int fib(int n) {
        return series(n);
    }
    public int series(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return series(n-1)+series(n-2);
    }
}

/* if(n==0) return 0;
        if(n==1) return 1;
        int a=0,b=1,c=0;
        for(int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;*/