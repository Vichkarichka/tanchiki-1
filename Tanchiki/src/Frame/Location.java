package Frame;

import java.util.HashMap;
import java.util.LinkedList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import tanchiki.components.Map;
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
    
    
    public void run()
    {
        for (Tank tank : Tanks) 
        {
            tank.run();
        }
        
        for (FireBall fireBall : FireBalls) 
        {
            fireBall.run();
        }
    }
    
    public void testInit()
    {
        Tanks.add(new Tank(root.getChildren(),0, 0.5f,0.5f,0.1f,0.1f));
    }
    

    
    // Класс который обрабатывает события с клавиатуры
    public class LettersPane extends SuperScene.LettersPane
    {
        public LettersPane() 
        {           
            // Обработка событий клавиатуры
            
            setOnKeyPressed(new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent ke)
                {
                    
                    char buffer[] = ke.getText().toCharArray();
                    
                    for(int q=0; q<buffer.length; q++)
                    {
                        switch(buffer[q])
                        {
                            case 'w':
                                Tanks.getFirst().W();
                                break;
                            case 'a':
                                Tanks.getFirst().A();
                                break;
                            case 's':
                                Tanks.getFirst().S();
                                break;
                            case 'd':
                                Tanks.getFirst().D();
                                break;
                        }
                    }
                }
            });
        }
    }
}
