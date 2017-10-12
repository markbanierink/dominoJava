package resources;

import java.util.ArrayList;
import java.util.Set;

/**
 * resources.Grid
 * @author Mark Banierink on 12-10-2017.
 */
public class Grid {
    private ArrayList<Integer> gridList;

    public Grid(int[][] gridArray) {
        int height = gridArray.length;
        for (int i = 0; i < height; i++) {
            int width = gridArray[i].length;
            for (int j = 0; j < width; j++) {
                gridList.add(width*i+j, gridArray[i][j]);
            }
        }
    }

    public int get(int index) {
        return gridList.get(index);
    }

    public Grid(Set<Pos> solutions) {
        //TODO
    }

    public void printGrid() {
        //TODO
    }

    public int getMax() {
        return 0; // TODO
    }
}
