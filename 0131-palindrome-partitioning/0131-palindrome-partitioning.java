class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();//ultimate resultant of strings
        List<String> path=new ArrayList<>(); //lsit of each string partition
        func(0,s,path,res); //passing 0th index, the ori. string and the 2 new data structures.
        return res; //returning the final answer
    }
    void func(int index, String s,List<String> path, List<List<String>> res){
        if(index==s.length()){ //base case
            res.add(new ArrayList<>(path)); //adding to the resultant list
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
            path.add(s.substring(index, i + 1));
            func(i+1,s,path,res);
            path.remove(path.size()-1);
            }
        }
    }
    boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}