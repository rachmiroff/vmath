package vmath;

public class Mat4 {
    private final float[] m;

    public Mat4() {
        m = new float[] {
            1.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 1.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 1.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 1.0f
        };
    }

    public Mat4(
        float m00, float m01, float m02, float m03,
        float m10, float m11, float m12, float m13,
        float m20, float m21, float m22, float m23,
        float m30, float m31, float m32, float m33
    ) {
        var vals = new float[] {
            m00, m01, m02, m03,
            m10, m11, m12, m13,
            m20, m21, m22, m23,
            m30, m31, m32, m33
        };

        for (float val : vals) {
            if (Float.isNaN(val)) {
                throw new ArithmeticException();
            }
        }

        m = vals;
    }

    public Mat4(float[] vals) {
        if (vals == null || vals.length != 16) {
            throw new IllegalArgumentException();
        }

        for (float val : vals) {
            if (Float.isNaN(val)) {
                throw new ArithmeticException();
            }
        }

        m = vals.clone();
    }

    public float get(int i, int j) {
        return m[i * 4 + j];
    }

    public Mat4 mul(Mat4 other){
        return new Mat4(
            (m[0 * 4 + 0] * other.m[0 * 4 + 0]) + (m[0 * 4 + 1] * other.m[1 * 4 + 0]) + (m[0 * 4 + 2] * other.m[2 * 4 + 0]),
            (m[0 * 4 + 0] * other.m[0 * 4 + 1]) + (m[0 * 4 + 1] * other.m[1 * 4 + 1]) + (m[0 * 4 + 2] * other.m[2 * 4 + 1]),
            (m[0 * 4 + 0] * other.m[0 * 4 + 2]) + (m[0 * 4 + 1] * other.m[1 * 4 + 2]) + (m[0 * 4 + 2] * other.m[2 * 4 + 2]),
            (m[0 * 4 + 0] * other.m[0 * 4 + 3]) + (m[0 * 4 + 1] * other.m[1 * 4 + 3]) + (m[0 * 4 + 2] * other.m[2 * 4 + 3]),

            (m[1 * 4 + 0] * other.m[0 * 4 + 0]) + (m[1 * 4 + 1] * other.m[1 * 4 + 0]) + (m[1 * 4 + 2] * other.m[2 * 4 + 0]),
            (m[1 * 4 + 0] * other.m[0 * 4 + 1]) + (m[1 * 4 + 1] * other.m[1 * 4 + 1]) + (m[1 * 4 + 2] * other.m[2 * 4 + 1]),
            (m[1 * 4 + 0] * other.m[0 * 4 + 2]) + (m[1 * 4 + 1] * other.m[1 * 4 + 2]) + (m[1 * 4 + 2] * other.m[2 * 4 + 2]),
            (m[1 * 4 + 0] * other.m[0 * 4 + 3]) + (m[1 * 4 + 1] * other.m[1 * 4 + 3]) + (m[1 * 4 + 2] * other.m[2 * 4 + 3]),

            (m[2 * 4 + 0] * other.m[0 * 4 + 0]) + (m[2 * 4 + 1] * other.m[1 * 4 + 0]) + (m[2 * 4 + 2] * other.m[2 * 4 + 0]),
            (m[2 * 4 + 0] * other.m[0 * 4 + 1]) + (m[2 * 4 + 1] * other.m[1 * 4 + 1]) + (m[2 * 4 + 2] * other.m[2 * 4 + 1]),
            (m[2 * 4 + 0] * other.m[0 * 4 + 2]) + (m[2 * 4 + 1] * other.m[1 * 4 + 2]) + (m[2 * 4 + 2] * other.m[2 * 4 + 2]),
            (m[2 * 4 + 0] * other.m[0 * 4 + 3]) + (m[2 * 4 + 1] * other.m[1 * 4 + 3]) + (m[2 * 4 + 2] * other.m[2 * 4 + 3]),

            (m[3 * 4 + 0] * other.m[0 * 4 + 0]) + (m[3 * 4 + 1] * other.m[1 * 4 + 0]) + (m[3 * 4 + 2] * other.m[3 * 4 + 0]),
            (m[3 * 4 + 0] * other.m[0 * 4 + 1]) + (m[3 * 4 + 1] * other.m[1 * 4 + 1]) + (m[3 * 4 + 2] * other.m[3 * 4 + 1]),
            (m[3 * 4 + 0] * other.m[0 * 4 + 2]) + (m[3 * 4 + 1] * other.m[1 * 4 + 2]) + (m[3 * 4 + 2] * other.m[3 * 4 + 2]),
            (m[3 * 4 + 0] * other.m[0 * 4 + 3]) + (m[3 * 4 + 1] * other.m[1 * 4 + 3]) + (m[3 * 4 + 2] * other.m[3 * 4 + 3])

        );
    }
}