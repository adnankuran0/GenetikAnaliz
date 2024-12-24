// Hücre sınıfı tüm hücreler için temel işlevleri sağlıyor
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
    
    
    
    public abstract void bolun();

    @Override
    public String toString() {
        return "Hucre{id='" + id + "', DNA=" + dna + "}";
    }
}
