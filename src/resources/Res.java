package resources;

import java.util.HashSet;
import java.util.Set;

/**
 * Res
 * @author Mark Banierink on 12-10-2017.
 */
public class Res {

    private Set<Pos> possibilities;
    private Grid resultGrid;

    public Res(Set<Pos> possibilities) {
        this.possibilities = new HashSet<>();
        resultGrid = new Grid();
        this.possibilities = possibilities;
    }

    public boolean isReady() {
        solve();
        return resultGrid.getSize() == resultGrid.getWidth() * resultGrid.getHeight();
    }

    private void solve() {
        // TODO solve this result set as far as possible
    }

    public Set<Res> getSubSets() {
        return null; // TODO - return multiple result sets for
    }

    private Set<Pos> getUniques() {
        return null; //TODO
    }

    private Set<Pos> getNoNeighbours() {
        return null; //TODO
    }

    private Set<Pos> getLeastOccurences() {
        return null; //TODO
    }

    public Grid getResult() {
        return resultGrid;
    }
//
//    public void addPossibilities(Set<Pos> possibilities) {
//        this.possibilities.addAll(possibilities);
//    }
//
//    public void addSolution(Set<Pos> solutions) {
//        this.solutions.addAll(solutions);
//    }
//
//    public void removePossibilities(Set<Pos> possibilities) {
//        this.possibilities.removeAll(possibilities);
//    }
//
//    public void removeSolutions(Set<Pos> solutions) {
//        this.solutions.removeAll(solutions);
//    }
//
//    public Set<Pos> getPossibilities() {
//        return possibilities;
//    }



}
