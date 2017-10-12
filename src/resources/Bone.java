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

    public int getBoneNum(int maxBoneNum) {
        int sum = 0;
        for (int i = maxBoneNum - b1; i < maxBoneNum; i++) {
            sum += i;
        }
        return sum + b2 + 1;
    }

}
