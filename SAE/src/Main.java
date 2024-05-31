import java.io.IOException;

/**
 * Classe main de BellmanFord
 */
public class Main {
    /**
     * méthode main
     * @param args
     */

    public static void main(String[] args) {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("A", "B", 20);
        gr.ajouterArc("A", "D", 3);
        gr.ajouterArc("D", "C", 4);
        gr.ajouterArc("C", "B", 2);
        gr.ajouterArc("B", "G", 10);
        gr.ajouterArc("G", "F", 5);
        gr.ajouterArc("F", "E", 3);


        System.out.println("Graphe initial :");
        System.out.println(gr.toString());

        BellmanFord bf = new BellmanFord();
        Valeur resultat = bf.solve(gr, "A");

        System.out.println("Résultats de l'algorithme de Bellman-Ford :");
        System.out.println(resultat.toString());

        for (String noeud : gr.listeNoeuds()) {
            System.out.println("Chemin vers " + noeud + " : " + resultat.calculerChemin(noeud));
        }
    }
}
