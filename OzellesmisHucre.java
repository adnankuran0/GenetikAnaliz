public class OzellesmisHucre extends Hucre {

    public OzellesmisHucre(String id, DNA dna) {
        super(id, dna);
    }

    @Override
    public void bolun() {
        System.out.println("Ozellesmis hucreler daha fazla bolunemez.");
    }
}
