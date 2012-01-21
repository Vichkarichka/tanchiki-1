package tanchiki;

import java.util.LinkedList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import tanchiki.components.FireBall;
import tanchiki.components.Tank;

public class Location extends SuperScene
{
    LinkedList<Tank>        Tanks;
    LinkedList<FireBall>    FireBalls;
    
    public Location()
    {
        Tanks           = new LinkedList<Tank>();
        FireBalls       = new LinkedList<FireBall>();
        LettersPane     lettersPane = new LettersPane();
        init(false, 800, 600, lettersPane);
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
