package vmath;

public class Mat2 {
    private float[] m;

    public Mat2() {
        m = new float[4];
    }

    public Mat2(float m00, float m01, float m10, float m11) {
        if (Float.isNaN(m00) || Float.isNaN(m01) || Float.isNaN(m10) || Float.isNaN(m11)) {
            throw new ArithmeticException();
        }
        m = new float[4];
        m[0] = m00;
        m[1] = m01;
        m[2] = m10;
        m[3] = m11;
    }

    public Mat2(float[] arr) {
        if (arr == null || arr.length != 4) {
            throw new IllegalArgumentException();
        }
        m = arr;
    }

    public float get(int i, int j) {
        return m[(i * 2) + j];
    }
}
