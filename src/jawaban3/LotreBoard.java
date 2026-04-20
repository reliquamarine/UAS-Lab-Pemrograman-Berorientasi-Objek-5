package jawaban3;

import java.util.Random;

class LotreBoard {
    char[][] board = new char[4][5];
    boolean[][] revealed = new boolean[4][5];
    int[][] data = new int[4][5]; // 0 = aman, 1 = bom

    int openedSafe = 0;
    boolean kenaBom = false;

    // 2 bom random
    public void generateBoard() {
        Random rand = new Random();

        // init semua aman
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                data[i][j] = 0;
                revealed[i][j] = false;
                board[i][j] = '*';
            }
        }

        // pasang 2 bom
        int bom = 0;
        while (bom < 2) {
            int r = rand.nextInt(4);
            int c = rand.nextInt(5);

            if (data[r][c] == 0) {
                data[r][c] = 1;
                bom++;
            }
        }
    }

    // menampilkan board
    public void displayBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (!revealed[i][j]) {
                    System.out.print("* ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    // proses menebak
    public boolean guess(int row, int col) {
        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka sebelumnya!");
            return true;
        }

        revealed[row][col] = true;

        if (data[row][col] == 1) {
            board[row][col] = 'X';
            kenaBom = true;
            return false;
        } else {
            board[row][col] = 'O';
            openedSafe++;
            return true;
        }
    }

    // game over
    public boolean isGameOver() {
        return kenaBom || openedSafe == 18;
    }

    public boolean isWin() {
        return openedSafe == 18;
    }
}
