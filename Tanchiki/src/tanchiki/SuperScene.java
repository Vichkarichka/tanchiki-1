package tanchiki;

import java.awt.Toolkit;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

abstract public class SuperScene
{
    protected Scene         World;  
    protected LettersPane   lettersPane;  // устроство клавиатуры
    protected Group         root;         // ...
    
    protected Thread        thread_events; // обработка всех событий
    protected int           height,
                            width;
    
    // Задаем размер окна, и отлавливатель событий
    public void init(boolean fullScreen, int width, int height, LettersPane lettersPane_buf)
    {
        this.height = height;
        this.width  = width;
        root        = new Group();
        // создаем объект класса, который отлавливает события
        lettersPane = lettersPane_buf;
        // добавляем этот объект к остальным компонентам сцены
        root.getChildren().add(lettersPane);
                
        if(fullScreen)
        {
            this.width   = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
            this.height  = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        }
        
        World = new Scene(root, this.width, this.height, Color.BLACK);

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
    // Задаем размер окна
    public void init(boolean fullScreen, int width, int height)
    {
        this.height = height;
        this.width  = width;
        root        = new Group();        
        
        if(fullScreen)
        {
            this.width   = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
            this.height  = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        }
        
        World = new Scene(root, this.width, this.height, Color.BLACK);
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
