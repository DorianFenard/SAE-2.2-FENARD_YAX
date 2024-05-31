/**
 * Classe BellmanFord
 */
public class BellmanFord implements Algorithme {

    /**
     * @param g Le graphe sur lequel l'algorithme est appliqué.
     * @param depart Le noeud de départ pour le chemin.
     * @return La valeur qui contient le chemin le plus court et les coûts des noeuds.
     */
    public Valeur solve(Graphe g, String depart) {
        Valeur v = new Valeur();

        for (String noeud : g.listeNoeuds()) {
            v.setValeur(noeud, Double.POSITIVE_INFINITY);
            v.setParent(noeud, null);
        }
        v.setValeur(depart, 0);

        int nombreNoeuds = g.listeNoeuds().size();

        for (int i = 0; i < nombreNoeuds - 1; i++) {
            for (String noeud : g.listeNoeuds()) {
                double valeurNoeud = v.getValeur(noeud);
                for (Arc arc : g.suivants(noeud)) {
                    String destination = arc.getDest();
                    double nouveauCout = valeurNoeud + arc.getCout();
                    if (nouveauCout < v.getValeur(destination)) {
                        v.setValeur(destination, nouveauCout);
                        v.setParent(destination, noeud);
                    }
                }
            }
        }

        return v;
    }
}
