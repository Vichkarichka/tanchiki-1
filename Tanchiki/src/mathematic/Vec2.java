package mathematic;

public class Vec2 {
	public float 		x,
						y;
	
	public 			Vec2()
	{
		x = 0;
		y = 0;
	}
	public 			Vec2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	public			Vec2(Vec2 vec)
	{
		x = vec.x;
		y = vec.y;
	}
	public void		normalize()
	{
		float length = getVecLength();
		x /= length;
		y /= length;
	}
	public float	getVecLength()
	{
		return (float) Math.sqrt(D(x, 0) + D(y, 0));
	}
	public float	getVecLength(Vec2 vec)
	{
		return (float) Math.sqrt((float) D(x, vec.x) + D(y, vec.y));
	}
	public float 	D(float a, float b)
	{
		return a * a - 2 * a * b + b * b;
	}
	public double  	D(double a,  double  b)
	{
		return a * a - 2 * a * b + b * b;
	}
	public int    	D(int a,    int    b)
	{
		return a * a - 2 * a * b + b * b;
	}

	public void   	add(Vec2 vec)
	{
		x += vec.x;
		y += vec.y;
	}
	public void   	add(float x, float y)
	{
		this.x += x;
		this.y += y;
	}
	public void		minus(Vec2 vec)
	{
		x -= vec.x;
		y -= vec.y;
	}
	public void		multy(float decimal)
	{
		x *= decimal;
		y *= decimal;
	}
	public void 	divide(float decimal)
	{
		x /= decimal;
		y /= decimal;
	}
}
