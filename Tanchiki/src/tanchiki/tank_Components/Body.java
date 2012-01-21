package tanchiki.tank_Components;


import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.LinkedList;
import javafx.scene.shape.Rectangle;
import mathematic.Vec2;
import tanchiki.Constants;

public class Body extends SuperDetal{
    LinkedList<Head>            head;
    LinkedList<Caterpillar>     guseneci;
    
    public Body(ObservableList<Node> list) {
        init(list);
    }
    
    
    
    void init(ObservableList<Node> list) {
        position    = new Rectangle(0,0, 50,50);
        dir         = new Vec2(0, -1);
        
        
        image       = new ImageView(new Image(
                Constants.BAIZOR_DIRECT_ROOT + "img/bill.jpg", 
                position.getArcWidth(), 
                position.getArcHeight(),
                false, 
                true));
        list.add(image);
        
        guseneci    = new LinkedList<Caterpillar>();
        guseneci.   addLast(new Caterpillar(list, new Rectangle(-1,-1,9,51)));
        guseneci.   addLast(new Caterpillar(list, new Rectangle(42,-1,51,51)));
        
        head        = new LinkedList<Head>();
        head.       addLast(new Head(list));
        double buffer0 = position.getArcHeight();
        double buffer1 = position.getHeight();
    }
    
    public void run() {
        
    }
    public void setPosition(float x, float y) {
        position.setX(x);
        position.setY(y);
    }
}
