class Solution {
    private void findCombinations(int ind,int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        if(ind==arr.length){ // base case
            if(target==0){
                ans.add(new ArrayList<>(ds)); //when base case is reached, trasfer the elements in ds to finally get stored in new ds. Also, add func. has linear T.C - O(n)
            }
            return;
        }
        if(arr[ind]<=target){ //condition for picking
            ds.add(arr[ind]); // add picked ele to data structure
            findCombinations(ind,arr,target-arr[ind],ans,ds); //pick
            ds.remove(ds.size()-1); // after recursion is executed,backtrack to remove the picked index element 
        }
        findCombinations(ind+1,arr, target, ans,ds); //  not pick
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        findCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans; //returning final ans
        }
}
