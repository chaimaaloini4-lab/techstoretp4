import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("=== ACTIVITE 1.3 : PERSONNES & ADRESSES ===");
        System.out.println("La création des personnes commence :");
        Adresse a1 = new Adresse("Monastir", 5000);
        Adresse a2 = new Adresse("Ben Arous", 1133);
        Adresse a3 = new Adresse("Ben Arous", 1145);

        System.out.println("L'adresse a1 : " + a1);
        System.out.println("L'adresse a2 : " + a2);
        System.out.println("L'adresse a3 : " + a3);

        Personne p1 = new Personne("01111111", "Kbayer", "Jasser", "Jendouba", 8160);
        Personne p2 = new Personne("02222222", "Smida", "Ghayth", a1);

        System.out.println("La personne p1 : " + p1);
        System.out.println("La personne p2 : " + p2);

        p1.setNom("Ben Ali");
        p1.setPrenom("Sami");
        p1.setAdresse(a2);

        System.out.println("Après modification de p1 : " + p1);
        System.out.println();

        ArrayList<String> noms = new ArrayList<>(Arrays.asList(
                "Micro Casque 588 Filaire",
                "Souris Sans Fil Logitech",
                "Clavier Mécanique RGB"));
        ArrayList<Double> prix = new ArrayList<>(Arrays.asList(45.0, 60.0, 150.0));
        ArrayList<Long> quantites = new ArrayList<>(Arrays.asList(10L, 15L, 5L));

        Stock stock = new Stock(noms, prix, quantites);
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\nGESTION DU STOCK tp44");
            System.out.println("0 - Ajouter un article");
            System.out.println("1 - Augmenter la quantité d'un article");
            System.out.println("2 - Modifier un article");
            System.out.println("3 - Supprimer un article");
            System.out.println("4 - Consulter le stock");
            System.out.println("5 - Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 0:
                    System.out.print("Nom de l'article : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prix (TND) : ");
                    double p = scanner.nextDouble();
                    System.out.print("Quantité : ");
                    long q = scanner.nextLong();
                    if (p >= 0 && q >= 0) {
                        stock.ajouterArticle(nom, p, q);
                        System.out.println("Article ajouté avec succès !");
                    } else {
                        System.out.println("Erreur : le prix et la quantité doivent être positifs.");
                    }
                    break;

                case 1:
                    System.out.print("Référence de l'article : ");
                    String refInc = scanner.nextLine();
                    System.out.print("Quantité à ajouter : ");
                    long qInc = scanner.nextLong();
                    if (stock.incrementerQuantiteArticle(refInc, qInc)) {
                        System.out.println("Quantité mise à jour avec succès !");
                    } else {
                        System.out.println("Erreur : article introuvable ou quantité invalide.");
                    }
                    break;

                case 2:
                    System.out.print("Référence de l'article à modifier : ");
                    String refMod = scanner.nextLine();
                    System.out.print("Nouveau nom : ");
                    String nNom = scanner.nextLine();
                    System.out.print("Nouveau prix : ");
                    double nPrix = scanner.nextDouble();
                    System.out.print("Nouvelle quantité : ");
                    long nQte = scanner.nextLong();
                    if (nPrix >= 0 && nQte >= 0 && stock.modifierArticle(refMod, nNom, nPrix, nQte)) {
                        System.out.println("Article modifié avec succès !");
                    } else {
                        System.out.println("Erreur : article introuvable ou valeurs invalides.");
                    }
                    break;

                case 3:
                    System.out.print("Référence de l'article à supprimer : ");
                    String refSup = scanner.nextLine();
                    if (stock.supprimerArticle(refSup)) {
                        System.out.println("Article supprimé avec succès !");
                    } else {
                        System.out.println("Erreur : aucun article trouvé avec cette référence.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- CONTENU DU STOCK (" + stock.getArticleNb() + " articles) ---");
                    System.out.print(stock.toString());
                    break;

                case 5:
                    System.out.println("Fermeture de l'application TechStore.");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 5);

        scanner.close();
    }
}
