
import java.util.Scanner;

public class NQueens {

    static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check the same column in previous rows.
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper-left diagonal.
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper-right diagonal.
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    static boolean solve(int[][] board, int row, int n) {
        if (row == n) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;

                if (solve(board, row + 1, n)) {
                    return true;
                }

                board[row][col] = 0; // Backtrack
            }
        }

        return false;
    }

    static void printBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N (N >= 1): ");
        int n = sc.nextInt();

        if (n < 1) {
            System.out.println("N must be positive.");
            sc.close();
            return;
        }

        int[][] board = new int[n][n];

        // Fix the first queen at row 0, column 0.
        board[0][0] = 1;

        if (solve(board, 1, n)) {
            System.out.println("Solution:");
            printBoard(board, n);
        } else {
            System.out.println("No solution for this fixed position.");
        }

        sc.close();
    }
}
