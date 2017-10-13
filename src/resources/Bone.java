package resources;

/**
 * Bone
 * @author Mark Banierink on 12-10-2017.
 */
public class Bone {

    private static final int BONE_NUMS = 7;

    private int b1;
    private int b2;

    public Bone(int val1, int val2) {
        if (val1 <= val2) {
            this.b1 = val1;
            this.b2 = val2;
        }
        else {
            this.b1 = val2;
            this.b2 = val1;
        }
    }

    public int getBoneNum() {
        int sum = 0;
        for (int i = BONE_NUMS - b1; i < BONE_NUMS; i++) {
            sum += i;
        }
        return sum + b2 + 1;
    }
}
