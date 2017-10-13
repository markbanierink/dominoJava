package resources;

/**
 * resources.Pos
 * @author Mark Banierink on 12-10-2017.
 */
public class Pos {

    private Loc loc;
    private Bone bone;

    public Pos(Loc loc, Bone bone) {
        this.loc = loc;
        this.bone = bone;
    }

    public Loc getLoc() {
        return loc;
    }

    public int getBoneNum() {
        return bone.getBoneNum();
    }
}
