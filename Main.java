public class Main {
    public static void main(String[] args) {
        // İnsan DNA'sı oluşturma
        TemelDNA insanDNA = new InsanDNA("ATCGATCG", "Homo Sapiens");
        insanDNA.mutasyonYap();
        System.out.println("İnsan DNA'sı GC Oranı: " + insanDNA.GCOraniniHesapla() + "%");

        // Hayvan DNA'sı oluşturma
        TemelDNA hayvanDNA = new HayvanDNA("GCGTAGCT", "Felis Catus");
        hayvanDNA.mutasyonYap();
        System.out.println("Hayvan DNA'sı GC Oranı: " + hayvanDNA.GCOraniniHesapla() + "%");

        // DNA analizci kullanımı
        DNAAnalizci analizci = new DNAAnalizci("ATCG");
        System.out.println("Ters Çevrilmiş DNA: " + analizci.dizilimiTersCevir());
        System.out.println("DNA Geçerli mi? " + (analizci.gecerliMi() ? "Evet" : "Hayır"));

        // DNA araçlarıyla mutasyon
        String mutatedDNA = DNAAraclar.mutasyonYap("ATCGATCG", 'A', 'G');
        System.out.println("Mutasyon Sonucu: " + mutatedDNA);

        // Rastgele DNA üretimi
        String randomDNA = DNAAraclar.rastgeleDNAOlustur(10);
        System.out.println("Rastgele DNA: " + randomDNA);

        // DNA karşılaştırma
        boolean isEqual = DNAAraclar.dizilimleriKarsilastir("ATCG", "ATCG");
        System.out.println("DNA Dizilimleri Eşit mi? " + (isEqual ? "Evet" : "Hayır"));

        // Organizma kullanımı
        Organizma insanOrganizmasi = new Organizma("İnsan", insanDNA);
        insanOrganizmasi.bilgiGoster();

        // Organizma içindeki iç içe sınıfı kullanma
        Organizma.GenetikDetaylar genetikDetaylar = insanOrganizmasi.new GenetikDetaylar();
        genetikDetaylar.GCOraniniGoster();
        genetikDetaylar.getNukleotidSayisi();

        // Exception Handling
        try {
            DNAAnalizci gecersizDNAAnalizcisi = new DNAAnalizci("AXCG");
            if (!gecersizDNAAnalizcisi.gecerliMi()) {
                throw new GecersizDNAIstisnasi("Geçersiz DNA dizilimi!");
            }
        } catch (GecersizDNAIstisnasi e) {
            System.out.println("Hata: " + e.getMessage());
        }

        try {
            if (mutatedDNA.length() == 0) {
                throw new MutasyonIstisnasi("Mutasyon başarısız!");
            }
        } catch (MutasyonIstisnasi e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}