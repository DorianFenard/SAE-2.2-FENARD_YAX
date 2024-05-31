/**
 * Classe Arc
 */
public class Arc {
    private String dest;
    private double cout;

    /**
     * Constructeur d'Arc
     * @param d la destination de l'arc
     * @param c le coût de l'arc
     */
    public Arc(String d, double c) {
        if (c <= 0) {
          c=1;
        }
        this.dest = d;
        this.cout = c;
    }

    /**
     * @return la destination de l'arc
     */
    public String getDest() {
        return dest;
    }

    /**
     * @return le coût de l'arc
     */
    public double getCout() {
        return cout;
    }


    @Override
    public String toString() {
       return "("+this.dest+","+this.cout+")";
    }
}