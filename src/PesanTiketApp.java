import java.util.Scanner;

public class PesanTiketApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di program pemesanan tiket!");
        
        System.out.print("Masukkan nama pembeli: ");
        String namaPembeli = scanner.next();
        System.out.println("");
        System.out.println("Pilih tahap pembelian:");
        System.out.println("1. Presale");
        System.out.println("2. Reguler");
        System.out.print("Pilih tahap pembelian (1/2): ");
        int tahapPembelian = scanner.nextInt();
        System.out.println("");

        if (tahapPembelian != 1 && tahapPembelian != 2) {
            System.out.println("Input tidak valid!");
            return;
        }

        Tiket tiket = null;
        if (tahapPembelian == 1) {
            System.out.println("Pilih jenis tiket:");
            System.out.println("1. VIP");
            System.out.println("2. VVIP");
            System.out.print("Pilih jenis tiket (1/2): ");
            int jenisTiket = scanner.nextInt();
            System.out.println("");

            if (jenisTiket != 1 && jenisTiket != 2) {
                System.out.println("Input tidak valid!");
                return;
            }

            tiket = (jenisTiket == 1) ? new VIP() : new VVIP();
        } else if (tahapPembelian == 2) {
            System.out.println("Pilih jenis tiket:");
            System.out.println("1. Festival");
            System.out.println("2. VIP");
            System.out.println("3. VVIP");
            System.out.print("Pilih jenis tiket (1/2/3): ");
            int jenisTiket = scanner.nextInt();
            System.out.println("");

            if (jenisTiket < 1 || jenisTiket > 3) {
                System.out.println("Input tidak valid!");
                return;
            }

            tiket = (jenisTiket == 1) ? new Festival() : ((jenisTiket == 2) ? new VIP() : new VVIP());
        }

        System.out.print("Masukkan jumlah tiket yang ingin dibeli: ");
        int jumlahTiket = scanner.nextInt();

        // Membuat objek Pemesanan berdasarkan input pengguna
        Pemesanan pesanan = new Pemesanan(namaPembeli, (tahapPembelian == 1) ? "Presale" : "Reguler", tiket, jumlahTiket);

        // Cetak nota
        pesanan.cetakNota();
    }
}