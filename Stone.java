import java.awt.*;

public class Stone {
    private Color color;
    private int xxPos;
    private int yyPos;

    public Stone(Color color, int xxPos, int yyPos) {
        this.color = color;
        this.xxPos = xxPos;
        this.yyPos = yyPos;
    }

    public void draw(double scaling, double radius) {
        StdDraw.setPenColor(color);
        StdDraw.circle(this.xxPos * scaling, this.yyPos * scaling, radius);
    }
}