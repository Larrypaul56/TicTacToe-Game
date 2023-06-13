package csu07419.tictactoe;

public class PlayBoard {


     public char[][] board;
    public int rows;
    public int columns;
    public PlayBoard(int ROWS, int COLUMNS) {
        this.rows = ROWS;
        this.columns = COLUMNS;
        this.board = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = ' ';
            }
        }
        System.out.println(this);
    }
    public boolean checkFreeSpace(TokenPosition pos) {
        int currentRow = pos.getRow();
        int currentColumn = pos.getColumn();
        if (currentRow >= 0 && currentRow < board.length && currentColumn >= 0 && currentColumn < board[0].length) {
            return board[currentRow][currentColumn] == ' ';
        }
        return false;
    }
    public void placeToken(TokenPosition pos, char player) {
int currentRow= pos.getRow();
int currentColumn= pos.getColumn();
            board[currentRow][currentColumn] = player;
    }

    public boolean checkWinner(TokenPosition lastPos) {
        char token = TokenAtPosition(lastPos);
        return checkHorizontalWin(lastPos, token) ||
                checkVerticalWin(lastPos, token) ||
                checkDiagonalWin(lastPos, token);
    }
    public boolean checkTie()
    {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (board[row][column] == ' ') {
                    return false; // There is an available space, game not tied
                }
            }
        }
        return true;
    }
    public boolean checkHorizontalWin(TokenPosition lastPos, char player)
    {
        int row = lastPos.getRow();
        int column = lastPos.getColumn();
        for (int col = column - 4; col <= column; col++) {
            if (col >= 0 && col + 4 < columns) {
                boolean win = true;
                for (int i = 0; i < 5; i++) {
                    if (board[row][col + i] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkVerticalWin(TokenPosition lastPos, char player) {
        int row = lastPos.getRow();
        int column = lastPos.getColumn();
        for (int r = row - 4; r <= row; r++) {
            if (r >= 0 && r + 4 < rows) {
                boolean win = true;
                for (int i = 0; i < 5; i++) {
                    if (board[r + i][column] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkDiagonalWin(TokenPosition lastPos, char player) {
        return checkDiagonalWinOne(lastPos, player) || checkDiagonalWinTwo(lastPos, player);
    }
    public boolean checkDiagonalWinOne(TokenPosition lastPos, char player) {
        int row = lastPos.getRow();
        int column = lastPos.getColumn();
        for (int i = 4; i >= 0; i--) {
            if (row - i >= 0 && row - i + 4 < rows && column - i >= 0 && column - i + 4 < columns) {
                boolean win = true;
                for (int j = 0; j < 5; j++) {
                    if (board[row - i + j][column - i + j] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkDiagonalWinTwo(TokenPosition lastPos, char player) {
        int row = lastPos.getRow();
        int column = lastPos.getColumn();
        for (int i = 4; i >= 0; i--) {
            if (row + i < rows && row + i - 4 >= 0 && column - i >= 0 && column - i + 4 < columns) {
                boolean win = true;
                for (int j = 0; j < 5; j++) {
                    if (board[row + i - j][column - i + j] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }
    public char TokenAtPosition(TokenPosition pos)
    {
        int row = pos.getRow();
        int column = pos.getColumn();
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            return board[row][column];
        }
        return ' ';
    }
    public boolean isTokenAtPos(TokenPosition pos, char player) {
        return TokenAtPosition(pos) == player;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
       //  Prints column indices
        result.append("  ");
        for (int j = 0; j < columns; j++) {
            result.append(j).append("|");
        }
        result.append("\n");

        // Prints board rows
        for (int i = 0; i < rows; i++) {
            result.append(i).append("|");
            for (int j = 0; j < columns; j++) {
                result.append(board[i][j]).append("|");
            }
            result.append("\n");
        }

        return result.toString();
    }
}

