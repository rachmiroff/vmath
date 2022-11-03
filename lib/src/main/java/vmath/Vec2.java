package vmath;

public class Vec2 {
    private final float x, y;

    public Vec2() {
        this(0.0f, 0.0f);
    }

    public Vec2(float x, float y) {
        if (Float.isNaN(x) || Float.isNaN(y)) {
            throw new ArithmeticException();
        }

        this.x = x;
        this.y = y;
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }

    public float mag() {
        return (float) Math.sqrt(x*x + y*y);
    }

    public float sqrdMag() {
        return x*x + y*y;
    }

    public Vec2 norm() {
        float norm = 1.0f/mag();
        return new Vec2(x*norm, y*norm);
    }

    public Vec2 add(Vec2 other) {
        return new Vec2(x + other.x, y + other.y);
    }

    public Vec2 sub(Vec2 other) {
        return new Vec2(x - other.x, y - other.y);
    }

    public Vec2 mul(float scalar) {
        return new Vec2(x*scalar, y*scalar);
    }

    public float dot(Vec2 other) {
        return x*other.x + y*other.y;
    }

	public Vec2 lerp(Vec2 other, float alpha) {
		return new Vec2(
			x*(1.0f - alpha) + other.x()*alpha,
			y*(1.0f - alpha) + other.y()*alpha
		);
	}

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
