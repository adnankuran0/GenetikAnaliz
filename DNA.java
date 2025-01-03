import java.util.ArrayList;
import java.util.List;

// DNA sınıfı nükleotit zincirlerini ve mutasyon işlemlerini içeriyor
public class DNA {
    // Nükleotitleri iki farklı zincirde tutuyoruz
    private List<Nükleotit> zincir1;
    private final List<Nükleotit> zincir2;

    public DNA(String dizi1) {
        zincir1 = new ArrayList<>();
        zincir2 = new ArrayList<>();
        for (char baz : dizi1.toCharArray()) {
            Nükleotit nükleotit = new Nükleotit(baz);
            zincir1.add(nükleotit);
            //karşı zinciri oluştururken tamamlayıcı bazları kullanıyoruz
            zincir2.add(new Nükleotit(nükleotit.getTamamlayıcıBaz()));
        }
    }

    public List<Nükleotit> getZincir1() {
        return zincir1;
    }

    public List<Nükleotit> getZincir2() {
        return zincir2;
    }

    public DNA kopyala() {
        //DNA'yı kopyalamak için constructora string halini gönderiyoruz
        return new DNA(this.toString());
    }

    public void mutasyonEkle(char baz, int indeks) throws IllegalArgumentException, GecersizBazIstisnasi {
        if (indeks < 0 || indeks >= zincir1.size()) {
            throw new IllegalArgumentException("Mutasyon icin indeks DNA uzunlugunun disinda.");
        }
        if (baz != 'A' && baz != 'T' && baz != 'C' && baz != 'G') {
            throw new GecersizBazIstisnasi("Gecersiz baz: " + baz);
        }
        System.out.println("DNA mutasyona ugratiliyor...");
        
        //Belirtilen indeksteki bazı verilene göre değiştiriyoruz
        zincir1.set(indeks, new Nükleotit(baz));
        zincir2.set(indeks, new Nükleotit(new Nükleotit(baz).getTamamlayıcıBaz()));
        System.out.println("DNA mutasyona ugratildi!");
    }
    
    // Zinciri Stringe çevirme fonksiyonu
    public static String zincirdenStringiOluştur(List<Nükleotit> zincir) {
        StringBuilder sb = new StringBuilder();
        for (Nükleotit nükleotit : zincir) {
            sb.append(nükleotit.getBaz());
        }
        return sb.toString();
    }
    
    @Override
    public String toString() {
        StringBuilder zincirStr = new StringBuilder();
        for (Nükleotit nükleotit : zincir1) {
         
            zincirStr.append(nükleotit.getBaz());
        }
        return zincirStr.toString();
    }
    
    public String getDizilim() {
        StringBuilder zincirStr = new StringBuilder();
        for (Nükleotit nükleotit : zincir1) {
         
            zincirStr.append(nükleotit.getBaz());
        }
        for (Nükleotit nükleotit : zincir2)
        {
            zincirStr.append(nükleotit.getBaz());
        }
        return zincirStr.toString();
    }

    // İç sınıf: Nükleotit
    public static class Nükleotit {
        private char baz;

        public Nükleotit(char baz) {
            this.baz = baz;
        }

        public char getBaz() {
            return baz;
        }

        public char getTamamlayıcıBaz() {
            //mevcut baza göre karşıt olan bazı döndürüyoruz
            switch (baz) {
                case 'A': return 'T';
                case 'T': return 'A';
                case 'C': return 'G';
                case 'G': return 'C';
                default: throw new IllegalArgumentException("Gecersiz baz: " + baz);
            }
        }

    }
}
