
public class DNAAnalizci implements IAnalizci{
    private String dizilim;
    
    public DNAAnalizci(String dizilim)
    {
        this.dizilim = dizilim;
    }
    
    @Override
    public String dizilimiTersCevir() {
        return new StringBuilder(dizilim).reverse().toString();
    }
    
    @Override
    public boolean gecerliMi() {
        return dizilim.matches("[ATCG]+");
    }

    public String getDizilim() {
        return dizilim;
    }
}
