package tanchiki.tank_Components;

import mathematic.Vec2;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public abstract class SuperDetal {
    protected Rectangle     position  = null;     
    protected Vec2          dir       = null;
    protected ImageView     image     = null;
    
    public abstract void    run();
}
