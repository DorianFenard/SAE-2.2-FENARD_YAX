import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
/**
 * Classe de Test de Dijkstra
 */
public class DijkstraTest {
    @Test
    public void testSolve() {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("1", "2", 5);
        gr.ajouterArc("2", "3", 6);
        gr.ajouterArc("3", "4", 7);
        gr.ajouterArc("4", "1", 8);

        Dijkstra dijkstra = new Dijkstra();
        Valeur resultat = dijkstra.solve(gr, "1");

        assertEquals(0, resultat.getValeur("1"));
        assertEquals(5, resultat.getValeur("2"));
        assertEquals(11, resultat.getValeur("3"));
        assertEquals(18, resultat.getValeur("4"));

        assertEquals(null, resultat.getParent("1"));
        assertEquals("1", resultat.getParent("2"));
        assertEquals("2", resultat.getParent("3"));
        assertEquals("3", resultat.getParent("4"));
    }

    @Test
    public void testCheminMultiple() {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("1", "2", 2);
        gr.ajouterArc("1", "3", 4);
        gr.ajouterArc("2", "3", 1);
        gr.ajouterArc("2", "4", 7);
        gr.ajouterArc("3", "4", 3);

        Dijkstra dijkstra = new Dijkstra();
        Valeur resultat = dijkstra.solve(gr, "1");

        assertEquals(0, resultat.getValeur("1"));
        assertEquals(2, resultat.getValeur("2"));
        assertEquals(3, resultat.getValeur("3"));
        assertEquals(6, resultat.getValeur("4"));

        assertEquals(null, resultat.getParent("1"));
        assertEquals("1", resultat.getParent("2"));
        assertEquals("2", resultat.getParent("3"));
        assertEquals("3", resultat.getParent("4"));
    }

    @Test
    public void testNegatif() {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("1", "2", 4);
        gr.ajouterArc("1", "3", 1);
        gr.ajouterArc("3", "2", -2);
        gr.ajouterArc("2", "4", 2);
        gr.ajouterArc("3", "4", 5);

        Dijkstra dijkstra = new Dijkstra();
        Valeur resultat = dijkstra.solve(gr, "1");

        assertEquals(0, resultat.getValeur("1"));
        assertEquals(1, resultat.getValeur("3"));
    }
}
