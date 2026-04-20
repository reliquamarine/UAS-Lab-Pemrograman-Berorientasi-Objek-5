package jawaban2;

class Kendaraan {
    String jenis;
    int durasi;

    // Constructor
    public Kendaraan(String jenis) {
        jenis = jenis.toLowerCase();

        if (!jenis.equals("motor") && !jenis.equals("mobil") && !jenis.equals("truk")) {
            throw new IllegalArgumentException("Jenis kendaraan tidak valid!");
        }

        this.jenis = jenis;
    }

    // Overloading method (manual)
    public double hitungBiaya(int durasi) {
        this.durasi = durasi;
        return prosesBiaya();
    }

    // Overloading method (jam)
    public double hitungBiaya(int jamMasuk, int jamKeluar) {
        this.durasi = jamKeluar - jamMasuk;
        return prosesBiaya();
    }

    // Hitung biaya parkir
    private double prosesBiaya() {
        double tarif = 0;

        switch (jenis) {
            case "motor":
                tarif = 2000;
                break;
            case "mobil":
                tarif = 5000;
                break;
            case "truk":
                tarif = 10000;
                break;
            default:
                System.out.println("Jenis tidak valid!");
        }

        double total = tarif * durasi;

        // Diskon 10% jika > 5 jam
        if (durasi > 5) {
            total *= 0.9;
        }

        return total;
    }

    // Menampilkan ringkasan
    public void tampilkan(double total) {
        System.out.println("\n---- PARKING SUMMARY ----");
        System.out.println("Vehicle Type  : " + jenis);
        System.out.println("Parking Time  : " + durasi + " hour(s)");
        System.out.println("Total Fee     : Rp" + total);
    }
}
