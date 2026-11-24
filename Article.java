
public class Article {
    private static int compteur = 0;
    private int id;
    private String nom;
    private String reference;
    private double prix;

    public Article(String nom, double prix) {
        this.nom = nom;
        this.id = ++compteur;
        this.prix = prix;
        this.reference = genererReference();
    }

    private String genererReference() {
        String nomSansEspace = nom.replace(" ", "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nomSansEspace.length(); i++) {
            if (i < 3) {
                sb.append(nomSansEspace.charAt(i));
            }
        }
        sb.append(id);
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
        this.reference = genererReference();
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void modifier(String nouveauNom) {
        this.nom = nouveauNom;
        this.reference = genererReference();
    }

    public void modifier(String nouveauNom, double nouveauPrix) {
        this.nom = nouveauNom;
        this.prix = nouveauPrix;
        this.reference = genererReference();
    }

    public String toString() {
        return "id=" + id + ",nom=" + nom + ",reference=" + reference + ",prix" + prix;
    }

}
