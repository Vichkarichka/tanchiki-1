package tanchiki;

import java.util.LinkedList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import tanchiki.components.FireBall;
import tanchiki.components.Tank;

public class Game extends Application
{
    LinkedList<Tank>        Tanks;
    LinkedList<FireBall>    FireBalls;
    Location                ThisLocation;
    
    LettersPane             lettersPane; // устроство клавиатуры
    Group                   root;        // ...
    
    static Thread           thread_events, // обработка всех событий
                            thread_logic;  // игровые вичисления
    
    
    private void init(Stage primaryStage)
    {
        root        = new Group();
        lettersPane = new LettersPane();
        root.getChildren().add(lettersPane);
        
        primaryStage.setScene(new Scene(root,480,480));
        primaryStage.fullScreenProperty();   // задали полный экран(поидеи)
        //primaryStage.
        
        thread_events = new Thread(new Runnable()
        {
           public void run() 
            {
                lettersPane.requestFocus();
            }
        });
        
        thread_events.start();
    }
    
    public Game() 
    {
        Tanks           = new LinkedList<Tank>();
        FireBalls       = new LinkedList<FireBall>();
        ThisLocation    = new Location();
    }
    
    
    // Запуск потоков игры
    public void GameStart() 
    {
        ////
        ////
    }
    
    // Остановка потоков игры
    public void GameStop() 
    {
        ////
        ////
    }

    // Начало программы
    public void start(Stage arg0) throws Exception 
    {
        //throw new UnsupportedOperationException("Not supported yet.");

        init(arg0);
        arg0.show();
    }
    
    // Конец программы
    public void stop() 
    {
        try
        {
            thread_events.stop();
            thread_events.destroy();
        }
        catch(Exception e)
        {
            System.out.print("Hello");
        }
    }
    
    public static class LettersPane extends Region
    {
        public LettersPane() 
        {           
            setOnKeyPressed(new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent ke)
                {
                    switch(ke.getText())
                    {
                        case "w":
                            System.out.println("w");
                            break;
                    }
                }
            });
        }
    }
    
    public static void main(String[] args)
    { 
        launch(args); 
    }
}
