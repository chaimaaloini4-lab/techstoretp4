
public class Adresse {
    private String gouvernorat;
    private int codepostale;

    public Adresse(String gouvernorat, int codepostale) {
        this.gouvernorat = gouvernorat;
        this.codepostale = codepostale;

    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public int getCodepostale() {
        return codepostale;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public void setCodepostale(int codepostale) {
        this.codepostale = codepostale;
    }

    public String toString() {
        return "Adresse[gouvernorat=" + gouvernorat + ", codepostale=" + codepostale + "]";

    }

}