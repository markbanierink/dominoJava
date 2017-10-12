package resources;

/**
 * resources.Bone
 * @author Mark Banierink on 12-10-2017.
 */
public class Bone {

    private int b1;
    private int b2;

    public Bone(int val1, int val2) {
        if (val1 <= val2) {
            this.b1 = val1;
            this.b2 = val2;
        } else {
            this.b1 = val2;
            this.b2 = val1;
        }
    }

    public int getBoneValue() {
        return 0; // TODO boneNum (b1, b2) = sum [boneNums-b1..boneNums-1] + b2 + 1
    }

}
