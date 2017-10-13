package resources;

/**
 * Location
 * @author Mark Banierink on 12-10-2017.
 */
public class Location {

    private int l1;
    private int l2;

    public Location(int val1, int val2) {
        this.l1 = val1;
        this.l2 = val2;
    }

    public int getL1() {
        return l1;
    }

    public int getL2() {
        return l2;
    }

    public boolean isNeighbour(Location location) {
        return l1 == location.getL1() || l1 == location.getL2() || l2 == location.getL1() || l2 == location.getL2();
    }
}
