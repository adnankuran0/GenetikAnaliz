public abstract class TemelDNA {
    private String dizilim;
    private String organizmaAdi;
    
    public TemelDNA(String dizilim, String organizmaAdi)
    {
        this.dizilim = dizilim;
        this.organizmaAdi = organizmaAdi;
        //System.out.println(organizmaAdi+" DNA'sı oluşturuldu. Dizilim: "+dizilim);
    }
    
    public abstract void mutasyonYap();
    
    public abstract double GCOraniniHesapla();
    
    public String getDizilim()
    {
        return dizilim;
    }
    
    public void setDizilim(String dizilim)
    {
        this.dizilim = dizilim;
    }
    
}
