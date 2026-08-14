class Solution {
    List<List<String>> list=new ArrayList<>();
    List<String> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(0,s);
        return list;    
    }

    void backtrack(int start,String s){
        if(s.length()==start) list.add(new ArrayList<>(ans));
        else {
            for(int i=start;i<s.length();i++){
                if(ispalindrome(s,start,i)){
                    ans.add(s.substring(start,i+1));
                    backtrack(i+1,s);
                    ans.remove(ans.size()-1);
                }
            }
        }
    }

    boolean ispalindrome(String s,int i,int j){
        while(i<j) if(s.charAt(i++)!=s.charAt(j--)) return false;
        return true;
    }
}
