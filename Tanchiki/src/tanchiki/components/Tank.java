package tanchiki.components;


import mathematic.Vec2;
import java.util.LinkedList;
import java.util.Iterator;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import tanchiki.tank_Components.Body;

public class Tank {    
    Body                    body;
    
    LinkedList<FireBall>    FireBalls;
    
    // -------------------------------------- Constructors ------------------ //
    public Tank(ObservableList<Node> list, int x, int y) {
        init(list);
        body.setPosition(x, y);
    }
    // -------------------------------------------------------------------------
    
    void init(ObservableList<Node> list) {
        body        = new Body(list);
        FireBalls   = new LinkedList<>();
    }
    
    
    // -------------------------------------- Game Functions ---------------- //
    public void fire() {
        
    }
    public void run() { 
        body.run();
        Iterator<FireBall> It = FireBalls.iterator();
        for(int q=0; q<FireBalls.size(); q++)
        {
            It.next().run();
        }
    }
    // -------------------------------------------------------------------------
}
