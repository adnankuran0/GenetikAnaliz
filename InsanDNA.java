

class InsanDNA extends TemelDNA {

    public InsanDNA(String dizilim, String organizmaAdi) {
        super(dizilim, organizmaAdi);
    }

    @Override
    public void mutasyonYap() {
        System.out.println("İnsan DNA'sı mutasyonu uygulandı.");
    }

    @Override
    public double GCOraniniHesapla() {
        int gcCount = 0;
        for (char base : getDizilim().toCharArray()) {
            if (base == 'G' || base == 'C') {
                gcCount++;
            }
        }
        return (gcCount / (double) getDizilim().length()) * 100;
    }
}
