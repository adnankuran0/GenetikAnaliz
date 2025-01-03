import java.util.ArrayList;

/*
Bu proje, hücre bölünmesini ve DNA yönetimini basit kapsamda simüle etmeyi amaçlar.
*/

public class Main {
    public static void main(String[] args) {
        try {
            DNA ebeveynDNA = new DNA("AATGCAGA");
            DNA ozellesmisDNA = new DNA(Analizci.DizilimOlustur(8));
            EbeveynHucre ebeveynHucre = new EbeveynHucre("0",ebeveynDNA);
            OzellesmisHucre ozellesmisHucre = new OzellesmisHucre("1",ozellesmisDNA);
            
            System.out.println("DNA 1: " + ebeveynDNA);
            System.out.println("DNA 2: " + ozellesmisDNA + "\n");
            
            
            System.out.println("------------Analiz------------");
            System.out.println("1. DNA'nin uzunlugu: " + Analizci.DNAUzunlugu(ebeveynHucre));
            System.out.println("1. DNA'nin GC orani: " + Analizci.GCOraniHesapla(ebeveynHucre));
            System.out.println("1. DNA mayoz bolunebilir mi?: " + Analizci.MayozBolunebilirMi(ebeveynHucre));
            System.out.println("Hucreler ayni mi?: " + Analizci.Karsilastir(ebeveynHucre, ozellesmisHucre));
            System.out.println("Rastgele dizilim: "+ Analizci.DizilimOlustur(5));
            System.out.println("AT barindiriyor mu?: " + Analizci.DizilimiBarindiriyorMu(ebeveynHucre,"AT"));
            Analizci.BilgiGoster(ebeveynHucre);
            
            // Mutasyon
            System.out.println("\nNormal DNA: " + ebeveynDNA);
            ebeveynDNA.mutasyonEkle('G', 2);
            System.out.println("Mutasyonlu DNA: " + ebeveynDNA+"\n");
            
            // Mitoz Bölünme
            ArrayList<Hucre> mitoz_urunler = ebeveynHucre.mitoz();
            System.out.println(mitoz_urunler.getFirst());
            System.out.println(mitoz_urunler.getLast());
            ozellesmisHucre.bolun();
            System.out.println();
            
            // Mayoz Bölünme
            ArrayList<Hucre> mayoz_urunler = ebeveynHucre.mayoz(ozellesmisHucre);
            System.out.println(mayoz_urunler.getFirst());
            System.out.println(mayoz_urunler.getLast());

            
            //hata yakalama
        } catch (IllegalArgumentException e) {
            System.err.println("Hata: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Beklenmeyen hata: " + e.getMessage());
        }
    }
}
