package resources;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * resources.Grid
 * @author Mark Banierink on 12-10-2017.
 */
public class Grid {

    private static final String FORMAT = " %2d ";

    private Map<Integer, Integer> gridList = new HashMap<>();
    private int height;
    private int width;

    public Grid() {

    }

    public Grid(Map<Integer,Integer> gridList) {
        this.gridList = gridList;
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

    public Map<Integer, Integer> getGridList() {
        return gridList;
    }

    public void add(Set<Pos> solutions) {
        for (Pos pos : solutions) {
            int boneNum = pos.getBoneNum();
            gridList.put(pos.getLoc().getL1(), boneNum);
            gridList.put(pos.getLoc().getL2(), boneNum);
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

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < height; i++) {
            string.append("\n");
            for (int j = 0; j < width; j++) {
                string.append(String.format(FORMAT, get(width*i + j)));
            }
            string.append("\n\n");
        }
        return string.toString();
    }

    public int getElementWidth() {
        return FORMAT.length();
    }
}
