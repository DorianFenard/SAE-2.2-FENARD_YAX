import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GrapheTest {

    @Test
    public void testAjouterArc() {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("X", "Y", 20);
        assertTrue(gr.listeNoeuds().contains("X"));
        assertTrue(gr.listeNoeuds().contains("Y"));
        // Vérification de l'ajout de l'arc
        List<Arc> arcs = gr.suivants("X");
        assertEquals(1, arcs.size());
        assertEquals("Y", arcs.get(0).getDest());
        assertEquals(20, arcs.get(0).getCout(), 0.001);
    }

    @Test
    public void testSuivants() {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("M", "N", 25);
        gr.ajouterArc("M", "O", 30);
        ArrayList<Arc> arcs = (ArrayList<Arc>) gr.suivants("M");
        assertEquals(2, arcs.size());
        assertEquals("N", arcs.get(0).getDest());
        assertEquals(25, arcs.get(0).getCout(), 0.001);
        assertEquals("O", arcs.get(1).getDest());
        assertEquals(30, arcs.get(1).getCout(), 0.001);
    }

    @Test
    public void testListeNoeuds() {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("P", "Q", 30);
        gr.ajouterArc("Q", "R", 35);
        gr.ajouterArc("R", "S", 40);
        ArrayList<String> noeud = (ArrayList<String>) gr.listeNoeuds();
        assertEquals(4, noeud.size());
        assertTrue(noeud.contains("P"));
        assertTrue(noeud.contains("Q"));
        assertTrue(noeud.contains("R"));
        assertTrue(noeud.contains("S"));
    }

    @Test
    public void testToString() {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("X", "Y", 15);
        gr.ajouterArc("Y", "Z", 25);
        gr.ajouterArc("Z", "X", 35);
        String expected = "X -> Y(15)\nY -> Z(25)\nZ -> X(35)\n";
        assertEquals(expected, gr.toString());
    }
}
