package vmath;

public class Vec3 {
    private float x, y, z;

    public Vec3() {
        this(0.0f, 0.0f, 0.0f);
    }

    public Vec3(float x, float y, float z) {
        if (Float.isNaN(x) || Float.isNaN(y) || Float.isNaN(z)) {
            throw new ArithmeticException();
        }

        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }

    public float z() {
        return z;
    }

    public float mag() {
        return 0.0f; // TODO
    }

    public Vec3 norm() {
        return null; // TODO
    }

    public Vec3 add(Vec3 other) {
        return null; // TODO
    }

    public Vec3 sub(Vec3 other) {
        return null; // TODO
    }

    public Vec3 mul(float scalar) {
        return null; // TODO
    }

    public float dot(Vec3 other) {
        return 0.0f; // TODO
    }

    public String toString() {
        return ""; // TODO
    }
}
