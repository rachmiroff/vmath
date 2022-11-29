package vmath;

public class Mat2 {
    private final float[] m;

    public Mat2() {
        m = new float[] {
            1.0f, 0.0f,
            0.0f, 1.0f
        };
    }

    public Mat2(float m00, float m01, float m10, float m11) {
        var vals = new float[] {
            m00, m01,
            m10, m11
        };

        for (float val : vals) {
            if (Float.isNaN(val)) {
                throw new ArithmeticException();
            }
        }

        m = vals;
    }

    public Mat2(float[] vals) {
        if (vals == null || vals.length != 4) {
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
        return m[i * 2 + j];
    }

    public Vec2 mul(Vec2 other){
        return new Vec2(
            get(0,0) * other.x() + get(0,1) * other.y(),
            get(1,0) * other.x() + get(1,1) * other.y()
        );
    }
}
