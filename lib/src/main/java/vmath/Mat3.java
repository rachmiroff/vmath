package vmath;

public class Mat3 {
    private final float[] m;

    public Mat3() {
        m = new float[] {
            1.0f, 0.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 0.0f, 1.0f
        };
    }

    public Mat3(
        float m00, float m01, float m02,
        float m10, float m11, float m12,
        float m20, float m21, float m22
    ) {
        var vals = new float[] {
            m00, m01, m02,
            m10, m11, m12,
            m20, m21, m22
        };

        for (float val : vals) {
            if (Float.isNaN(val)) {
                throw new ArithmeticException();
            }
        }

        m = vals;
    }

    public Mat3(float[] vals) {
        if (vals == null || vals.length != 9) {
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
        return m[i * 3 + j];
    }

    @Override
    public String toString() {
        String aString = "{";
        for(int row = 0; row < 3; row++) {
            if(row != 0) {
                aString += ", "; 
            }
            aString += "(";
            for(int col = 0; col < 3; col++) {
                if(col != 0 ){
                    aString+=", ";
                }
                aString += m[row * 3 + col];
            }
            aString += ")";
        }
        aString+="}";
        return aString;
    }
}
