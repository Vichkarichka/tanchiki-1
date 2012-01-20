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
        x = (float) (x * Math.cos(radians) - y * Math.sin(radians));
        y = (float) (x * Math.sin(radians) + y * Math.cos(radians));
    }
    public void setRotate(float radians) {
        x = ((float)Math.cos(radians));
        y = ((float)Math.sin(radians));
    }
    public void RotateAxis(float radians, Vec2 axis)
    {
        minus(axis);
        Rotate(radians);
        plus(axis);
    }
    public void setRotateAxis(float radians, Vec2 axis)
    {
        minus(axis);
        setRotate(radians);
        plus(axis);
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
    public void plus(Vec2 Vector)
    {
        this.x += Vector.getX();
        this.y += Vector.getY();
    }
    public void minus(float minus) {
        x -= minus;
        y -= minus;
    }
    public void minus(float x, float y) {
        this.x -= x;
        this.y -= y;
    }
    public void minus(Vec2 Vector)
    {
        this.x -= Vector.getX();
        this.y -= Vector.getY();
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
