package vmath;

public class Mat2 {
    private float[] m;

    public Mat2() {
        m = new float[4];
    }

    public float get(int i, int j) {
        return m[(i * 2) + j];
    }
}
