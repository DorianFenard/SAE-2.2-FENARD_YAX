import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un graphe sous forme de liste d'adjacence.
 */
public class GrapheListe implements Graphe {
    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    /**
     * Constructeur par défaut de GrapheListe
     */
    public GrapheListe() {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }

    /**
     * Constructeur de GrapheListe à partir d'un fichier
     * @param nomFichier nom du fichier contenant le graphe
     */
    public GrapheListe(String nomFichier) {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
        if (!nomFichier.contains("Graphes")) {
            nomFichier = "Graphes/" + nomFichier;
        }
        if (!nomFichier.contains(".txt")) {
            nomFichier = nomFichier + ".txt";
        }
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] partie = ligne.split("\t");
                String noeud1 = partie[0];
                String noeud2 = partie[1];
                double cost = Double.parseDouble(partie[2]);

                ajouterArc(noeud1, noeud2, cost);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichier introuvable.");
        } catch (IOException e) {
            System.out.println("Erreur dans la lecture du fichier.");
        }
    }

    /**
     * Retourne l'indice d'un nœud
     * @param n le nom du nœud
     * @return l'indice du nœud dans la liste
     */
    private int getIndice(String n) {
        return noeuds.indexOf(n);
    }

    /**
     *
     * @return une list de noeuds
     */
    @Override
    public List<String> listeNoeuds() {
        return this.noeuds;
    }

    /**
     *
     * @param n le nom du nœud dont on veut obtenir les arcs sortants
     * @return
     */
    @Override
    public List<Arc> suivants(String n) {
        int indice = getIndice(n);
        if (indice != -1) {
            return adjacence.get(indice).getArcs();
        }
        return new ArrayList<>();
    }

    /**
     * Ajoute un arc entre deux nœuds
     * @param depart      le nœud de départ de l'arc
     * @param destination le nœud de destination de l'arc
     * @param cout        le coût de l'arc
     */
    public void ajouterArc(String depart, String destination, double cout) {
        if (!noeuds.contains(depart)) {
            noeuds.add(depart);
            adjacence.add(new Arcs());
        }
        if (!noeuds.contains(destination)) {
            noeuds.add(destination);
            adjacence.add(new Arcs());
        }
        int indiceDepart = getIndice(depart);
        adjacence.get(indiceDepart).ajouterArc(new Arc(destination, cout));
    }

    /**
     * @return un String représentant le graphe
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < noeuds.size(); i++) {
            sb.append(noeuds.get(i)).append(" -> ");
            List<Arc> arcs = adjacence.get(i).getArcs();
            if (arcs.isEmpty()) {
                sb.append("aucun arc");
            } else {
                for (int j = 0; j < arcs.size(); j++) {
                    Arc arc = arcs.get(j);
                    sb.append(arc.getDest()).append("(").append((int) arc.getCout()).append(")");
                    if (j < arcs.size() - 1) {
                        sb.append(", ");
                    }
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * main avec la figure1
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

        gr.toString();
    }
}
