// Import Scanner untuk menerima input dari pengguna (digunakan di Soal 2)
import java.util.Scanner;

// ============================================================
// SOAL 1: Pembuatan Class dan Object
// ============================================================
class Mahasiswa {
    // Soal 1 poin 1: Atribut untuk menyimpan data mahasiswa
    String nama;
    String nim;
    String jurusan;

    // Soal 2 poin 1: Atribut ipk dibuat private agar menerapkan enkapsulasi
    // Data ipk tidak bisa diakses langsung dari luar class
    private double ipk;

    // Soal 1 poin 2: Constructor untuk menginisialisasi data mahasiswa saat objek dibuat
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Soal 2 poin 2: Getter untuk membaca nilai ipk dari luar class
    public double getIpk() {
        return ipk;
    }

    // Soal 2 poin 2: Setter untuk memperbarui nilai ipk dari luar class
    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    // Soal 1 poin 3: Method untuk menampilkan informasi dasar mahasiswa
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Jurusan: " + jurusan);
        System.out.println("IPK: " + String.format("%.2f", ipk));
    }

    // Method tambahan untuk menampilkan data lengkap beserta status dan predikat
    // (digunakan setelah IPK diperbarui di Soal 2 dan 3)
    public void tampilkanInfoLengkap() {
        System.out.println("=== Data Mahasiswa ===");
        tampilkanInfo();
        System.out.println("Status: " + cekKelulusan());
        System.out.println("Predikat: " + hitungPredikat());
    }

    // Soal 2 poin 3: Method untuk menentukan status kelulusan berdasarkan IPK
    // IPK >= 3.00 -> Lulus, IPK < 3.00 -> Belum Lulus
    public String cekKelulusan() {
        if (ipk >= 3.00) {
            return "Lulus";
        }
        return "Belum Lulus";
    }

    // Soal 3: Method untuk menentukan predikat akademik berdasarkan rentang IPK
    public String hitungPredikat() {
        if (ipk >= 3.75) {
            return "Dengan Pujian";           // IPK >= 3.75
        } else if (ipk >= 3.50) {
            return "Sangat Memuaskan";        // 3.50 <= IPK < 3.75
        } else if (ipk >= 3.00) {
            return "Memuaskan";               // 3.00 <= IPK < 3.50
        }
        return "Perlu Perbaikan";               // IPK < 3.00
    }

    // Soal 2 poin 4: Method untuk memperbarui IPK mahasiswa
    public void updateIpk(double ipkBaru) {
        this.ipk = ipkBaru;
    }
}

// Class utama yang berisi method main untuk menjalankan program
class Assignment1 {
    public static void main(String[] args) {
        // Soal 1 poin 4: Membuat 5 objek mahasiswa dengan data berbeda
        Mahasiswa[] daftarMahasiswa = {
            new Mahasiswa("Andi Pratama", "2440001", "Teknik Informatika", 3.75),
            new Mahasiswa("Budi Santoso", "2440002", "Sistem Informasi", 3.40),
            new Mahasiswa("Citra Lestari", "2440003", "Teknik Informatika", 3.90),
            new Mahasiswa("Joni Suhartono", "2440004", "Teknik Industri", 3.00),
            new Mahasiswa("Bulan Suci", "2440005", "Akuntansi", 3.20)
        };

        // Soal 1 poin 4: Menampilkan seluruh informasi mahasiswa ke konsol
        System.out.println("=== Data Mahasiswa ===");
        for (Mahasiswa mhs : daftarMahasiswa) {
            mhs.tampilkanInfo();
            System.out.println();
        }

        // ============================================================
        // SOAL 2: Enkapsulasi dan Method (Update IPK)
        // ============================================================

        // Membuat objek Scanner untuk membaca input dari keyboard
        Scanner scanner = new Scanner(System.in);

        // Soal 2 poin 4: Meminta NIM mahasiswa yang ingin diupdate
        System.out.print("Masukkan NIM mahasiswa yang ingin diupdate: ");
        String nimUpdate = scanner.nextLine();

        // Soal 2 poin 4: Meminta IPK baru dari pengguna
        System.out.print("Masukkan IPK baru: ");
        double ipkBaru = scanner.nextDouble();
        scanner.close();

        // Mencari mahasiswa berdasarkan NIM yang diinput
        Mahasiswa mahasiswaDipilih = null;
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.nim.equals(nimUpdate)) {
                mahasiswaDipilih = mhs;
                break;
            }
        }

        // Jika mahasiswa ditemukan, perbarui IPK dan tampilkan hasilnya
        if (mahasiswaDipilih != null) {
            mahasiswaDipilih.updateIpk(ipkBaru);
            System.out.println("Data berhasil diperbarui!");

            // Soal 2 poin 5 & Soal 3: Tampilkan info, status kelulusan, dan predikat
            mahasiswaDipilih.tampilkanInfoLengkap();
        } else {
            System.out.println("Mahasiswa dengan NIM " + nimUpdate + " tidak ditemukan.");
        }
    }
}
