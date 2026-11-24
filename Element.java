public class Element {
    private Article article;
    private long quantite;

    public Element(Article article, long quantite){
        this.article=article;
        this.quantite=(quantite >=0) ? quantite : 0;
    }
    
    public Element(String nom, double prix, long quantite) {
        this.article = new Article(nom, prix);
        this.quantite = (quantite >= 0) ? quantite : 0;
    }

    public Article getArticle() {
        return article;
    }
    public long getQuantite(){
        return quantite;
    }
    
    public String getReferenceArticle() {
        return (article == null) ? null : article.getReference();
    }

    public String getNomArticle() {
        return (article == null) ? null : article.getNom();
    }

    public double getPrixArticle() {
        return (article == null) ? 0.0 : article.getPrix();
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setQuantite(long quantite) {
        if (quantite >= 0) {
            this.quantite = quantite;
        }
    }
    public void incrementerQuantite(long qte){
        if (qte>0){
            this.quantite += qte;
        }
    }
    public void decrementerQuantite(long qte) {
        if (qte > 0 && qte <= this.quantite) {
            this.quantite -= qte;
        }
    }
    public void modifier(String nom, double prix, long quantite) {
        this.article = new Article(nom, prix);
        if (quantite >= 0) {
            this.quantite = quantite;
        }
    }
    public boolean equalsReference(String reference) {
        if (this.article == null || reference == null) {
            return false;
        }
        return this.article.getReference().equalsIgnoreCase(reference);
    }
    public boolean equalsArticle(Article autreArticle) {
        if (this.article == null || autreArticle == null) {
            return false;
        }
        return this.article.getId() == autreArticle.getId() ||
               this.article.getReference().equalsIgnoreCase(autreArticle.getReference());
    }

    
    public String toString() {
        return "Element [article=" + article + ", quantite=" + quantite + "]";
    }
}




