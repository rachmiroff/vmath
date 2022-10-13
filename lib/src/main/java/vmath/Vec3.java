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
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public Vec3 norm() {
        float mag = mag();
        return new Vec3(x / mag, y / mag, z / mag);
    }

    public Vec3 add(Vec3 other) {
        return new Vec3(x + other.x, y + other.y, z + other.z);
    }

    public Vec3 sub(Vec3 other) {
        return new Vec3(x - other.x, y - other.y, z - other.z);
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
