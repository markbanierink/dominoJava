package resources;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * resources.Grid
 * @author Mark Banierink on 12-10-2017.
 */
public class Grid {

    private Map<Integer, Integer> gridList = new HashMap<>();
    private int height;
    private int width;

    public Grid() {

    }

    public Grid(Set<Pos> solutions) {
        //TODO
    }

    public Grid(int[][] gridArray) {
        height = gridArray.length;
        for (int i = 0; i < height; i++) {
            width = gridArray[i].length;
            for (int j = 0; j < width; j++) {
                gridList.put(width*i+j, gridArray[i][j]);
            }
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

    public int getSize() {
        return gridList.size();
    }

    public void printGrid() {
        //TODO - printf
    }

    public int getMax() {
        return 0; // TODO
    }
}
