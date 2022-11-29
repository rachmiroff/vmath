package vmath;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Mat4Test {
    @Test
    void creates_new_identity_matrix() {
        var m = new Mat4();

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 0.0f);
        assertEquals(m.get(0, 2), 0.0f);
        assertEquals(m.get(0, 3), 0.0f);

        assertEquals(m.get(1, 0), 0.0f);
        assertEquals(m.get(1, 1), 1.0f);
        assertEquals(m.get(1, 2), 0.0f);
        assertEquals(m.get(1, 3), 0.0f);

        assertEquals(m.get(2, 0), 0.0f);
        assertEquals(m.get(2, 1), 0.0f);
        assertEquals(m.get(2, 2), 1.0f);
        assertEquals(m.get(2, 3), 0.0f);

        assertEquals(m.get(3, 0), 0.0f);
        assertEquals(m.get(3, 1), 0.0f);
        assertEquals(m.get(3, 2), 0.0f);
        assertEquals(m.get(3, 3), 1.0f);
    }

    @Test
    void creates_new_matrix_with_args() {
        var m = new Mat4(
            1.0f,  2.0f,  3.0f,  4.0f,
            5.0f,  6.0f,  7.0f,  8.0f,
            9.0f,  10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        );

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);
        assertEquals(m.get(0, 2), 3.0f);
        assertEquals(m.get(0, 3), 4.0f);

        assertEquals(m.get(1, 0), 5.0f);
        assertEquals(m.get(1, 1), 6.0f);
        assertEquals(m.get(1, 2), 7.0f);
        assertEquals(m.get(1, 3), 8.0f);

        assertEquals(m.get(2, 0), 9.0f);
        assertEquals(m.get(2, 1), 10.0f);
        assertEquals(m.get(2, 2), 11.0f);
        assertEquals(m.get(2, 3), 12.0f);

        assertEquals(m.get(3, 0), 13.0f);
        assertEquals(m.get(3, 1), 14.0f);
        assertEquals(m.get(3, 2), 15.0f);
        assertEquals(m.get(3, 3), 16.0f);
    }

    @Test
    void fails_to_create_new_nan_matrix() {
        for (int i = 0; i < 16; i++) {
            var vals = new float[16];
            vals[i] = Float.NaN;
            assertThrows(ArithmeticException.class, () -> new Mat4(
                vals[0],  vals[1],  vals[2],  vals[3],
                vals[4],  vals[5],  vals[6],  vals[7],
                vals[8],  vals[9],  vals[10], vals[11],
                vals[12], vals[13], vals[14], vals[15]
            ));
        }
    }

    @Test
    void creates_new_matrix_with_array() {
        var vals = new float[] {
            1.0f,  2.0f,  3.0f,  4.0f,
            5.0f,  6.0f,  7.0f,  8.0f,
            9.0f,  10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        };
        var m = new Mat4(vals);

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);
        assertEquals(m.get(0, 2), 3.0f);
        assertEquals(m.get(0, 3), 4.0f);

        assertEquals(m.get(1, 0), 5.0f);
        assertEquals(m.get(1, 1), 6.0f);
        assertEquals(m.get(1, 2), 7.0f);
        assertEquals(m.get(1, 3), 8.0f);

        assertEquals(m.get(2, 0), 9.0f);
        assertEquals(m.get(2, 1), 10.0f);
        assertEquals(m.get(2, 2), 11.0f);
        assertEquals(m.get(2, 3), 12.0f);

        assertEquals(m.get(3, 0), 13.0f);
        assertEquals(m.get(3, 1), 14.0f);
        assertEquals(m.get(3, 2), 15.0f);
        assertEquals(m.get(3, 3), 16.0f);
    }

    @Test
    void fails_to_create_new_matrix_with_null_instead_of_array() {
        float[] vals = null;
        assertThrows(IllegalArgumentException.class, () -> new Mat4(vals));
    }

    @Test
    void fails_to_create_new_matrix_with_array_of_wrong_size() {
        var vals = new float[] {
            1.0f,  2.0f,  3.0f,  4.0f,
            5.0f,  6.0f,  7.0f,  8.0f,
            9.0f,  10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f, 17.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat4(vals));
    }

    @Test
    void fails_to_create_new_matrix_with_nan_array() {
        for (int i = 0; i < 16; i++) {
            var vals = new float[16];
            vals[i] = Float.NaN;
            assertThrows(ArithmeticException.class, () -> new Mat4(vals));
        }
    }

    @Test
    void multiplication_of_two_matrices() {
        var val1 = new Mat4(
            1.0f,  2.0f,  3.0f,  4.0f,
            5.0f,  6.0f,  7.0f,  8.0f,
            9.0f,  10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        );
        var val2 = new Mat4(
            1.0f,  2.0f,  3.0f,  4.0f,
            5.0f,  6.0f,  7.0f,  8.0f,
            9.0f,  10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        );
        var val3 = new Mat4(
            1.0f,  2.0f,  3.0f,  4.0f,
            5.0f,  6.0f,  7.0f,  8.0f,
            9.0f,  10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        );

        var m = val1.mul(val2);

        assertEquals(m.get(0, 0), 38.0f);
        assertEquals(m.get(0, 1), 44.0f);
        assertEquals(m.get(0, 2), 50.0f);
        assertEquals(m.get(0, 3), 56.0f);

        assertEquals(m.get(1, 0), 98.0f);
        assertEquals(m.get(1, 1), 116.0f);
        assertEquals(m.get(1, 2), 134.0f);
        assertEquals(m.get(1, 3), 152.0f);

        assertEquals(m.get(2, 0), 158.0f);
        assertEquals(m.get(2, 1), 188.0f);
        assertEquals(m.get(2, 2), 218.0f);
        assertEquals(m.get(2, 3), 248.0f);

        assertEquals(m.get(3, 0), 278.0f);
        assertEquals(m.get(3, 1), 320.0f);
        assertEquals(m.get(3, 2), 362.0f);
        assertEquals(m.get(3, 3), 404.0f);

        var m1 = val1.mul(val3);

        assertEquals(m1.get(0, 0), 38.0f);
        assertEquals(m1.get(0, 1), 44.0f);
        assertEquals(m1.get(0, 2), 50.0f);
        assertEquals(m1.get(0, 3), 56.0f);

        assertEquals(m1.get(1, 0), 98.0f);
        assertEquals(m1.get(1, 1), 116.0f);
        assertEquals(m1.get(1, 2), 134.0f);
        assertEquals(m1.get(1, 3), 152.0f);

        assertEquals(m1.get(2, 0), 158.0f);
        assertEquals(m1.get(2, 1), 188.0f);
        assertEquals(m1.get(2, 2), 218.0f);
        assertEquals(m1.get(2, 3), 248.0f);

        assertEquals(m.get(3, 0), 278.0f);
        assertEquals(m.get(3, 1), 320.0f);
        assertEquals(m.get(3, 2), 362.0f);
        assertEquals(m.get(3, 3), 404.0f);

    }
}
