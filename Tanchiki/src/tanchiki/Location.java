package tanchiki;

import java.util.HashMap;
import java.util.LinkedList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import tanchiki.components.FireBall;
import tanchiki.components.Tank;

public class Location extends SuperScene
{
    Map                     map;
    LinkedList<Tank>        Tanks;
    LinkedList<FireBall>    FireBalls;
    
    public Location(Stage stage,HashMap<String,SuperScene> scenes)
    {
        map             = new Map(64, 36);
        Tanks           = new LinkedList<Tank>();
        FireBalls       = new LinkedList<FireBall>();
        LettersPane     lettersPane = new LettersPane();
        init(true, 800, 600, stage, scenes, lettersPane);
    }
    
    // Класс который обрабатывает события с клавиатуры
    public static class LettersPane extends SuperScene.LettersPane
    {
        public LettersPane() 
        {           
            // Обработка событий клавиатуры
            setOnKeyPressed(new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent ke)
                {
                    switch(ke.getText())
                    {
                        case "s":
                            System.out.println("s");
                            break;
                    }
                }
            });
        }
    }
}
