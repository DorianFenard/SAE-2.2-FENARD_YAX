import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/**
Classe ComparaisonAlgo
 **/
public class ComparaisonAlgo {

    public static void main(String[] args) {
        GrapheListe gr1 = new GrapheListe("Graphe11");
        GrapheListe gr2 = new GrapheListe("Graphe105");
        GrapheListe gr3 = new GrapheListe("Graphe305");
        GrapheListe gr4 = new GrapheListe("Graphe405");
        GrapheListe gr5 = new GrapheListe("Graphe505");
        GrapheListe gr6 = new GrapheListe("Graphe605");
        GrapheListe gr7 = new GrapheListe("Graphe705");
        GrapheListe gr8 = new GrapheListe("Graphe805");
        GrapheListe gr9 = new GrapheListe("Graphe905");

        try (FileWriter csvWriter = new FileWriter("Comparaison_Algorithmes.csv")) {
            csvWriter.append("Graphe,Algorithme,Durée (ns),Durée (ms),Durée (s),Résultats Identiques\n");

            comparerAlgorithmes(csvWriter, gr1, "1", "Graphe11");
            comparerAlgorithmes(csvWriter, gr2, "1", "Graphe105");
            comparerAlgorithmes(csvWriter, gr3, "1", "Graphe305");
            comparerAlgorithmes(csvWriter, gr4, "1", "Graphe405");
            comparerAlgorithmes(csvWriter, gr5, "1", "Graphe505");
            comparerAlgorithmes(csvWriter, gr6, "1", "Graphe605");
            comparerAlgorithmes(csvWriter, gr7, "1", "Graphe705");
            comparerAlgorithmes(csvWriter, gr8, "1", "Graphe805");
            comparerAlgorithmes(csvWriter, gr9, "1", "Graphe905");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void comparerAlgorithmes(FileWriter csvWriter, GrapheListe graphe, String depart, String grapheName) throws IOException {
        //Bellman-Ford
        BellmanFord bf = new BellmanFord();
        long debutBF = System.nanoTime();
        Valeur resultatBF = bf.solve(graphe, depart);
        long finBF = System.nanoTime();
        long dureeBF = finBF - debutBF;
        double dureeBFSecondes = dureeBF / 1e9;
        double dureeBFMillisecondes = dureeBF / 1e6;

        //Dijkstra
        Dijkstra dj = new Dijkstra();
        long debutDJ = System.nanoTime();
        Valeur resultatDJ = dj.solve(graphe, depart);
        long finDJ = System.nanoTime();
        long dureeDJ = finDJ - debutDJ;
        double dureeDJSecondes = dureeDJ / 1e9;
        double dureeDJMillisecondes = dureeDJ / 1e6;

        // Comparaison des résultats
        boolean resultatsIdentiques = true;
        for (String noeud : graphe.listeNoeuds()) {
            if (resultatBF.getValeur(noeud) != resultatDJ.getValeur(noeud)) {
                resultatsIdentiques = false;
                break;
            }
        }

        csvWriter.append(grapheName).append(",");
        csvWriter.append("Bellman-Ford").append(",");
        csvWriter.append(String.valueOf(dureeBF)).append(",");
        csvWriter.append(String.valueOf(dureeBFMillisecondes)).append(",");
        csvWriter.append(String.valueOf(dureeBFSecondes)).append(",");
        csvWriter.append(resultatsIdentiques ? "Oui" : "Non").append("\n");

        csvWriter.append(grapheName).append(",");
        csvWriter.append("Dijkstra").append(",");
        csvWriter.append(String.valueOf(dureeDJ)).append(",");
        csvWriter.append(String.valueOf(dureeDJMillisecondes)).append(",");
        csvWriter.append(String.valueOf(dureeDJSecondes)).append(",");
        csvWriter.append(resultatsIdentiques ? "Oui" : "Non").append("\n");
    }
}
