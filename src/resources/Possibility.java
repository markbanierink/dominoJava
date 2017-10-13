package resources;

/**
 * Possibility
 * @author Mark Banierink on 12-10-2017.
 */
public class Possibility {

    private Location location;
    private Bone bone;

    public Possibility(Location location, Bone bone) {
        this.location = location;
        this.bone = bone;
    }

    public Location getLocation() {
        return location;
    }

    public int getBoneNum() {
        return bone.getBoneNum();
    }
}
