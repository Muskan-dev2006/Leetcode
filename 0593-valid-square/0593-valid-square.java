class Solution {

    public int distance(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];

        return dx * dx + dy * dy;
    }

    public boolean validSquare(int[] p1, int[] p2,
                               int[] p3, int[] p4) {

        int[] d = new int[6];

        d[0] = distance(p1, p2);
        d[1] = distance(p1, p3);
        d[2] = distance(p1, p4);
        d[3] = distance(p2, p3);
        d[4] = distance(p2, p4);
        d[5] = distance(p3, p4);

        Arrays.sort(d);

       
        if (d[0] == 0) {
            return false;
        }


        if (d[0] != d[1] ||
            d[1] != d[2] ||
            d[2] != d[3]) {
            return false;
        }

        if (d[4] != d[5]) {
            return false;
        }


        return d[4] == 2 * d[0];
    }
}