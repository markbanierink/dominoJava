package resources;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * ResultSet
 * @author Mark Banierink on 12-10-2017.
 */
public class ResultSet {

    private Set<Possibility> possibilities = new HashSet<>();
    private Set<Possibility> solutions = new HashSet<>();
    private Set<ResultSet> subResultSets = new HashSet<>();

    public ResultSet(Set<Possibility> possibilities) {
        this.possibilities.addAll(possibilities);
        subResultSets = new HashSet<>();
    }

    private ResultSet(Set<Possibility> possibilities, Set<Possibility> solutions) {
        this.possibilities = possibilities;
        this.solutions = solutions;
    }

    public boolean isReady() {
        solve();
        return solutions.size() == 28; // TODO - make more dynamic
    }

    private void solve() {
        if (isSolvable()) {
            if (hasUniques()) {
                handleMoves(getUniques(), possibilities);
                solve();
            }
            else if (hasOneNeighbours()) {
                handleMoves(getOneNeighbours(), possibilities);
                solve();
            }
            else {
                handleBranching(sortOccurences(getOccurences()).firstEntry().getValue());
            }
        }
    }

    private void handleBranching(Set<Possibility> leastOccuring) {
        for (Possibility possibility : leastOccuring) {
            ResultSet subResult = createResultSet();
            Set<Possibility> solutions = new HashSet<>();
            solutions.add(possibility);
            subResult.handleMoves(solutions, subResult.getPossibilities());
            subResultSets.add(subResult);
        }
    }

    private ResultSet createResultSet() {
        Set<Possibility> subPossibilities = new HashSet<>(possibilities);
        Set<Possibility> subSolutions = new HashSet<>(solutions);
        return new ResultSet(subPossibilities, subSolutions);
    }

    private void handleMoves(Set<Possibility> solutions, Set<Possibility> possibilities) {
        this.solutions.addAll(solutions);
        possibilities.removeAll(getSame(solutions));
        possibilities.removeAll(getNeighbours(solutions));
    }

    private Set<Possibility> getSame(Set<Possibility> solutions) {
        Set<Possibility> same = new HashSet<>();
        for (Possibility solution : solutions) {
            same.addAll(getSame(solution));
        }
        return same;
    }

    private Set<Possibility> getSame(Possibility solution) {
        Set<Possibility> same = new HashSet<>();
        for (Possibility possibility : possibilities) {
            if (solution.getBoneNum() == possibility.getBoneNum()) {
                same.add(possibility);
            }
        }
        return same;
    }

    private Set<Possibility> getNeighbours(Set<Possibility> solutions) {
        Set<Possibility> neighbours = new HashSet<>();
        for (Possibility solution : solutions) {
            neighbours.addAll(getNeighbours(solution));
        }
        return neighbours;
    }

    private Set<Possibility> getNeighbours(Possibility solution) {
        Set<Possibility> neighbours = new HashSet<>();
        for (Possibility possibility : possibilities) {
            if (possibility.getLocation().isNeighbour(solution.getLocation())) {
                neighbours.add(possibility);
            }
        }
        return neighbours;
    }

    public Set<ResultSet> getSubResultSets() {
        return subResultSets;
    }

    private boolean hasUniques() {
        return getUniques().size() > 0;
    }

    private Set<Possibility> getUniques() {
        Set<Possibility> uniques = new HashSet<>();
        for (Set<Possibility> occurence : getOccurences().values()) {
            if (occurence.size() == 1) {
                uniques.addAll(occurence);
            }
        }
        return uniques;
    }

    private boolean isSolvable() {
        return !possibilities.isEmpty();
    }

    private Set<Possibility> getPossibilities() {
        return possibilities;
    }

    private boolean hasOneNeighbours() {
        return getOneNeighbours().size() > 0;
    }

    private Set<Possibility> getOneNeighbours() {
        Set<Possibility> oneNeighbour = new HashSet<>();
        for (Possibility possibility : possibilities) {
            if (getNeighbours(possibility).size() <= 1) {
                oneNeighbour.add(possibility);
            }
        }
        return oneNeighbour;
    }

    private TreeMap<Integer, Set<Possibility>> sortOccurences(Map<Integer, Set<Possibility>> occurences) {
        TreeMap<Integer, Set<Possibility>> sorted = new TreeMap<>();
        for (Set<Possibility> occurence : occurences.values()) {
            sorted.put(occurence.size(), occurence);
        }
        return sorted;
    }

    private Map<Integer, Set<Possibility>> getOccurences() {
        Map<Integer, Set<Possibility>> occurences = new HashMap<>();
        for (Possibility possibility : possibilities) {
            if (occurences.containsKey(possibility.getBoneNum())) {
                occurences.get(possibility.getBoneNum()).add(possibility);
            }
            else {
                Set<Possibility> posses = new HashSet<>();
                posses.add(possibility);
                occurences.put(possibility.getBoneNum(), posses);
            }
        }
        return occurences;
    }

    public Grid getResult(int height, int width) {
        return new Grid(solutions, height, width);
    }
}
