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

    public Bone getBone() {
        return bone;
    }

    public int getBoneValue(int maxBoneNum) {
        return bone.getBoneNum(maxBoneNum);
    }
}
