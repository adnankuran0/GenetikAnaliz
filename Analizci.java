import java.util.Random;

public class Analizci {
    
    private static Random random = new Random();
    
    public static int DNAUzunlugu(Hucre hucre) 
    {
        //iki zincirin de nükleotit sayılarını toplayıp DNA uzunluğunu buluyoruz
        return hucre.getDNA().getDizilim().length();
    }
    
    public static boolean MayozBolunebilirMi(EbeveynHucre hucre)
    {
        //DNAUzunlugu fonksiyonunu kullanrak çift olup olmadığını buluyoruz
        if (DNAUzunlugu(hucre) % 2 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean Karsilastir(Hucre hucre1, Hucre hucre2)
    {   
        //karşılıklı zincirler birbirine eşitse true döndürüyoruz
        if (hucre1.getDNA().getZincir1().equals(hucre2.getDNA().getZincir2())  
                && hucre1.getDNA().getZincir2().equals(hucre2.getDNA().getZincir2()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static String DizilimOlustur(int uzunluk)
    {
        // DNA diziliminde kullanılacak karakterler
        char[] nükleotitler = new char[] { 'A', 'T', 'C', 'G' };
        StringBuilder dnaDizilimi = new StringBuilder();  
        
        for (int i = 0; i < uzunluk; i++) {
            // Rastgele bir nükleotit seçiyoruz
            char nükleotit = nükleotitler[random.nextInt(nükleotitler.length)];
            dnaDizilimi.append(nükleotit);
        }
        
        // Stringe dönüştürüp geri döndürüyoruz
        return dnaDizilimi.toString();
    }
    
    public static boolean DizilimiBarindiriyorMu(Hucre hucre,String dizilim)
    {
        if (hucre.getDNA().getDizilim().contains(dizilim))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static float GCOraniHesapla(Hucre hucre)
    {
        int gcSayisi = 0;
        String dnaString = hucre.getDNA().getDizilim();
        // DNA dizilimindeki her harfi kontrol ediyoruz
        for (int i = 0; i < dnaString.length(); i++) {
            char nükleotit = dnaString.charAt(i);
            // Eğer nükleotit G veya C ise sayıyı arttırıyoruz
            if (nükleotit == 'G' || nükleotit == 'C') {
                gcSayisi++;
            }
        }

        // oranlıyoruz
        return (float) gcSayisi / dnaString.length() * 100;
    }
    
    public static void BilgiGoster(Hucre hucre)
    {
        System.out.println(hucre.toString());
    }
}
