import java.awt.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        //int size = Integer.parseInt(args[0]);
        int size = 13;
        Color color = Color.WHITE; //which player it is;
        int actions = 0;
        Board board = new Board(size, 760);

        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(750, 750);
        StdDraw.setXscale(-10, 740);
        StdDraw.setYscale(-10, 740);
        Color background = new Color(197, 166, 91); //beige


        while (true) {
            StdDraw.clear(background);
            board.draw();
            if (board.mouseClick(color)) {
                if (color.equals(Color.WHITE)) {
                    color = Color.BLACK;
                } else {
                    color = Color.WHITE;
                }
            };
            StdDraw.show();
            StdDraw.pause(50);
        }
    }
}
