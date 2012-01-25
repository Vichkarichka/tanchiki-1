package Frame;

import java.util.HashMap;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class Option extends SuperScene
{
    public Slider
                 volume;
    public Option(Stage stage,HashMap<String,SuperScene> scenes)
    {
        init(true, 0, 0, stage, scenes, "D:/ramsstein.mp3");
        volume = new Slider();
        
    }
}
