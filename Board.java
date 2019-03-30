import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Board {
    private HashMap<Integer, Stone> stones;
    private int size;
    private double scaling;

    public Board(int N, double scale) {
        stones = new HashMap<>(N * N);
        size = N;
        scaling = scale;
    }

    /**
     * @param color black or white
     * @param row row coordinate
     * @param col col coordinate
     * @returns true if this was a legal move, false if it was a non-legal move.
     */
    public boolean AddStone(Color color, int row, int col) {
        int index = rcConvert(row, col);
        if (!legalMove(color, index)) {
            return false;
        }
        //counting liberties
        ArrayList<Stone> neighbors = findLiberties(row, col);
        Stone adding = new Stone(color, col, row, neighbors);

        for (Stone s : neighbors) {
            s.addNeighbor(s);
        }

        stones.put(index, adding);
        return true;
    }

    private ArrayList findLiberties(int row, int col) {
        //checking down
        ArrayList<Stone> neighbors = new ArrayList<>();
        ArrayList<Integer> nIndexes = new ArrayList<>();

        //checking down
        if (row > 0) {
            nIndexes.add(rcConvert(row - 1, col));
        }
        //checking up
        if (row < size - 1) {
            nIndexes.add(rcConvert(row + 1, col));
        }
        //checking left
        if (col > 0) {
            nIndexes.add(rcConvert(row, col - 1));
        }
        //checking right

        //checking left
        if (col < size - 1) {
            nIndexes.add(rcConvert(row, col + 1));
        }

        for (int index : nIndexes) {
            if (stones.containsKey(index)) {
                neighbors.add(stones.get(index));
            }
        }

        return neighbors;
    }

    public boolean mouseClick(Color color) {
        if (!StdDraw.isMousePressed()) {
            return false;
        }
        double dBetween = scaling / ((double) size);
        double x = StdDraw.mouseX() / dBetween;
        double y = StdDraw.mouseY() / dBetween;

        // convert to row i, column j
        int i = (int) Math.round(y);
        int j = (int) Math.round(x);
        System.out.println("(" + j + ", " + i + ")");

        if (!AddStone(color, i, j)) {
            System.out.println("Illegal Move. Try again");
            return false;
        }
        return true;
    }


    private boolean legalMove(Color c, int index) {
        if (stones.containsKey(index)) {
            return false;
        }
        //if its addition causes a
        return true; //not correct, placeholder until I create deeper logic.
    }

    private int rcConvert(int row, int col) {
        if (row < 0 || row > size - 1 || col < 0 || col > size - 1) {
            throw new java.lang.IndexOutOfBoundsException("out of bounds row/column");
        }
        return row * size + col;
    }

    public void draw() {
        double dBetween = scaling / ((double) size);
        int start = 0;
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setPenRadius(0.0025);

        //making the board
        for (int i = 0; i < size; i++) {
            StdDraw.line(start, 0, start, scaling - dBetween);
            StdDraw.line(0, start, scaling - dBetween, start);
            start += dBetween;
        }
        //drawing the stones
        for (Stone s : stones.values()) {
            s.draw(dBetween, dBetween * 0.4);
        }
    }
}