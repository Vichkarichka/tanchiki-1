package tanchiki;

import Frame.Menu;
import Frame.Registration;
import java.util.HashMap;
import java.util.Iterator;
import javafx.application.Application;
import javafx.stage.Stage;


public class Game extends Application
{
    HashMap<String,SuperScene>      Scenes; // Map сцен, для удобной динамической смены
    Thread                          thread_logic; // игровые вичисления               
    boolean                         flag_finished_thread_logic,
                                    flag_finished_thread_game; // если true-потоки
                                    // работают, иначе они заканьчиваються (делают break;)
    
    // Итерация игрового времени
    private void GameRun()
    {
        while(flag_finished_thread_game)
        {
            
        }
    }
    
    /*
      Инициализация фрейма, создание первое сцены, и потоков обработки событий
      и потока игровых вичислений(он вызывает метод GameRun)
       
         ! ! ! 
         ! ! ! Здесь надо создавать все объекты классов которые  
         ! ! ! наследуються от SuperScene
         ! ! !
    */
    private void init(Stage primaryStage)
    {        
        Scenes.put("Menu",new Menu());
        Scenes.put("Registration", new Registration());
        
        primaryStage.setScene(Scenes.get("Menu").getScene());
        primaryStage.setFullScreen(true);
        
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
    }
    
    public Game() 
    {
        Scenes    = new HashMap<String,SuperScene>();
    }
    
    // Запуск потоков игры
    public void GameStart() 
    {
        flag_finished_thread_logic  = true;
        flag_finished_thread_game   = true;
        thread_logic.start();
    }
    
    // Остановка потоков игры
    public void GameStop() 
    {
        flag_finished_thread_logic  = false;
        flag_finished_thread_game   = false;
    }

    // Начало программы
    public void start(Stage arg0) throws Exception 
    {
        init(arg0);
        arg0.show();
    }
    
    // Конец программы
    public void stop()
    {
        GameStop();
        Iterator<SuperScene> It = Scenes.values().iterator();
        for(int q=0; It.hasNext(); q++)
        {
            It.next().stop();
        }
    }
    
    public static void main(String[] args)
    { 
        launch(args); 
    }
}
