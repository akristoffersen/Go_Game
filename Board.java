import java.awt.*;
import java.util.HashMap;

public class Board {
    HashMap<Integer, Stone> stones;
    int size;

    public Board(int N) {
        stones = new HashMap<>(N * N);
        size = N;
    }

    /**
     * @param color black or white
     * @param row row coordinate
     * @param col col coordinate
     * @returns true if this was a legal move, false if it was a non-legal move.
     */
    public boolean AddStone(Color color, int row, int col) {
        int index = rcConvert(row, col);
        if (legalMove(color, index)) {
            return false;
        }
        stones.put(rcConvert(row, col), new Stone(color, col, row));
        return true;
    }


    private boolean legalMove(Color c, int index) {
        if (stones.containsKey(index)) {
            return false;
        }
        return true; //not correct, placeholder until I create deeper logic.
    }

    private int rcConvert(int row, int col) {
        if (row < 0 || row > size - 1 || col < 0 || col > size - 1) {
            throw new java.lang.IndexOutOfBoundsException("out of bounds row/column");
        }
        return row * size + col;
    }

    /**
     * @param scaling width of board
     * (0, 0) is at the bottom left corner.
     */
    public void draw(double scaling) {
        double dBetween = scaling / size;
        int start = 0;
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setPenRadius(0.0025);

        //making the board
        for (int i = 0; i < size; i++) {
            StdDraw.line(start, 0, start, scaling);
            StdDraw.line(0, start, scaling, start);
            start += dBetween;
        }
        //drawing the stones
        for (Stone s : stones.values()) {
            s.draw(scaling, dBetween * 0.4);
        }
    }


}