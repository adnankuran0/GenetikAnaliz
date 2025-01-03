// Hücre sınıfı tüm hücreler için temel işlevleri sağlıyor
import java.util.List;
public abstract class Hucre {
    protected String id;
    protected DNA dna;

    public Hucre(String id, DNA dna) {
        this.id = id;
        this.dna = dna;
    }

    public DNA getDNA() 
    {
        return dna;
    }
    
    
    
    public abstract List<Hucre> bolun();

    @Override
    public String toString() {
        return "Hucre{id='" + id + "', DNA=" + dna + "}";
    }
}
