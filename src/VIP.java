class VIP extends Tiket{
    @Override
    public double getHarga() {
        return 150;
    }

    @Override
    public String getJenis() {
        return "VIP";
    }
}