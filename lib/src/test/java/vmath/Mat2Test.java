package vmath;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Mat2Test {
    @Test
    void creates_new_identity_matrix() {
        var m = new Mat2();

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 0.0f);

        assertEquals(m.get(1, 0), 0.0f);
        assertEquals(m.get(1, 1), 1.0f);
    }

    @Test
    void creates_new_matrix_with_args() {
        var m = new Mat2(
            1.0f, 2.0f,
            3.0f, 4.0f
        );

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);

        assertEquals(m.get(1, 0), 3.0f);
        assertEquals(m.get(1, 1), 4.0f);
    }

    @Test
    void fails_to_create_new_nan_matrix() {
        assertThrows(ArithmeticException.class, () -> new Mat2(Float.NaN, 0.0f, 0.0f, 0.0f));
        assertThrows(ArithmeticException.class, () -> new Mat2(0.0f, Float.NaN, 0.0f, 0.0f));
        assertThrows(ArithmeticException.class, () -> new Mat2(0.0f, 0.0f, Float.NaN, 0.0f));
        assertThrows(ArithmeticException.class, () -> new Mat2(0.0f, 0.0f, 0.0f, Float.NaN));
    }

    @Test
    void creates_new_matrix_with_array() {
        var vals = new float[] {
            1.0f, 2.0f,
            3.0f, 4.0f
        };
        var m = new Mat2(vals);

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);

        assertEquals(m.get(1, 0), 3.0f);
        assertEquals(m.get(1, 1), 4.0f);
    }

    @Test
    void fails_to_create_new_matrix_with_null_instead_of_array() {
        float[] vals = null;
        assertThrows(IllegalArgumentException.class, () -> new Mat2(vals));
    }

    @Test
    void fails_to_create_new_matrix_with_array_of_wrong_size() {
        var vals = new float[] {
            1.0f, 2.0f,
            3.0f, 4.0f, 5.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat2(vals));
    }

    @Test
    void fails_to_create_new_matrix_with_nan_array() {
        assertThrows(ArithmeticException.class, () -> new Mat2(new float[] { Float.NaN, 0.0f, 0.0f, 0.0f }));
        assertThrows(ArithmeticException.class, () -> new Mat2(new float[] { 0.0f, Float.NaN, 0.0f, 0.0f }));
        assertThrows(ArithmeticException.class, () -> new Mat2(new float[] { 0.0f, 0.0f, Float.NaN, 0.0f }));
        assertThrows(ArithmeticException.class, () -> new Mat2(new float[] { 0.0f, 0.0f, 0.0f, Float.NaN }));
    }

    @Test
    void multiplies_vector_by_matrix() {
        Vec2 v1 = new Vec2(1.0f,2.0f);
        Mat2 m1 = new Mat2(
                1.0f, 2.0f,
                3.0f, 4.0f
        );

        Vec2 prod1 = m1.mul(v1);

        assertEquals(prod1.x(), 5.0f);
        assertEquals(prod1.y(), 11.0f);


        Vec2 v2 = new Vec2(1.0f,0.0f);
        Mat2 m2 = new Mat2(
                5.0f, 6.0f,
                7.0f, 8.0f
        );

        Vec2 prod2 = m2.mul(v2);

        assertEquals(prod2.x(), 5.0f);
        assertEquals(prod2.y(), 7.0f);
    }
}
