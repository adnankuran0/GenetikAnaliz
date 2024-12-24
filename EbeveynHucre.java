import java.util.ArrayList;
import java.util.List;

// Ebeveyn hücre mitoz ve mayoz bölünme yapabilir
public class EbeveynHucre extends Hucre implements BolunmeIslemi {

    public EbeveynHucre(String id, DNA dna) {
        super(id, dna);
    }

    @Override
    public void bolun() {
        List<DNA.Nükleotit> zincir1Parça1 = new ArrayList<>(dna.getZincir1().subList(0, dna.getZincir1().size() / 2));

    }

    @Override
    public ArrayList<Hucre> mitoz() {
        System.out.println("Mitoz bolunme gerceklestiriliyor...");
        DNA kopyalananDNA = dna.kopyala();
        // kopyalanan DNAya sahip iki yeni hücre oluşturuyoruz
        Hucre yavruHucre1 = new OzellesmisHucre("1", kopyalananDNA);
        Hucre yavruHucre2 = new OzellesmisHucre("2", kopyalananDNA);
        
        ArrayList<Hucre> yavruHucreler = new ArrayList<>();
        yavruHucreler.add(yavruHucre1);
        yavruHucreler.add(yavruHucre2);
        
        System.out.println("Mitoz bolunme gerceklestirildi!");
        return yavruHucreler;
    }

    @Override
    public ArrayList<Hucre> mayoz(Hucre digerHucre) {
        System.out.println("Mayoz bolunme gerceklestiriliyor...");

        // Eğer DNA zincirindeki nükleotit sayısı tekse mayoz yapılamaz
        if (dna.getZincir1().size() % 2 != 0) {
            throw new BolunmeIstisnasi("Mayoz bolunme sadece cift sayida nukleotit iceren DNA'lar icin yapilabilir.");
        }

        // DNA zincirlerini ikiye bölüyoruz
        List<DNA.Nükleotit> zincir1Parça1 = new ArrayList<>(dna.getZincir1().subList(0, dna.getZincir1().size() / 2));
        List<DNA.Nükleotit> zincir1Parça2 = new ArrayList<>(dna.getZincir1().subList(dna.getZincir1().size() / 2, dna.getZincir1().size()));

        List<DNA.Nükleotit> zincir2Parça1 = new ArrayList<>(digerHucre.dna.getZincir1().subList(0, digerHucre.dna.getZincir1().size() / 2));
        List<DNA.Nükleotit> zincir2Parça2 = new ArrayList<>(digerHucre.dna.getZincir1().subList(digerHucre.dna.getZincir1().size() / 2, digerHucre.dna.getZincir1().size()));

        // Yavru hücrelerin DNA'sını oluşturuyoruz
        List<DNA.Nükleotit> yavruZincir1 = new ArrayList<>();
        yavruZincir1.addAll(zincir1Parça1); // İlk hücrenin ilk yarısı
        yavruZincir1.addAll(zincir2Parça2); // Diğer hücrenin ikinci yarısı

        List<DNA.Nükleotit> yavruZincir2 = new ArrayList<>();
        yavruZincir2.addAll(zincir2Parça1); // Diğer hücrenin ilk yarısı
        yavruZincir2.addAll(zincir1Parça2); // İlk hücrenin ikinci yarısı

        // Yeni DNA'lar oluşturuyoruz
        DNA yavruDNA1 = new DNA(DNA.zincirdenStringiOluştur(yavruZincir1));
        DNA yavruDNA2 = new DNA(DNA.zincirdenStringiOluştur(yavruZincir2));

        // Yavru hücreleri oluşturuyoruz
        Hucre yavruHucre1 = new OzellesmisHucre("1", yavruDNA1);
        Hucre yavruHucre2 = new OzellesmisHucre("2", yavruDNA2);

        // Yavru hücreleri listeye ekliyoruz
        ArrayList<Hucre> yavruHucreler = new ArrayList<>();
        yavruHucreler.add(yavruHucre1);
        yavruHucreler.add(yavruHucre2);

        System.out.println("Mayoz bolunme gerceklestirildi!");
        return yavruHucreler;
    }
}
