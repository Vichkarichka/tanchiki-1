package tanchiki;

import Frame.Menu;
import java.util.HashMap;
import java.util.Iterator;
import javafx.application.Application;
import javafx.stage.Stage;


public class Game extends Application
{
    HashMap<String,SuperScene>      Locations; // 
    
    Thread                          thread_logic; // игровые вичисления
                            
    boolean                         flag_finished_thread_logic; // если true-потоки
    // работают, иначе они заканьчиваються (делают break;)
    
    // Итерация игрового времени
    private void GameRun()
    {
        
    }
    
    // Инициализация фрейма, создание первое сцены, и потоков обработки событий
    // и потока игровых вичислений(он вызывает метод GameRun)
    private void init(Stage primaryStage)
    {        
        Locations.put("Menu",new Menu());
        primaryStage.setScene(Locations.get("Menu").getScene());
        
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
        Locations    = new HashMap<String,SuperScene>();
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
        init(arg0);
        arg0.show();
    }
    
    // Конец программы
    public void stop()
    {
        Iterator<SuperScene> It = Locations.values().iterator();
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
