package Frame;

import java.util.HashMap;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;

public class Logo extends SuperScene
{
    public Logo(Stage stage,HashMap<String,SuperScene> scenes)
    {
        // создаем fullScreen фрейм, (0,0) игнорируем размеры окна.
        init(true,0,0,stage,scenes,"D:/ramsstein.mp3");
        
        
        ImageView image = new ImageView(new Image("D:/ICO/Vetton/masseffectwallpaper.jpg",
                width,height,true,true));
        root.getChildren().add(image);
        
    }
}
