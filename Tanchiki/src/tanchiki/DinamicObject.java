package tanchiki;

import java.util.Vector;
import mathematic.Vec2;

import java.util.Vector;


public abstract class DinamicObject
{
    public Vec2 	pos,
                        dir,
                        clickPos;

    public float	speed,
                        height,
                        width;

    boolean 		not_click;

    int			index;


    void			slow()
    {

    }
    void 			init()
    {
        pos 		= new Vec2();
        dir 		= new Vec2();
        clickPos 	= new Vec2();

        speed 		= 0;
        height 		= 0;
        width 		= 0;

        not_click 	= true;
    }
    boolean 		leaveGameZone()
    {		
        return pos.x < 0 || pos.x + width > 1.0f || 
        	pos.y < 0 || pos.y + height > 1.0f;
    }

    public boolean 	isIn(Vec2 vec)
    {
        return pos.x <= vec.x && pos.x + width >= vec.x
            && pos.y <= vec.y && pos.y + height >= vec.y;
    }
    public boolean	isIn(float x, float y)
    {
        return pos.x <= x && pos.x + width >= x &&
            pos.y <= y && pos.y + height >= y;
    }
    boolean isConflict(Vector<DinamicObject> GameObjects)
    {
        for(int q=0; q<GameObjects.size(); q++)
        {
            if(q == index)
                continue;
            if(conflict(GameObjects.get(q)) || GameObjects.get(q).conflict(this))
                return true;
        }
        return false;
    }
    public boolean	conflict(DinamicObject object)
    {
        return isIn(object.pos) ||
                isIn(object.pos.x + object.width, object.pos.y) || 
                isIn(object.pos.x, object.pos.y + object.height) || 
                isIn(object.pos.x + object.width, object.pos.y + object.height);
    }
    void		addPosition(Vector<DinamicObject> GameObjects)
    {
        pos.add(dir);
        if (leaveGameZone())
    {
        pos.minus(dir);
        dir.y 	*= -1;
        pos.add(dir);

        if(leaveGameZone())
        {
            pos.minus(dir);
            dir.x	*= -1;
            pos.add(dir);

            if(leaveGameZone())
            {
                pos.minus(dir);
                dir.y	*= -1;
                pos.add(dir);
                if(leaveGameZone())
                {
                    pos.minus(dir);
                    addPosition(GameObjects);
                }
            }
        }
    }
    }

    public DinamicObject(int index)
    {
        this.index = index;
        init();
        height = width = 50;
    }
    public DinamicObject(int index, float X, float Y, float height, float width)
    {
        this.index = index;
        init();
        pos.x = X;
        pos.y = Y;
        this.height = height;
        this.width  = width;
    }


    public void 	runWiFi(int worldHeight, int worldWidth)
    {
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // pos = get pos from wifi;
        // dir = get dir from wifi;
        // height = get height from wifi;
        // width = get width from wifi;

        pos.x 	*= worldWidth;
        pos.y 	*= worldHeight;

        dir.x 	*= worldWidth;
        dir.y 	*= worldHeight;

        height 	*= worldHeight;
        width 	*= worldWidth;

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // bitmap resize too
    }

    public void 	run(Vec2 newDir, Vector<DinamicObject> GameObjects)
    {
        float x = newDir.x, y = newDir.y;

		
        if (newDir.x == 0 && newDir.y == 0)
        {
            slow();
            addPosition(GameObjects);
            return;
        }
        
        dir.multy(2);
        dir.add(newDir);
        dir.divide(3);

        addPosition(GameObjects);	
        newDir.x = x;
        newDir.y = y;
    }
	
    public void		setTime(long time)
    {

    }

    public void 	setClickPosition(Vec2 clickPos)
    {
        this.clickPos.minus(clickPos);
        this.clickPos.multy(-1);
    }
    public Vec2		getPosition()
    {
        return pos;
    }
    public void 	click()
    {
        not_click = false;
    }
    public void		render()
    {

    }
}
