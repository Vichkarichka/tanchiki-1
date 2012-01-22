package tanchiki.tank_Components;

import tanchiki.Constants;
import mathematic.Vec2;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


public class Head extends SuperDetal
{    
    Weapon      weapon;

    public Head(ObservableList<Node> list) 
    {
        init(list);
    }
    
    void init(ObservableList<Node> list) 
    {
        position = new Rectangle(25,25, 50,50);
        image = new ImageView(new Image(
                Constants.BAIZOR_DIRECT_ROOT + "img/bill.jpg", 
                position.getArcWidth(),
                position.getArcHeight(), 
                false, 
                true));
        
        list.add(image);
        weapon = new Weapon(list);
    }
    
    public void run() 
    {
        
    }
}
