package resources;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Res
 * @author Mark Banierink on 12-10-2017.
 */
public class Res {

    private Set<Pos> possibilities;
    private Grid resultGrid;
    private Set<Res> subResultSets;

    public Res(Set<Pos> possibilities) {
        this.possibilities = new HashSet<>();
        resultGrid = new Grid();
        this.possibilities = possibilities;
        subResultSets = new HashSet<>();
    }

    private Res(Set<Pos> possibilities, Grid resultGrid) {
        this.possibilities = possibilities;
        this.resultGrid = resultGrid;
    }

    public boolean isReady() {
        solve();
        return resultGrid.getSize() == resultGrid.getWidth() * resultGrid.getHeight();
    }

    private void solve() {
        if (isSolvable()) {
            if (hasUniques()) {
                handleMove(getUniques(), possibilities);
            } else if (hasOneNeighbours()) {
                handleMove(getOneNeighbours(), possibilities);
            } else {
                handleBranching(sortOccurences(getOccurences()).firstEntry().getValue());
            }
        }
    }

    private void handleBranching(Set<Pos> leastOccuring) {
        for (Pos pos : leastOccuring) {
            Res subResult = createResultSet();
            Set<Pos> solutions = new HashSet<>();
            solutions.add(pos);
            subResult.handleMove(solutions, subResult.getPossibilities());
            subResultSets.add(subResult);
        }
    }

    private Res createResultSet() {
        Set<Pos> subPossibilities = new HashSet<>(possibilities);
        Grid grid = new Grid(new HashMap<>(resultGrid.getGridList()));
        return new Res(subPossibilities, grid);
    }

    private void handleMove(Set<Pos> solutions, Set<Pos> possibilities) {
        resultGrid.add(solutions);
        possibilities.removeAll(getNeighbours(solutions));
    }

    private Set<Pos> getNeighbours(Set<Pos> solutions) {
        Set<Pos> neighbours = new HashSet<>();
        for (Pos solution : solutions) {
            neighbours.addAll(getNeighbours(solution));
        }
        return neighbours;
    }

    private Set<Pos> getNeighbours(Pos solution) {
        Set<Pos> neighbours = new HashSet<>();
        for (Pos possibility : possibilities) {
            if (possibility.getLoc().isNeighbour(solution.getLoc())) {
                neighbours.add(possibility);
            }
        }
        return neighbours;
    }

    public Set<Res> getSubResultSets() {
        return subResultSets;
    }

    private boolean hasUniques() {
        return getUniques().size() > 0;
    }

    private Set<Pos> getUniques() {
        Set<Pos> uniques = new HashSet<>();
        for (Set<Pos> occurence : getOccurences().values()) {
            if (occurence.size() == 1) {
                uniques.addAll(occurence);
            }
        }
        return uniques;
    }

    private boolean isSolvable() {
        return !possibilities.isEmpty();
    }

    private Set<Pos> getPossibilities() {
        return possibilities;
    }

    private boolean hasOneNeighbours() {
        return getOneNeighbours().size() > 0;
    }

    private Set<Pos> getOneNeighbours() {
        Set<Pos> oneNeighbour = new HashSet<>();
        for (Pos possibility : possibilities) {
            if (getNeighbours(possibility).size() <= 1) {
                oneNeighbour.add(possibility);
            }
        }
        return oneNeighbour;
    }

    private TreeMap<Integer, Set<Pos>> sortOccurences(Map<Integer, Set<Pos>> occurences) {
        TreeMap<Integer, Set<Pos>> sorted = new TreeMap<>();
        for (Set<Pos> occurence : occurences.values()) {
            sorted.put(occurence.size(), occurence);
        }
        return sorted;
    }

    private Map<Integer, Set<Pos>> getOccurences() {
        Map<Integer, Set<Pos>> occurences = new HashMap<>();
        for (Pos possibility : possibilities) {
            if (occurences.containsKey(possibility.getBoneNum())) {
                occurences.get(possibility.getBoneNum()).add(possibility);
            } else {
                Set<Pos> posses = new HashSet<>();
                posses.add(possibility);
                occurences.put(possibility.getBoneNum(), posses);
            }
        }
        return occurences;
    }

    public Grid getResult() {
        return resultGrid;
    }

}


















