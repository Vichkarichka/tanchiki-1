package Frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tanchiki.Constants;

public class MyMenu extends Application 
{
    Group root;
    GridPane  paneButton;
    Stage primaryStage;
    /*Создаем поле dimension каторое отвечает за размер екрана*/
    Dimension dimension;
    Image background;
    Button startGame,
           exitGame,
           saveGame,
           loadGame,
           option,
           garage;
   
    
    
    /*В этом методе мы создаем меню и делаем с ней все действия*/
    private void init(Stage primaryStage)
    {
        
        
        /*Возвращаем размер екрана*/
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        root = new Group();
        /*Создаем фрейм в катором размеры екрана dimension.getWidth(),dimension.getHeight()*/
        Scene scene = new Scene(root,dimension.getWidth(),dimension.getHeight());
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
    private void button()
    {
         paneButton = new GridPane();
          
          startGame = new Button("START");
           exitGame = new Button("EXIT");
           saveGame = new Button("SAVE");
           loadGame = new Button("LOAD");
             option = new Button("OPTION");   
             garage = new Button("GARAGE");
           
             startGame.setMinSize(150, 75);
             startGame.setLayoutX(1000);
             startGame.setLayoutY(100);
             root.getChildren().add(startGame);
             
             garage.setMinSize(150, 75);
             garage.setLayoutX(1000);
             garage.setLayoutY(200);
             root.getChildren().add(garage);
             
             loadGame.setMinSize(150, 75);
             loadGame.setLayoutX(1000);
             loadGame.setLayoutY(300);
             root.getChildren().add(loadGame);
             
             saveGame.setMinSize(150, 75);
             saveGame.setLayoutX(1000);
             saveGame.setLayoutY(400);
             root.getChildren().add(saveGame);
             
             option.setMinSize(150, 75);
             option.setLayoutX(1000);
             option.setLayoutY(500);
             root.getChildren().add(option);
             
             exitGame.setMinSize(150, 75);
             exitGame.setLayoutX(1000);
             exitGame.setLayoutY(600);
             root.getChildren().add(exitGame);
           
    }
    /*в етом методе я предаю действия кнопкам*/
    private void ActionButton()
    {
        
    }
    public void start(Stage primaryStage)
    {
        init(primaryStage);
        primaryStage.show();
        primaryStage.close();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
