import java.util.*;
/**
Classe Dijsktra
 **/
public class Dijkstra implements Algorithme {

    /**
     *Algorithme de Dijkstra
     * @param g graphe étudié
     * @param depart noeud de départ pour commencer le chemin
     * @return L'objet Valeur qui contient les distances minimales et les parents pour chaque noeud.
     */
    public Valeur solve(Graphe g, String depart) {
        Valeur v = new Valeur();
        Set<String> noeudsATraiter = new HashSet<>(g.listeNoeuds());
        Map<String, Double> distances = new HashMap<>();

        for (String noeud : g.listeNoeuds()) {
            v.setValeur(noeud, Double.POSITIVE_INFINITY);
            v.setParent(noeud, null);
            distances.put(noeud, Double.POSITIVE_INFINITY);
        }

        v.setValeur(depart, 0);
        distances.put(depart, 0.0);

        List<String> queue = new ArrayList<>(g.listeNoeuds());

        while (!queue.isEmpty()) {
            String s = null;
            double minDistance = Double.POSITIVE_INFINITY;
            for (String noeud : queue) {
                if (distances.get(noeud) < minDistance) {
                    minDistance = distances.get(noeud);
                    s = noeud;
                }
            }

            if (s == null) {
                break;
            }

            queue.remove(s);
            noeudsATraiter.remove(s);

            for (Arc arc : g.suivants(s)) {
                String voisin = arc.getDest();
                if (noeudsATraiter.contains(voisin)) {
                    double nouvelleDistance = v.getValeur(s) + arc.getCout();
                    if (nouvelleDistance < v.getValeur(voisin)) {
                        v.setValeur(voisin, nouvelleDistance);
                        v.setParent(voisin, s);
                        distances.put(voisin, nouvelleDistance);
                    }
                }
            }
        }

        return v;
    }

    public static void main(String[] args) {
        GrapheListe g = new GrapheListe("Graphes/Graphe14.txt");
        Dijkstra d = new Dijkstra();
        Valeur res =  d.solve(g,"1");
        System.out.println(res);

    }
}
