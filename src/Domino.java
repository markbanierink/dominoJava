import java.util.HashSet;
import java.util.Set;
import resources.Bone;
import resources.Grid;
import resources.Location;
import resources.Possibility;
import resources.ResultSet;

/**
 * Domino
 * @author Mark Banierink on 12-10-2017.
 */
public class Domino {

    private static final int[][] gridArray = {{6, 6, 2, 6, 5, 2, 4, 1},
                                              {1, 3, 2, 0, 1, 0, 3, 4},
                                              {1, 3, 2, 4, 6, 6, 5, 4},
                                              {1, 0, 4, 3, 2, 1, 1, 2},
                                              {5, 1, 3, 6, 0, 4, 5, 5},
                                              {5, 5, 4, 0, 2, 6, 0, 3},
                                              {6, 0, 5, 3, 4, 2, 0, 3}};

    private Set<Grid> solutionGrids = new HashSet<>();
    private int height;
    private int width;

    private Domino() {
        Grid grid = new Grid(gridArray);
        Set<Possibility> possibles = getInitialPossibles(grid);
        play(new ResultSet(possibles));
        printSolutions(grid);
    }

    public static void main(String[] args) {
        new Domino();
    }

    private void play(ResultSet resultSet) {
        if (resultSet.isReady()) {
            solutionGrids.add(resultSet.getResult(height, width));
        }
        else {
            for (ResultSet subSet : resultSet.getSubResultSets()) {
                play(subSet);
            }
        }
    }

    private Set<Possibility> getInitialPossibles(Grid grid) {
        Set<Possibility> possibilitySet = new HashSet<>();
        height = grid.getHeight();
        for (int i = 0; i < height; i++) {
            width = grid.getWidth();
            for (int j = 0; j < width; j++) {
                int index = width * i + j;
                int hIndex = index + 1;
                int vIndex = index + width;
                if (j < width - 1) {
                    possibilitySet.add(new Possibility(new Location(index, hIndex), new Bone(grid.get(index), grid.get(hIndex))));
                }
                if (i < height - 1) {
                    possibilitySet.add(new Possibility(new Location(index, vIndex), new Bone(grid.get(index), grid.get(vIndex))));
                }
            }
        }
        return possibilitySet;
    }

    private void printSolutions(Grid grid) {
        StringBuilder string = new StringBuilder();
        string.append(createSymbolString("*", width * grid.getElementWidth())).append("\n");
        string.append("Grid:").append("\n");
        string.append(grid).append("\n");
        string.append(createSymbolString("*", width * grid.getElementWidth())).append("\n");
        string.append("Solutions:").append("\n");
        string.append(createSymbolString("=", width * grid.getElementWidth())).append("\n");
        for (Grid solutionGrid : solutionGrids) {
            string.append(solutionGrid).append("\n");
            string.append(createSymbolString("-", width * grid.getElementWidth())).append("\n");
        }
        string.append("Finished with ").append(solutionGrids.size()).append(" solutions.");
        System.out.println(string.toString());
    }

    private String createSymbolString(String symbol, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(symbol);
        }
        return stringBuilder.toString();
    }
}
