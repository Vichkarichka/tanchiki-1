package tanchiki;

import Registration.Registration;
import Frame.*;
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
    Messanger                       messanger; // передает сообщения от сцен сюда
    Stage                           primaryStage;
    Location                        location;
    
    // обработка сообщений из других сцен
    void messangerScanner()
    {
        if(messanger.isNew_message())
        {
            String message = messanger.getText();

            switch(message)
            {
                case "exit":
                    stop();
                    break;
            }
        }
    }
    
    // Итерация игрового времени
    void GameRun()
    {
        while(flag_finished_thread_game)
        {
            // обработка сообщений из других сцен
            messangerScanner();
            
            
            location.run();
            // ...
            // ...
            // ...
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
    void init(Stage primaryStage)
    {   
        location = new Location(primaryStage,Scenes);
        location.setMessanger(messanger);
        location.testInit();
        
        Scenes.put("Menu",new Menu(primaryStage,Scenes));
        Scenes.put("Registration", new Registration(primaryStage,Scenes));
        Scenes.put("Logo", new Logo(primaryStage,Scenes));
        Scenes.put("Location0", location);
        Scenes.put("Option", new Option(primaryStage,Scenes));
        Scenes.put("SelectionMap", new SelectionMap(primaryStage,Scenes));
        
        
        Scenes.get("SelectionMap").setMessanger(messanger);
        Scenes.get("Option").setMessanger(messanger);
        Scenes.get("Menu").setMessanger(messanger);
        Scenes.get("Registration").setMessanger(messanger);
        Scenes.get("Logo").setMessanger(messanger);
        
        primaryStage.setScene(Scenes.get("Registration").getScene());
        primaryStage.setFullScreen(true);
        
        this.primaryStage = primaryStage;
        
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
        messanger = new Messanger();
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
        GameStart();
    }
    
    // Конец программы
    public void stop()
    {
        Iterator<SuperScene> It = Scenes.values().iterator();
        for(int q=0; It.hasNext(); q++)
        {
            It.next().stop();
        }
        GameStop();
    }
    
    public static void main(String[] args)
    { 
        launch(args); 
    }
}
