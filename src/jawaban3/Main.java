package jawaban3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LotreBoard game = new LotreBoard();
        game.generateBoard();

        System.out.println("Welcome to E-Lottery Gosok");

        while (!game.isGameOver()) {
            game.displayBoard();

            System.out.print("\nMasukkan tebakan anda (baris dan kolom): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (row < 0 || row >= 4 || col < 0 || col >= 5) {
                System.out.println("Input di luar batas!");
                continue;
            }

            boolean aman = game.guess(row, col);

            if (!aman) {
                System.out.println("BOOM! Anda menemukan bom! Permainan berakhir.");
                break;
            } else {
                System.out.println("Kotak Aman");
            }
        }

        // tampilkan board akhir
        game.displayBoard();

        if (game.isWin()) {
            System.out.println("\nSelamat anda menang!");
        }

        sc.close();
    }
}
