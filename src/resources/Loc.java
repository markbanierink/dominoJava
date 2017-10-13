package resources;

/**
 * resources.Loc
 * @author Mark Banierink on 12-10-2017.
 */
public class Loc {

    private int l1;
    private int l2;

    public Loc(int val1, int val2) {
        this.l1 = val1;
        this.l2 = val2;
    }

    public int getL1() {
        return l1;
    }

    public int getL2() {
        return l2;
    }

    public boolean isNeighbour(Loc loc) {
        return l1 == loc.getL1() || l1 == loc.getL2() || l2 == loc.getL1() || l2 == loc.getL2();
    }

}
