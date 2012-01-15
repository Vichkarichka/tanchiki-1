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
    Location                ThisLocation; // 
    
    LettersPane             lettersPane;  // устроство клавиатуры
    Group                   root;         // ...
    
    static Thread           thread_events, // обработка всех событий
                            thread_logic;  // игровые вичисления
    
    static boolean          flag_finished_thread_logic; // если true-потоки
    // работают, иначе они заканьчиваються (делают break;)
    
    // Итерация игрового времени
    private void GameRun()
    {
        
    }
    
    // Инициализация фрейма, создание первое сцены, и потоков обработки событий
    // и потока игрвоых вичислений(он вызывает метод GameRun)
    private void init(Stage primaryStage)
    {
        root        = new Group();
        lettersPane = new LettersPane();
        root.getChildren().add(lettersPane);
        
        primaryStage.setScene(new Scene(root,480,480));
        
        thread_events = new Thread(new Runnable()
        {
            public void run() 
            {
                lettersPane.requestFocus();
            }
        });
        
        thread_logic = new Thread(new Runnable()
        {
            public void run()
            {
                while(flag_finished_thread_logic)
                {
                    GameRun();
                }
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
        flag_finished_thread_logic  = true;
        thread_logic.start();
    }
    
    // Остановка потоков игры
    public void GameStop() 
    {
        flag_finished_thread_logic  = false;
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
        lettersPane.requestLayout();
    }
    
    // Класс который обрабатывает события с клавиатуры
    public static class LettersPane extends Region
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
