/**
 *Main de la classe Dijkstra
 */
public class MainDijkstra {
    /**
     * méthode main
     * @param args
     */
    public static void main(String[] args) {

        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("D", "C", 10);
        gr.ajouterArc("A", "B", 12);
        gr.ajouterArc("D", "B", 23);
        gr.ajouterArc("A", "D", 87);
        gr.ajouterArc("E", "D", 43);
        gr.ajouterArc("B", "E", 11);
        gr.ajouterArc("C", "A", 19);

        System.out.println("Graphe initial :");
        System.out.println(gr.toString());

        Dijkstra dijkstra = new Dijkstra();
        Valeur resultat = dijkstra.solve(gr, "A");

        System.out.println("Résultats de l'algorithme de Dijkstra :");
        System.out.println(resultat.toString());

        for (String noeud : gr.listeNoeuds()) {
            System.out.println("Chemin vers " + noeud + " : " + resultat.calculerChemin(noeud));
        }
    }
}
