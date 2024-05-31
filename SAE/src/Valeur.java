import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Classe fournie, permet de stocker des valeurs associées au noeud et des parents
 * - un noeud est représenté par un String (son nom)
 * - on accède avec des get (getValeur et getParent)
 * - on modifie avec des set (setValeur et setParent)
 */
public class Valeur {

    /**
     * Attributs pour stocker les informations (type Table = Dictionnaire)
     */
    private Map<String, Double> valeur;
    private Map<String, String> parent;

    /**
     * Constructeur vide (initialise la possibilité de stocker des valeurs)
     */
    public Valeur() {
        this.valeur = new TreeMap<>();
        this.parent = new TreeMap<>();
    }

    /**
     * Permet d'associer une valeur à un nom de noeud (ici L(X))
     *
     * @param nom    le nom du noeud
     * @param valeur la valeur associée
     */
    public void setValeur(String nom, double valeur) {
        this.valeur.put(nom, valeur);
    }

    /**
     * Permet d'associer un parent à un nom de noeud (ici parent(X))
     *
     * @param nom    nom du noeud
     * @param parent nom du noeud parent associé
     */
    public void setParent(String nom, String parent) {
        this.parent.put(nom, parent);
    }

    /**
     * Accède au parent stocké associé au noeud nom passé en paramètre
     *
     * @param nom nom du noeud
     * @return le nom du noeud parent
     */
    public String getParent(String nom) {
        return this.parent.get(nom);
    }

    /**
     * Accède à la valeur associée au noeud nom passé en paramètre
     *
     * @param nom nom du noeud
     * @return la valeur stockée
     */
    public double getValeur(String nom) {
        return this.valeur.get(nom);
    }

    /**
     * Retourne une chaîne qui affiche le contenu
     * - par noeud stocké
     * - à chaque noeud, affiche la valeur puis le noeud parent
     *
     * @return descriptif du noeud
     */
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (String s : this.valeur.keySet()) {
            Double valeurNoeud = valeur.get(s);
            String noeudParent = parent.get(s);
            res.append(s).append(" ->  V:").append(valeurNoeud).append(" p:").append(noeudParent).append("\n");
        }
        return res.toString();
    }

    /**
     * Calcule le chemin menant au nœud passé en paramètre
     * @param destination le nœud de destination
     * @return la liste des nœuds correspondant au chemin
     */
    public List<String> calculerChemin(String destination) {
        List<String> chemin = new ArrayList<>();
        String noeud = destination;
        while (noeud != null) {
            chemin.add(0, noeud);
            noeud = getParent(noeud);
        }
        return chemin;
    }
}
