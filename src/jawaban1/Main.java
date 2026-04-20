package jawaban1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Perusahaan p = new Perusahaan();
        int pilihan;

        do {
            System.out.println("\n=== SISTEM MANAJEMEN KARYAWAN ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi");
            System.out.println("4. Ubah Gaji");
            System.out.println("5. Tampilkan Semua");
            System.out.println("6. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Posisi: ");
                    String posisi = sc.nextLine();
                    System.out.print("Gaji: ");
                    double gaji = sc.nextDouble();

                    Karyawan k = new Karyawan(id, nama, posisi, gaji);
                    p.tambah(k);
                    break;

                case 2:
                    System.out.print("ID yang dihapus: ");
                    p.hapus(sc.nextLine());
                    break;

                case 3:
                    System.out.print("ID: ");
                    String idPos = sc.nextLine();
                    System.out.print("Posisi baru: ");
                    String posBaru = sc.nextLine();
                    p.ubahPosisi(idPos, posBaru);
                    break;

                case 4:
                    System.out.print("ID: ");
                    String idGaji = sc.nextLine();
                    System.out.print("Gaji baru: ");
                    double gajiBaru = sc.nextDouble();
                    p.ubahGaji(idGaji, gajiBaru);
                    break;

                case 5:
                    p.tampilkanSemua();
                    break;
            }

        } while (pilihan != 6);

        System.out.println("Program selesai.");
    }
}
