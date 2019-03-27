import java.awt.*;

public class Stone {
    private Color color;
    private int i;
    private int j;

    public Stone(Color color, int xxPos, int yyPos) {
        this.color = color;
        this.i = xxPos;
        this.j = yyPos;
    }

    public void draw(double scaling, double radius) {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(i * scaling, j * scaling, radius);
    }
}