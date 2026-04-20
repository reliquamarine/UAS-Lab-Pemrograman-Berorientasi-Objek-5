package jawaban1;

import java.util.ArrayList;

class Perusahaan {
    ArrayList<Karyawan> daftar = new ArrayList<>();

    // Menambah karyawan
    public void tambah(Karyawan k) {
        for (Karyawan x : daftar) {
            if (x.id.equals(k.id)) {
                System.out.println("ID sudah ada!");
                return;
            }
        }

        if (k.gaji < 0) {
            System.out.println("Gaji tidak boleh negatif!");
            return;
        }

        daftar.add(k);
        System.out.println("Karyawan berhasil ditambahkan.");
    }

    // Menghapus karyawan
    public void hapus(String id) {
        for (Karyawan k : daftar) {
            if (k.id.equals(id)) {
                daftar.remove(k);
                System.out.println("Karyawan berhasil dihapus.");
                return;
            }
        }
        System.out.println("ID tidak ditemukan.");
    }

    // Mengubah posisi
    public void ubahPosisi(String id, String posisiBaru) {
        for (Karyawan k : daftar) {
            if (k.id.equals(id)) {
                k.posisi = posisiBaru;
                System.out.println("Posisi berhasil diubah.");
                return;
            }
        }
        System.out.println("ID tidak ditemukan.");
    }

    // Mengubah gaji
    public void ubahGaji(String id, double gajiBaru) {
        if (gajiBaru < 0) {
            System.out.println("Gaji tidak boleh negatif!");
            return;
        }

        for (Karyawan k : daftar) {
            if (k.id.equals(id)) {
                k.gaji = gajiBaru;
                System.out.println("Gaji berhasil diubah.");
                return;
            }
        }
        System.out.println("ID tidak ditemukan.");
    }

    // Menampilkan semua
    public void tampilkanSemua() {
        if (daftar.isEmpty()) {
            System.out.println("Data kosong.");
            return;
        }

        for (Karyawan k : daftar) {
            k.tampilkan();
        }
    }
}
