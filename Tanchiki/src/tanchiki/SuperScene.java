package tanchiki;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

abstract public class SuperScene
{
    private Scene           World;  
    LettersPane             lettersPane;  // устроство клавиатуры
    Group                   root;         // ...
    
    Thread                  thread_events; // обработка всех событий
    
    public void init(int width, int height, LettersPane lettersPane_buf)
    {
        root  = new Group();
        // создаем объект класса, который отлавливает события
        lettersPane = lettersPane_buf;
        // добавляем этот объект к остальным компонентам сцены
        root.getChildren().add(lettersPane);
        
        World = new Scene(root, width, height, Color.BLACK);

        // создаем поток для вылавливания событий
        thread_events = new Thread(new Runnable()
        {
            public void run() 
            {
                lettersPane.requestFocus();
            }
        });
        thread_events.start();
    }
    
    public void stop()
    {
        stopEventScanner();
    }
    public void stopEventScanner()
    {
        lettersPane.requestLayout();
    }
    public void startEventScanner()
    {
        thread_events.start();
    }
    
    public Scene getScene()
    {
        return World;
    }
    
    
    // Класс который обрабатывает события с клавиатуры
    abstract public static class LettersPane extends Region
    {
        public LettersPane() 
        {           
            // Обработка событий клавиатуры
            setOnKeyPressed(new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent ke)
                {
//                    switch(ke.getText())
//                    {
//                        case "w":
//                            System.out.println("w");
//                            break;
//                    }
                }
            });
        }
    }
}
