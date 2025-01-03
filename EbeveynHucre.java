import java.util.ArrayList;
import java.util.List;

// Ebeveyn hücre mitoz ve mayoz bölünme yapabilir
public class EbeveynHucre extends Hucre implements BolunmeIslemi {

    public EbeveynHucre(String id, DNA dna) {
        super(id, dna);
    }

    @Override
    public List<Hucre> bolun() {
        // varılsayan bölünme olarak mitoz gerçekleştiriliyor
        return mitoz();
    }

    @Override
    public ArrayList<Hucre> mitoz() {
        System.out.println("Mitoz bolunme gerceklestiriliyor...");
        DNA kopyalananDNA = dna.kopyala();
        // kopyalanan DNAya sahip iki yeni hücre oluşturuyoruz
        Hucre yeniHucre1 = new OzellesmisHucre("1", kopyalananDNA);
        Hucre yeniHucre2 = new OzellesmisHucre("2", kopyalananDNA);
        
        ArrayList<Hucre> yeniHucreler = new ArrayList<>();
        yeniHucreler.add(yeniHucre1);
        yeniHucreler.add(yeniHucre2);
        
        System.out.println("Mitoz bolunme gerceklestirildi!");
        return yeniHucreler;
    }

    @Override
    public ArrayList<Hucre> mayoz(Hucre digerHucre) {
        System.out.println("Mayoz bolunme gerceklestiriliyor...");

        // Eğer DNA zincirindeki nükleotit sayısı tekse mayoz yapılamaz
        if (dna.getZincir1().size() % 2 != 0) {
            throw new BolunmeIstisnasi("Mayoz bolunme sadece cift sayida nukleotit iceren DNA'lar icin yapilabilir.");
        }

        // DNA zincirlerini ikiye bölüyoruz
        List<DNA.Nükleotit> zincir1Parca1 = new ArrayList<>(dna.getZincir1().subList(0, dna.getZincir1().size() / 2));
        List<DNA.Nükleotit> zincir1Parca2 = new ArrayList<>(dna.getZincir1().subList(dna.getZincir1().size() / 2, dna.getZincir1().size()));

        List<DNA.Nükleotit> zincir2Parca1 = new ArrayList<>(digerHucre.dna.getZincir1().subList(0, digerHucre.dna.getZincir1().size() / 2));
        List<DNA.Nükleotit> zincir2Parca2 = new ArrayList<>(digerHucre.dna.getZincir1().subList(digerHucre.dna.getZincir1().size() / 2, digerHucre.dna.getZincir1().size()));

        // yeni hücrelerin DNA'sını oluşturuyoruz
        List<DNA.Nükleotit> yeniZincir1 = new ArrayList<>();
        yeniZincir1.addAll(zincir1Parca1); // İlk hücrenin ilk yarısı
        yeniZincir1.addAll(zincir2Parca2); // Diğer hücrenin ikinci yarısı

        List<DNA.Nükleotit> yeniZincir2 = new ArrayList<>();
        yeniZincir2.addAll(zincir2Parca1); // Diğer hücrenin ilk yarısı
        yeniZincir2.addAll(zincir1Parca2); // İlk hücrenin ikinci yarısı

        // Yeni DNA'lar oluşturuyoruz
        DNA yeniDNA1 = new DNA(DNA.zincirdenStringiOluştur(yeniZincir1));
        DNA yeniDNA2 = new DNA(DNA.zincirdenStringiOluştur(yeniZincir2));

        // yeni hücreleri oluşturuyoruz
        Hucre yeniHucre1 = new OzellesmisHucre("1", yeniDNA1);
        Hucre yeniHucre2 = new OzellesmisHucre("2", yeniDNA2);

        // yeni hücreleri listeye ekliyoruz
        ArrayList<Hucre> yeniHucreler = new ArrayList<>();
        yeniHucreler.add(yeniHucre1);
        yeniHucreler.add(yeniHucre2);

        System.out.println("Mayoz bolunme gerceklestirildi!");
        return yeniHucreler;
    }
}
