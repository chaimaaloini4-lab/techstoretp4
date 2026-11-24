import java.util.ArrayList;

public class Stock {
    private ArrayList<Element> articleList;

    public Stock() {
        this.articleList = new ArrayList<>();
    }

    public Stock(ArrayList<Element> articleList) {
        this.articleList = (articleList != null) ? articleList : new ArrayList<>();
    }

    public Stock(ArrayList<String> noms, ArrayList<Double> prix, ArrayList<Long> quantites) {
        this.articleList = new ArrayList<>();
        if (noms != null && prix != null && quantites != null) {
            int taille = Math.min(noms.size(), Math.min(prix.size(), quantites.size()));
            for (int i = 0; i < taille; i++) {
                Element e = new Element(noms.get(i), prix.get(i), quantites.get(i));
                this.articleList.add(e);
            }
        }
    }

    public ArrayList<Element> getArticleList() {
        return articleList;
    } public int getArticleNb() {
        return this.articleList.size();
    }

    public void setArticleList(ArrayList<Element> articleList) {
        this.articleList = (articleList != null) ? articleList : new ArrayList<>();
    }
    public void ajouterArticle(Article article, long quantite) {
        if (article != null) {
            this.articleList.add(new Element(article, quantite));
        }
    }

    public void ajouterArticle(String nom, double prix, long quantite) {
        this.articleList.add(new Element(nom, prix, quantite));
    }

    public Element trouverArticle(String reference) {
        if (reference == null) {
            return null;
        }
        for (Element e : articleList) {
            if (e.equalsReference(reference)) {
                return e;
            }
        }
        return null;
    }

    public boolean modifierArticle(String reference, String nouveauNom, double nouveauPrix, long nouvelleQuantite) {
        Element e = trouverArticle(reference);
        if (e != null) {
            e.modifier(nouveauNom, nouveauPrix, nouvelleQuantite);
            return true;
        }
        return false;
    }
    public boolean supprimerArticle(String reference) {
        Element e = trouverArticle(reference);
        if (e != null) {
            articleList.remove(e);
            return true;
        }
        return false;
    }

    public boolean incrementerQuantiteArticle(String reference, long qte) {
        Element e = trouverArticle(reference);
        if (e != null) {
            e.incrementerQuantite(qte);
            return true;
        }
        return false;
    }

    public boolean decrementerQuantiteArticle(String reference, long qte) {
        Element e = trouverArticle(reference);
        if (e != null) {
            e.decrementerQuantite(qte);
            return true;
        }
        return false;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Element e : articleList) {
            sb.append(e.toString()).append("\n");
        }
        return sb.toString().trim();
    }


}

