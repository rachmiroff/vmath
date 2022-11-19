package vmath;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Mat2Test {
  @Test
  void creates_new_zero_matrix() {
    var m = new Mat2();
    assertEquals(m.get(0, 0), 0.0f);
    assertEquals(m.get(0, 1), 0.0f);
    assertEquals(m.get(1, 0), 0.0f);
    assertEquals(m.get(1, 1), 0.0f);
  }

  @Test
  void creates_new_matrix_with_args() {
    var m = new Mat2(1.0f, 2.0f, 3.0f, 4.0f);
    assertEquals(m.get(0, 0), 1.0f);
    assertEquals(m.get(0, 1), 2.0f);
    assertEquals(m.get(1, 0), 3.0f);
    assertEquals(m.get(1, 1), 4.0f);
  }

  @Test
  void fails_to_creates_new_matrix_with_nan_args() {
    assertThrows(ArithmeticException.class,
        () -> new Mat2(0.0f, Float.NaN, Float.NaN, 0.0f));
  }

  @Test
  void creates_new_matrix_by_passing_array() {
    float arr[] = { 1.0f, 2.0f, 3.0f, 4.0f };
    var m = new Mat2(arr);
    assertEquals(m.get(0, 0), 1.0f);
    assertEquals(m.get(0, 1), 2.0f);
    assertEquals(m.get(1, 0), 3.0f);
    assertEquals(m.get(1, 1), 4.0f);
  }

  @Test
  void fails_to_create_new_matrix_by_passing_null_array() {
    float arr[] = null;
    assertThrows(IllegalArgumentException.class, () -> new Mat2(arr));
  }

  @Test
  void fails_to_create_new_matrix_by_passing_incorrect_size_array() {
    float arr[] = { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f };
    assertThrows(IllegalArgumentException.class, () -> new Mat2(arr));
  }
}
