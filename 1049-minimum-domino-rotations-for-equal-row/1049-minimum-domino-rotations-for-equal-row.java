class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rotations = check(tops[0], tops, bottoms);
        if (rotations != -1 || tops[0] == bottoms[0]) {
            return rotations;
        }
        return check(bottoms[0], tops, bottoms);
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int rotationTop = 0;
        int rotationBottom = 0;

        for (int i = 0; i < tops.length; i++) {
            // If neither side has the target number, it's impossible
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }
            // If top is not target, we need to rotate this domino to bring target on top
            if (tops[i] != target) {
                rotationTop++;
            }
            // If bottom is not target, we need to rotate this domino to bring target on bottom
            if (bottoms[i] != target) {
                rotationBottom++;
            }
        }
        return Math.min(rotationTop, rotationBottom);
    }
}
