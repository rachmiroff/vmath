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
    void converts_identity_mat_to_string() {
        var m = new Mat4();
        assertEquals(m.toString(), "{(1.0, 0.0, 0.0, 0.0), (0.0, 1.0, 0.0, 0.0), (0.0, 0.0, 1.0, 0.0), (0.0, 0.0, 0.0, 1.0)}");
    }

    @Test
    void converts_int_param_mat_to_string() {
        var vals = new float[] {
            1.0f,  2.0f,  3.0f,  4.0f,
            5.0f,  6.0f,  7.0f,  8.0f,
            9.0f,  10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        };
        var v2 = new Mat4(vals);
        assertEquals(v2.toString(), "{(1.0, 2.0, 3.0, 4.0), (5.0, 6.0, 7.0, 8.0), (9.0, 10.0, 11.0, 12.0), (13.0, 14.0, 15.0, 16.0)}");
    }

    @Test
    void converts_real_param_mat_to_string() {
        var vals = new float[] {
            0.5f,     0.25f,     0.125f,     0.0625f,
            0.03125f, 0.015625f, 0.0078125f, 0.00390625f,
            0.6f,     0.36f,     0.216f,     0.1296f,
            0.7776f,  0.046656f, 0.0279936f, 0.01679616f
        };
        var v3 = new Mat4(vals);
        assertEquals(v3.toString(), "{(0.5, 0.25, 0.125, 0.0625), (0.03125, 0.015625, 0.0078125, 0.00390625), (0.6, 0.36, 0.216, 0.1296), (0.7776, 0.046656, 0.0279936, 0.01679616)}");
    }
}
