package tanchiki.components;


import mathematic.Vec2;
import java.util.LinkedList;
import java.util.Iterator;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import tanchiki.DinamicObject;
import tanchiki.tank_Components.Body;

public class Tank extends DinamicObject
{    
    Body                    body;
    
    LinkedList<FireBall>    FireBalls;
    
    void init(ObservableList<Node> list) 
    {
        body        = new Body(list);
        FireBalls   = new LinkedList<>();
    }
    
    // -------------------------------------- Constructors ------------------ //
    public Tank(ObservableList<Node> list, int index, float x, float y, float height, float width) 
    {
        super(index, x, y, height, width);
        init(list);
        body.setPosition(x, y);
    }
    // -------------------------------------------------------------------------
    
    // -------------------------------------- Game Functions ---------------- //
    public void fire() 
    {
        
    }
    public void run() 
    { 
        body.run();
        body.setPosition(pos.x, pos.y);
//        Iterator<FireBall> It = FireBalls.iterator();
//        for(int q=0; q<FireBalls.size(); q++)
//        {
//            It.next().run();
//        }
    }
    
    public void W()
    {
        body.W();
    }
    public void A()
    {
        body.A();
    }
    public void S()
    {
        body.S();
    }
    public void D()
    {
        body.D();
    }
    public void Q()
    {
        
    }
    public void E()
    {
    
    }
    public void F()
    {
        
    }
    // -------------------------------------------------------------------------
}
