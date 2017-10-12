import java.util.HashSet;
import java.util.Set;
import resources.Bone;
import resources.Grid;
import resources.Loc;
import resources.Pos;
import resources.Res;

/**
 * Domino
 * @author Mark Banierink on 12-10-2017.
 */
public class Domino {

    private static final int[][] gridArray = {{6,6,2,6,5,2,4,1},
                                              {1,3,2,0,1,0,3,4},
                                              {1,3,2,4,6,6,5,4},
                                              {1,0,4,3,2,1,1,2},
                                              {5,1,3,6,0,4,5,5},
                                              {5,5,4,0,2,6,0,3},
                                              {6,0,5,3,4,2,0,3}};

    private Set<Grid> solutions = new HashSet<>();

    public static void main (String[] args) {
        new Domino();
    }

    private Domino() {
        Grid grid = new Grid(gridArray);
        Set<Pos> possibles = getInitialPossibles(grid);
        play(new Res(possibles));
        printSolutions(grid);
    }

    private void play(Res resultSet) {
        if (resultSet.isReady()) {
            solutions.add(resultSet.getResult());
        } else {
            for (Res subSet : resultSet.getSubSets()) {
                play(subSet);
            }
        }
    }

    private Set<Pos> getInitialPossibles(Grid grid) {
        Set<Pos> posSet = new HashSet<>();
        for (int i = 0; i < grid.getHeight()-1; i++) {
            int width = grid.getWidth();
            for (int j = 0; j < width-1; j++) {
                int index = width*i+j;
                int hIndex = index + 1;
                int vIndex = index + width;
                posSet.add(new Pos(new Loc(index, hIndex), new Bone(grid.get(index), grid.get(hIndex))));
                posSet.add(new Pos(new Loc(index, vIndex), new Bone(grid.get(index), grid.get(vIndex))));
            }
        }
        return posSet;
    }

    private void printSolutions(Grid grid) {
        System.out.println("[*]"); // TODO - determine width
        System.out.println("Grid:");
        System.out.println("[*]"); // TODO - determine width
        grid.printGrid();
        System.out.println("Solutions:");
        System.out.println("[=]"); // TODO - determine width
        for (Grid solution : solutions) {
            solution.printGrid();
            System.out.println("[-]"); // TODO - determine width
        }
        System.out.println("Finished with " + solutions.size() + " solutions.");
    }

}