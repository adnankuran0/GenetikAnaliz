import java.util.List;
import java.util.ArrayList;

public class OzellesmisHucre extends Hucre {

    public OzellesmisHucre(String id, DNA dna) {
        super(id, dna);
    }

    @Override
    public List<Hucre> bolun() {
        throw new BolunmeIstisnasi("Ozellesmis hucreler bolunemez.");
    }
}
