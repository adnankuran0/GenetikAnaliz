import java.util.List;
import java.util.ArrayList;

public class OzellesmisHucre extends Hucre {

    public OzellesmisHucre(String id, DNA dna) {
        super(id, dna);
    }

    @Override
    public List<DNA.Nükleotit> bolun() {
        System.out.println("Ozellesmis hucreler daha fazla bolunemez.");
        return new ArrayList<>();  // Boş bir liste döndürüyoruz
    }
}
