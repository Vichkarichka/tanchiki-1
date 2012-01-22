package Frame;

import java.awt.Toolkit;
import java.util.HashMap;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tanchiki.Messanger;

abstract public class SuperScene
{
    protected Scene         World;
    protected LettersPane   lettersPane;  // устроство клавиатуры
    protected Group         root;         // ...
    
    protected Thread        thread_events; // обработка всех событий
    protected int           height,
                            width;
    protected boolean       DisplayFormat4x3,
                            fullScreen;
    protected Messanger                     messanger;
    protected Stage                         primaryStage;
    protected HashMap<String,SuperScene>    Scenes;
    
    // динамическая смена сцены
    protected boolean updateScene(String sceneName)
    {
        SuperScene  sceneBuffer = Scenes.get(sceneName);
        if(sceneBuffer != null)
        {
            // динамическая смена сцены
            primaryStage.setScene(sceneBuffer.getScene());
            return true;
        }
        return false;
    }
    
    // Задаем размер окна, и отлавливатель событий
    public void init(boolean fullScreen, int width, int height, 
            Stage stage,HashMap<String,SuperScene> scenes, 
            LettersPane lettersPane_buf)
    {
        primaryStage    = stage;
        Scenes          = scenes;
        this.fullScreen = fullScreen;
        this.height = height;
        this.width  = width;
        root        = new Group();
        // создаем объект класса, который отлавливает события
        lettersPane = lettersPane_buf;
        // добавляем этот объект к остальным компонентам сцены
        root.getChildren().add(lettersPane);
        
        DisplayFormat4x3 = (float) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 
                (float) Toolkit.getDefaultToolkit().getScreenSize().getHeight() == 4f / 3f;
                
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
    public void init(boolean fullScreen, int width, int height, 
            Stage stage,HashMap<String,SuperScene> scenes)
    {
        primaryStage    = stage;
        Scenes          = scenes;
        this.fullScreen = fullScreen;
        this.height = height;
        this.width  = width;
        root        = new Group();   
        
        DisplayFormat4x3 = (float)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 
                (float) Toolkit.getDefaultToolkit().getScreenSize().getHeight() == 4f / 3f;
        
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
        if(lettersPane != null)
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
    
    public void setMessanger(Messanger messanger)
    {
        this.messanger = messanger;
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
