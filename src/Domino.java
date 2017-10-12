import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    public static void main (String[] args) {
        new Domino();
    }

    private Domino() {

    }

    private class Grid {

        private ArrayList<ArrayList<Integer>> gridArray;

        public Grid(int[][] gridArray) {
            
        }



    }

    public class Pos {

        private int[] locs;
        private int[] bone;

        public Pos(int[] locs, int[] bone) {
            this.locs = locs;
            this.bone = bone;
        }

        public int[] getLocs() {
            return locs;
        }

        public int[] getBone() {
            return bone;
        }

    }

    public class Res {

        private Set<Pos> possibilities;
        private Set<Pos> solutions;

        public Res() {
            possibilities = new HashSet<>();
            solutions = new HashSet<>();
        }

        public void addPossibilities(Set<Pos> possibilities) {
            this.possibilities.addAll(possibilities);
        }

        public void addSolution(Set<Pos> solutions) {
            this.solutions.addAll(solutions);
        }

        public void removePossibilities(Set<Pos> possibilities) {
            this.possibilities.removeAll(possibilities);
        }

        public void removeSolutions(Set<Pos> solutions) {
            this.solutions.removeAll(solutions);
        }

        public Set<Pos> getPossibilities() {
            return possibilities;
        }

        public Set<Pos> getSolutions() {
            return solutions;
        }

    }

    private class Tree {

        private Res result;
        private Tree tree;

        public Tree(Res result) {
            this.result = result;
        }

        public Res getResult() {
            return result;
        }

        public Tree setTree(Tree tree) {
            this.tree = tree;
            return this;
        }
    }

}



























