import java.util.List;

/**
 * Classe Graphe
 */
public interface Graphe {
    /**
     * @return la liste des nœuds sous forme de chaîne de caractères
     */
    public List<String> listeNoeuds();

    /**
     * @param n le nom du nœud dont on veut obtenir les arcs sortants
     * @return la liste des arcs partant du nœud spécifié
     */
    public List<Arc> suivants(String n);
}
