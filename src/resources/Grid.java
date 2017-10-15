package resources;

import java.util.Set;
import java.util.TreeMap;

/**
 * Grid
 * @author Mark Banierink on 12-10-2017.
 */
public class Grid {

    private static final String FORMAT = " %2d ";

    private TreeMap<Integer, Integer> gridList = new TreeMap<>();
    private int height;
    private int width;

    public Grid(Set<Possibility> solutions, int height, int width) {
        this.height = height;
        this.width = width;
        add(solutions);
    }

    public Grid(int[][] gridArray) {
        height = gridArray.length;
        for (int i = 0; i < height; i++) {
            width = gridArray[i].length;
            for (int j = 0; j < width; j++) {
                gridList.put(width * i + j, gridArray[i][j]);
            }
        }
    }

    private void add(Set<Possibility> solutions) {
        for (Possibility possibility : solutions) {
            int boneNum = possibility.getBoneNum();
            gridList.put(possibility.getLocation().getL1(), boneNum);
            gridList.put(possibility.getLocation().getL2(), boneNum);
        }
    }

    public int get(int index) {
        return gridList.get(index);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < height; i++) {
            string.append("\n");
            for (int j = 0; j < width; j++) {
                string.append(String.format(FORMAT, get(width * i + j)));
            }
            string.append("\n\n");
        }
        return string.toString();
    }

    public int getElementWidth() {
        return String.format(FORMAT, 1).length();
    }
}
