class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits=="" || digits.length()==0) return list;
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        bt(map,list,digits,0,new StringBuilder());
        return list;
    }
    private void bt(Map<Character,String> map,List<String> list,String s,int i,StringBuilder sb){
        if(i==s.length()){
            list.add(new String(sb));
            return;
        }
        for(Character c:map.get(s.charAt(i)).toCharArray()){
            sb.append(c);
            bt(map,list,s,i+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
