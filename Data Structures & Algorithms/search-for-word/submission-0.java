class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;

        // Try starting DFS from every cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (search(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(int r, int c, char[][] board, String word, int i) {
        // ✅ Base case: all characters matched
        if (i == word.length()) return true;

        // ❌ Out of bounds or mismatch
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length 
            || board[r][c] != word.charAt(i)) {
            return false;
        }

        // Mark visited
        char temp = board[r][c];
        board[r][c] = '#';

        // Explore 4 directions
        boolean found = search(r+1, c, board, word, i+1) ||
                        search(r-1, c, board, word, i+1) ||
                        search(r, c+1, board, word, i+1) ||
                        search(r, c-1, board, word, i+1);

        // Backtrack (restore cell)
        board[r][c] = temp;

        return found;
    }
}
