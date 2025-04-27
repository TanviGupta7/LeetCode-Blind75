class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        findCombinations(1,k,n,ans,new ArrayList<>());
        return ans;
    }
    private void findCombinations(int start,int k, int n,List<List<Integer>> ans, List<Integer> ds){
        if(ds.size()==k){
        if(n==0){
            ans.add(new ArrayList<>(ds));
        }
            return;
        }
        for(int i=start;i<=9;i++){
            if(i>n) break;
            ds.add(i);
            findCombinations(i+1,k,n-i,ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}