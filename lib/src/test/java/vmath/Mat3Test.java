package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Mat3Test {
    @Test
    void creates_new_identity_matrix() {
        var m = new Mat3();

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 0.0f);
        assertEquals(m.get(0, 2), 0.0f);

        assertEquals(m.get(1, 0), 0.0f);
        assertEquals(m.get(1, 1), 1.0f);
        assertEquals(m.get(1, 2), 0.0f);

        assertEquals(m.get(2, 0), 0.0f);
        assertEquals(m.get(2, 1), 0.0f);
        assertEquals(m.get(2, 2), 1.0f);
    }

    @Test
    void creates_new_matrix_with_args() {
        var m = new Mat3(
            1.0f,  2.0f,  3.0f,
            4.0f,  5.0f,  6.0f,
            7.0f,  8.0f,  9.0f
        );

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);
        assertEquals(m.get(0, 2), 3.0f);

        assertEquals(m.get(1, 0), 4.0f);
        assertEquals(m.get(1, 1), 5.0f);
        assertEquals(m.get(1, 2), 6.0f);

        assertEquals(m.get(2, 0), 7.0f);
        assertEquals(m.get(2, 1), 8.0f);
        assertEquals(m.get(2, 2), 9.0f);
    }

    @Test
    void fails_to_create_new_nan_matrix() {
        for (int i = 0; i < 9; i++) {
            var vals = new float[9];
            vals[i] = Float.NaN;
            assertThrows(ArithmeticException.class, () -> new Mat3(
                vals[0], vals[1], vals[2],
                vals[3], vals[4], vals[5],
                vals[6], vals[7], vals[8]
            ));
        }
    }

    @Test
    void creates_new_matrix_with_array() {
        var vals = new float[] {
            1.0f,  2.0f,  3.0f,
            4.0f,  5.0f,  6.0f,
            7.0f,  8.0f,  9.0f
        };
        var m = new Mat3(vals);

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);
        assertEquals(m.get(0, 2), 3.0f);

        assertEquals(m.get(1, 0), 4.0f);
        assertEquals(m.get(1, 1), 5.0f);
        assertEquals(m.get(1, 2), 6.0f);

        assertEquals(m.get(2, 0), 7.0f);
        assertEquals(m.get(2, 1), 8.0f);
        assertEquals(m.get(2, 2), 9.0f);
    }

    @Test
    void fails_to_create_new_matrix_with_null_instead_of_array() {
        float[] vals = null;
        assertThrows(IllegalArgumentException.class, () -> new Mat3(vals));
    }

    @Test
    void fails_to_create_new_matrix_with_array_of_wrong_size() {
        var vals = new float[] {
            1.0f,  2.0f,  3.0f,
            4.0f,  5.0f,  6.0f,
            7.0f,  8.0f,  9.0f, 10.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat3(vals));
    }

    @Test
    void fails_to_create_new_matrix_with_nan_array() {
        for (int i = 0; i < 9; i++) {
            var vals = new float[9];
            vals[i] = Float.NaN;
            assertThrows(ArithmeticException.class, () -> new Mat3(vals));
        }
    }

    @Test
    void get_an_element_for_the_given_indices() {

        int i, j;

        var m = new Mat3(
                1.0f,  2.0f,  3.0f,
                4.0f,  5.0f,  6.0f,
                7.0f,  8.0f,  9.0f
        );

        i = 0;
        j = 1;

        assertEquals(m.get(i, j), 2.0f);

        i = 2;
        j = 0;

        assertEquals(m.get(i, j), 7.0f);

        i = 1;
        j = 2;

        assertNotEquals(m.get(j, i), 6.0f);
    }
}
