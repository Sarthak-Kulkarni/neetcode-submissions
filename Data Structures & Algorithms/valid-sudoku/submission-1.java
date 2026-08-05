class Solution {
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {

                String squareKey = String.valueOf(i/3) + "," + String.valueOf(j/3);

                if(board[i][j] == '.') {
                    continue;
                } else if(rows.getOrDefault(i, new HashSet<>()).contains(board[i][j]) ||
                        cols.getOrDefault(j, new HashSet<>()).contains(board[i][j]) ||
                        squares.getOrDefault(squareKey, new HashSet<>()).contains(board[i][j])) {
                    return false;
                }

                rows.computeIfAbsent(i, k -> new HashSet<>()).add(board[i][j]);
                cols.computeIfAbsent(j, k -> new HashSet<>()).add(board[i][j]);
                squares.computeIfAbsent(squareKey, k -> new HashSet<>()).add(board[i][j]);
            }
        }    

        return true;
        
    }
}
