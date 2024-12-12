
public class DNAAraclar {
    public static String mutasyonYap(String dizilim) {
        return dizilim.replace('A', 'T');
    }
    
    public static String mutasyonYap(String dizilim, char kaynak, char hedef) {
        return dizilim.replace(kaynak, hedef);
    }
    
    public static String mutasyonYap(String dizilim, int konum, char hedef) {
        char[] dizilimArray = dizilim.toCharArray();
        dizilimArray[konum] = hedef;
        return new String(dizilimArray);
    }
    
    public static String rastgeleDNAOlustur(int uzunluk) {
        String nukleotidler = "ATCG";
        StringBuilder rastgeleDNA = new StringBuilder();
        for (int i = 0; i < uzunluk; i++) {
            rastgeleDNA.append(nukleotidler.charAt((int) (Math.random() * 4)));
        }
        return rastgeleDNA.toString();
    }
    
    public static boolean dizilimleriKarsilastir(String dizilim1, String dizilim2) {
        return dizilim1.equals(dizilim2);
    }
}
