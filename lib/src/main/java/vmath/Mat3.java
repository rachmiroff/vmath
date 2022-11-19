package vmath;

public class Mat3 {
    private float[] m;

    public Mat3() {
        m = new float[9];
    }

    public Mat3(
            float m00, float m01, float m02,
            float m10, float m11, float m12,
            float m20, float m21, float m22) {
    }

    public Mat3(float arr[]) {
    }

    public float get(int i, int j) {
        return m[i * 3 + j];
    }
}
