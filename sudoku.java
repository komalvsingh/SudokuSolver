public class sudoku {
  public boolean isValid(char[][] grid, int row, int col, char num) {
    for (int i = 0; i < 9; i++) {
      if (grid[row][i] == num || grid[i][col] == num || grid[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) {
        return false;
      }
    }
    return true;
  }

  public boolean solve(char[][] grid) {
    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        if (grid[row][col] == '.') {
          for (char num = '1'; num <= '9'; num++) {
            if (isValid(grid, row, col, num)) {
              grid[row][col] = num;
              if (solve(grid)) {
                return true;
              } else {
                grid[row][col] = '.';
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  public void sudokusolver(char[][] grid) {
    solve(grid);
  }

  public static void main(String[] args) {
    sudoku s = new sudoku();
    char[][] grid = {
        { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
        { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
        { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
        { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
        { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
        { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
        { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
        { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
        { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
    };

    s.sudokusolver(grid);

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
  }
}
