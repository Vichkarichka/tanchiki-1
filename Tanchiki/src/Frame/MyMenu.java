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
   
    /*Создаем поле dimension каторое отвечает за размер екрана*/
    Dimension dimension;
  
    Button startGame,
           exitGame,
           saveGame,
           loadGame,
           option,
           garage;
   
    
    
    /*В этом методе мы создаем меню и делаем с ней все действия*/
    public void init(Stage primaryStage)
    {
        
        
        /*Возвращаем размер екрана*/
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        root = new Group();
        /*Создаем фрейм в катором размеры екрана dimension.getWidth(),dimension.getHeight()*/
        Scene scene = new Scene(root,dimension.getWidth(),dimension.getWidth());
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        Image background = new Image(Constants.Pasha_Root_Bacground,dimension.getWidth(),dimension.getWidth(),false,false);
        ImageView image = new ImageView();
        image.setImage(background);   
        root.getChildren().add(image);
        
        
        
        
    }
    public void start(Stage primaryStage)
    {
        init(primaryStage);
        primaryStage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
