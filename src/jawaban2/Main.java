package jawaban2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalKendaraan = 0;
        double totalSemuaBiaya = 0;
        char lanjut = 'y';

        System.out.println("======= Welcome to ParkingChan =======");

        do {
            System.out.print("\nEnter vehicle type (Motor/Mobil/Truk): ");
            String jenis = sc.nextLine();

            Kendaraan k = new Kendaraan(jenis);
            if (!jenis.equalsIgnoreCase("motor") &&
                    !jenis.equalsIgnoreCase("mobil") &&a
                    !jenis.equalsIgnoreCase("truk")) {

                System.out.println("Jenis kendaraan tidak valid!");
                continue;
            }

            System.out.print("Enter Duration (Manual/Time): ");
            String metode = sc.nextLine();

            double biaya = 0;

            if (metode.equalsIgnoreCase("manual")) {
                System.out.print("Enter Duration (in hour): ");
                int jam = sc.nextInt();
                biaya = k.hitungBiaya(jam);

            } else if (metode.equalsIgnoreCase("time")) {
                System.out.print("Enter entry time: ");
                int masuk = sc.nextInt();
                System.out.print("Enter exit time: ");
                int keluar = sc.nextInt();
                biaya = k.hitungBiaya(masuk, keluar);

            } else {
                System.out.println("Metode tidak valid!");
                continue;
            }

            sc.nextLine();

            k.tampilkan(biaya);

            totalKendaraan++;
            totalSemuaBiaya += biaya;

            System.out.print("\nAdd another vehicle? (y/n): ");
            lanjut = sc.nextLine().charAt(0);

        } while (lanjut == 'y' || lanjut == 'Y');

        System.out.println("\n======= FINAL REPORT =======");
        System.out.println("Total Vehicle Final     : " + totalKendaraan);
        System.out.println("Total Parking Fees Final: " + totalSemuaBiaya);
        System.out.println("Thank You....");
    }
}
