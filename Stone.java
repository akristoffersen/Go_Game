import java.awt.*;
import java.util.ArrayList;

public class Stone {
    private Color color;
    private int i;
    private int j;
    //private int liberties = 4;
    private ArrayList<Stone> neighbors;

    public Stone(Color color, int xxPos, int yyPos) {
        this(color, xxPos, yyPos, null);
    }

    public Stone(Color color, int xxPos, int yyPos, ArrayList<Stone> neighbors) {
        this.neighbors = neighbors;
        this.color = color;
        this.i = xxPos;
        this.j = yyPos;
    }

    public void draw(double scaling, double radius) {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(i * scaling, j * scaling, radius);
        StdDraw.setPenColor(Color.RED);
        StdDraw.text(i * scaling, j * scaling, Integer.toString(getLiberties()));
    }

    public void addNeighbor(Stone s) {
        neighbors.add(s);
    }

    public int getLiberties() {
        return 4 - neighbors.size();
    }
}