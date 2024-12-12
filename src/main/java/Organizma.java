
public class Organizma {
    private String ad;
    private TemelDNA dna;
    
    public Organizma(String ad, TemelDNA dna) {
        this.ad = ad;
        this.dna = dna;
    }
    
    public void bilgiGoster() {
        System.out.println("Organizma Adı: " + ad);
        System.out.println("DNA Dizilimi: " + dna.getDizilim());
    }
    public double getGCOrani()
    {
        return dna.GCOraniniHesapla(); 
    }
    
    class GenetikDetaylar {
        public void GCOraniniGoster()
        {
            System.out.println("GC Oranı: " + getGCOrani());
        }
        
        public void getNukleotidSayisi() {
            int aSayisi = 0, tSayisi = 0, cSayisi = 0, gSayisi = 0;
            for (char base : dna.getDizilim().toCharArray()) {
                switch (base) {
                    case 'A' -> aSayisi++;
                    case 'T' -> tSayisi++;
                    case 'C' -> cSayisi++;
                    case 'G' -> gSayisi++;
                }
            }
            System.out.println("A: " + aSayisi + ", T: " + tSayisi + ", C: " + cSayisi + ", G: " + gSayisi);
        }
    }
    
}
