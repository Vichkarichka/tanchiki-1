package Frame;
/*dsa*/
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tanchiki.Constants;

public class MyMenu extends Application 
{
    private Group root;
   // GridPane  paneButton;
    public  Stage primaryStage;
    /*Создаем поле dimension каторое отвечает за размер екрана*/
   public  Dimension dimension;
    private Image background;
    Scene scene;
   private  Button startGame,
           exitGame,
           saveGame,
           loadGame,
           option,
           garage,
           connectAccount;
   
    
    
    /*В этом методе мы создаем меню и делаем с ней все действия*/
    public void init(Stage primaryStage)
    {
        
        this.primaryStage = primaryStage;
        Menu();
        
        
    }
    public void Menu()
    {
        /*Возвращаем размер екрана*/
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        root = new Group();
        /*Создаем фрейм в катором размеры екрана dimension.getWidth(),dimension.getHeight()*/
        scene  = new Scene(root,dimension.getWidth(),dimension.getHeight());
        primaryStage.setScene(scene);
        if(dimension.getWidth()/dimension.getHeight()==4/3)
        {
             //background = new Image(Constants.Pasha_Root_Bacground,dimension.getWidth()
                   // ,dimension.getHeight(),false,false);
        }
        else
        {
             background = new Image(Constants.Pasha_Root_Background,dimension.getWidth()
                ,dimension.getHeight(),false,false);
        }
        primaryStage.setFullScreen(true);     
        ImageView image = new ImageView();
        image.setImage(background);   
        root.getChildren().add(image);    
        
        button();
    }
    /*В этом методе я создаю и розмещаю кнопки */
    public void button()
    {
       
          
     connectAccount = new Button("ACCOUNT");
          startGame = new Button("START");
           exitGame = new Button("EXIT");
           saveGame = new Button("SAVE");
           loadGame = new Button("LOAD");
             option = new Button("OPTION");   
             garage = new Button("GARAGE");
           
             connectAccount.setMinSize(150, 75);
             connectAccount.setLayoutX(1000);
             connectAccount.setLayoutY(200);
             root.getChildren().add(connectAccount);
             
             startGame.setMinSize(150, 75);
             startGame.setLayoutX(1000);
             startGame.setLayoutY(300);
             startGame.setDisable(true);
             root.getChildren().add(startGame);
             
             garage.setMinSize(150, 75);
             garage.setLayoutX(1000);
             garage.setLayoutY(400);
             garage.setDisable(true);
             root.getChildren().add(garage);
             
             loadGame.setMinSize(150, 75);
             loadGame.setLayoutX(1000);
             loadGame.setLayoutY(500);
             loadGame.setDisable(true);
             root.getChildren().add(loadGame);
             
             saveGame.setMinSize(150, 75);
             saveGame.setLayoutX(1000);
             saveGame.setLayoutY(600);
             saveGame.setDisable(true);
             root.getChildren().add(saveGame);
             
             option.setMinSize(150, 75);
             option.setLayoutX(1000);
             option.setLayoutY(700);
             root.getChildren().add(option);
             
             exitGame.setMinSize(150, 75);
             exitGame.setLayoutX(1000);
             exitGame.setLayoutY(800);
             root.getChildren().add(exitGame);
             
             ActionButton();
           
    }
    /*в етом методе я предаю действия кнопкам*/
    public void ActionButton()
    {
        exitGame.setOnAction(new EventHandler<ActionEvent>()
        {

                public void handle(ActionEvent e)
                {
                    primaryStage.close();
                }
        });
        root.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            public void handle(KeyEvent e) 
            {
                if(e.getCode() == KeyCode.ESCAPE)
                {
                    primaryStage.close();
                }
            }
            
        });
        connectAccount.setOnAction(new EventHandler<ActionEvent>()
        {

                public void handle(ActionEvent e)
                {
                    new Registration(primaryStage);
                }
        });
    }
    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        init(primaryStage);
        primaryStage.show();
        
    }
    
    
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
