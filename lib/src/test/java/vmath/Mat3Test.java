package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Mat3Test {
    @Test
    void creates_new_identity_matrix() {
        var m = new Mat3();
        assertEquals(0.0f, m.get(0, 0));
        assertEquals(0.0f, m.get(0, 1));
        assertEquals(0.0f, m.get(0, 2));

        assertEquals(0.0f, m.get(1, 0));
        assertEquals(0.0f, m.get(1, 1));
        assertEquals(0.0f, m.get(1, 2));

        assertEquals(0.0f, m.get(2, 0));
        assertEquals(0.0f, m.get(2, 1));
        assertEquals(0.0f, m.get(2, 2));
    }

    @Test
    void fails_to_create_new_matrix_with_nan_args() {
        assertThrows(
                ArithmeticException.class,
                () -> new Mat3(
                        Float.NaN, Float.NaN, Float.NaN,
                        Float.NaN, Float.NaN, Float.NaN,
                        Float.NaN, Float.NaN, Float.NaN));
        assertThrows(ArithmeticException.class,
                () -> new Mat3(Float.NaN, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        assertThrows(ArithmeticException.class,
                () -> new Mat3(0.0f, Float.NaN, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        assertThrows(ArithmeticException.class,
                () -> new Mat3(0.0f, 1.0f, Float.NaN, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        assertThrows(ArithmeticException.class,
                () -> new Mat3(0.0f, 1.0f, 2.0f, Float.NaN, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        assertThrows(ArithmeticException.class,
                () -> new Mat3(0.0f, 1.0f, 2.0f, 3.0f, Float.NaN, 5.0f, 6.0f, 7.0f, 8.0f));
        assertThrows(ArithmeticException.class,
                () -> new Mat3(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, Float.NaN, 6.0f, 7.0f, 8.0f));
        assertThrows(ArithmeticException.class,
                () -> new Mat3(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, Float.NaN, 7.0f, 8.0f));
        assertThrows(ArithmeticException.class,
                () -> new Mat3(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, Float.NaN, 8.0f));
        assertThrows(ArithmeticException.class,
                () -> new Mat3(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, Float.NaN));
    }

    @Test
    void creates_new_non_zero_matrix_with_args() {
        var m = new Mat3(
                0.0f, 1.0f, 2.0f,
                3.0f, 4.0f, 5.0f,
                6.0f, 7.0f, 8.0f);
        assertEquals(0.0f, m.get(0, 0));
        assertEquals(1.0f, m.get(0, 1));
        assertEquals(2.0f, m.get(0, 2));

        assertEquals(3.0f, m.get(1, 0));
        assertEquals(4.0f, m.get(1, 1));
        assertEquals(5.0f, m.get(1, 2));

        assertEquals(6.0f, m.get(2, 0));
        assertEquals(7.0f, m.get(2, 1));
        assertEquals(8.0f, m.get(2, 2));
    }

    @Test
    void fails_to_create_new_matrix_with_null_array() {
        float null_array[] = null;
        assertThrows(IllegalArgumentException.class, () -> new Mat3(null_array));
    }

    @Test
    void fails_to_create_new_matrix_with_array_of_wrong_size() {
        float[] array = new float[8];
        assertThrows(IllegalArgumentException.class, () -> new Mat3(array));
    }

    @Test
    void fails_to_create_new_matrix_with_array_containing_nan() {
        float[] array = {
                Float.NaN, Float.NaN, Float.NaN,
                Float.NaN, Float.NaN, Float.NaN,
                Float.NaN, Float.NaN, Float.NaN,
        };
        assertThrows(ArithmeticException.class, () -> new Mat3(array));
        float[] array1 = { Float.NaN, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f };
        assertThrows(ArithmeticException.class, () -> new Mat3(array1));
        float[] array2 = { 0.0f, Float.NaN, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f };
        assertThrows(ArithmeticException.class, () -> new Mat3(array2));
        float[] array3 = { 0.0f, 1.0f, Float.NaN, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f };
        assertThrows(ArithmeticException.class, () -> new Mat3(array3));
        float[] array4 = { 0.0f, 1.0f, 2.0f, Float.NaN, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f };
        assertThrows(ArithmeticException.class, () -> new Mat3(array4));
        float[] array5 = { 0.0f, 1.0f, 2.0f, 3.0f, Float.NaN, 5.0f, 6.0f, 7.0f, 8.0f };
        assertThrows(ArithmeticException.class, () -> new Mat3(array5));
        float[] array6 = { 0.0f, 1.0f, 2.0f, 3.0f, 4.0f, Float.NaN, 6.0f, 7.0f, 8.0f };
        assertThrows(ArithmeticException.class, () -> new Mat3(array6));
        float[] array7 = { 0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, Float.NaN, 7.0f, 8.0f };
        assertThrows(ArithmeticException.class, () -> new Mat3(array7));
        float[] array8 = { 0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, Float.NaN, 8.0f };
        assertThrows(ArithmeticException.class, () -> new Mat3(array8));
        float[] array9 = { 0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, Float.NaN };
        assertThrows(ArithmeticException.class, () -> new Mat3(array9));
    }

    @Test
    void creates_new_matrix_with_array() {
        float[] array = {
                0.0f, 1.0f, 2.0f,
                3.0f, 4.0f, 5.0f,
                6.0f, 7.0f, 8.0f
        };
        var m = new Mat3(array);
        assertEquals(0.0f, m.get(0, 0));
        assertEquals(1.0f, m.get(0, 1));
        assertEquals(2.0f, m.get(0, 2));

        assertEquals(3.0f, m.get(1, 0));
        assertEquals(4.0f, m.get(1, 1));
        assertEquals(5.0f, m.get(1, 2));

        assertEquals(6.0f, m.get(2, 0));
        assertEquals(7.0f, m.get(2, 1));
        assertEquals(8.0f, m.get(2, 2));
    }
}
