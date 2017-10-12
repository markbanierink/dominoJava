import java.util.HashSet;
import java.util.Set;
import resources.Bone;
import resources.Grid;
import resources.Loc;
import resources.Pos;

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

    private Grid grid;
    private Set<Pos> possibles;
    private Set<Pos> solutions;

    public static void main (String[] args) {
        new Domino();
    }

    private Domino() {
        initialise();
        play();
    }

    private void initialise() {
        grid = new Grid(gridArray);
    }

    private void play() {
        
    }

    public Set<Pos> getInitialPossibles() {
        Set<Pos> posSet = new HashSet<>();
        int height = gridArray.length;
        for (int i = 0; i < height-1; i++) {
            int width = gridArray[i].length;
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

    public int getMaxGridValue() {
        return grid.getMax();
    }

//    /**
//     * inner class representing a Result set
//     */
//    public class Res {
//
//        private Set<Pos> possibilities;
//        private Set<Pos> solutions;
//
//        public Res() {
//            possibilities = new HashSet<>();
//            solutions = new HashSet<>();
//        }
//
//        public void addPossibilities(Set<Pos> possibilities) {
//            this.possibilities.addAll(possibilities);
//        }
//
//        public void addSolution(Set<Pos> solutions) {
//            this.solutions.addAll(solutions);
//        }
//
//        public void removePossibilities(Set<Pos> possibilities) {
//            this.possibilities.removeAll(possibilities);
//        }
//
//        public void removeSolutions(Set<Pos> solutions) {
//            this.solutions.removeAll(solutions);
//        }
//
//        public Set<Pos> getPossibilities() {
//            return possibilities;
//        }
//
//        public Set<Pos> getSolutions() {
//            return solutions;
//        }
//
//    }
//
//    /**
//     * inner class representing a Tree with solutions
//     */
//    private class Tree {
//
//        private Res result;
//        private Tree tree;
//
//        public Tree(Res result) {
//            this.result = result;
//        }
//
//        public Res getResult() {
//            return result;
//        }
//
//        public Tree setTree(Tree tree) {
//            this.tree = tree;
//            return this;
//        }
//    }

}



























