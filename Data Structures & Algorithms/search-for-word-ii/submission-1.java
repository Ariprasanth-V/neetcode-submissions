class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            boolean flag = false;
            for (int r = 0; r < board.length && !flag; r++) {
                for (int c = 0; c < board[0].length; c++) {
                    if (board[r][c] != word.charAt(0)) continue;
                    if (solve(board, word, r, c, 0)) {
                        list.add(word);
                        flag = true;
                        break;
                    }
                }
            }
        }
        return list;
    }
    public boolean solve(char[][] board,String s,int r,int c,int i){
        if(i==s.length()) return true;
        if(r<0 || c>=board[0].length || c<0 || r>=board.length || board[r][c] != s.charAt(i)) return false;

        char temp=board[r][c];
        board[r][c]='#';

        boolean found = solve(board,s,r,c+1,i+1) ||
                        solve(board,s,r+1,c,i+1) ||
                        solve(board,s,r-1,c,i+1) ||
                        solve(board,s,r,c-1,i+1);

        board[r][c]=temp;
        return found;
    }
}
