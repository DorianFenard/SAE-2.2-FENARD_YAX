import java.util.ArrayList;
import java.util.List;

/**
 * Classe Arcs
 */
public class Arcs {
    private List<Arc> arcs;

    /**
     * Constructeur de la classe Arcs
     */
    public Arcs() {
        this.arcs = new ArrayList<>();
    }

    /**
     * @param a l'arc à ajouter
     */
    public void ajouterArc(Arc a) {
        this.arcs.add(a);
    }

    /**
     * @return la liste des arcs
     */
    public List<Arc> getArcs() {
        return this.arcs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Arc arc : arcs) {
            sb.append(arc.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
