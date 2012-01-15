package mathematic;

public class Vec2 {
    private float x;
    private float y;
    
    // -------------------------------------- Constructors ------------------ //
    public Vec2() {
        x = y = 0;
    }
    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    // -------------------------------------------------------------------------
    
    // -------------------------------------- Mathematic -------------------- //
    public void Rotate(float radians){
        setX((float) (getX() * Math.cos(radians) - getY() * Math.sin(radians)));
        setY((float) (getX() * Math.sin(radians) + getY() * Math.cos(radians)));
    }
    public void setRotate(float radians) {
        setX((float)Math.cos(radians));
        setY((float)Math.sin(radians));
    }
    public float length() {
        return (float)Math.sqrt(x * x + y * y);
    }
    public void Normalise() {
        float length = length();
        x       /= length;
        y       /= length;
    }
    public void plus(float plus) {
        x += plus;
        y += plus;
    }
    public void plus(float x, float y) {
        this.x += x;
        this.y += y;
    }
    public void minus(float minus) {
        x -= minus;
        y -= minus;
    }
    public void minus(float x, float y) {
        this.x -= x;
        this.y -= y;
    }
    public float getAlphaX() {
        return x / (float)Math.sqrt(x * x + y * y) * 57.2957795130823f;
    } 
    public float getAlphaY() {
        return y / (float)Math.sqrt(x * x + y * y) * 57.2957795130823f;
    }
    // -------------------------------------------------------------------------
    
    public float    getX() {
        return x;
    }
    public void     setX(float x) {
        this.x = x;
    }
    public float    getY() {
        return y;
    }
    public void     setY(float y) {
        this.y = y;
    }
}
