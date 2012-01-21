package Frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import tanchiki.Constants;
import tanchiki.SuperScene;

public class Menu extends SuperScene
{
    Dimension   dimension;
    Image       background;
    Button      startGame,
                exitGame,
                saveGame,
                loadGame,
                option,
                garage,
                connectAccount;

    public Menu()
    {
        // создаем fullScreen фрейм, (0,0) игнорируем размеры окна.
        init(true,0,0);
        
        System.out.println("Height="+height+"\nWidth="+width);
        // проверка формата экрана
        if(DisplayFormat4x3)
        {
             //background = new Image(Constants.Pasha_Root_Bacground,dimension2.getWidth()
                   // ,dimension2.getHeight(),false,false);
        }
        else
        {
//             background = new Image(Constants.Pasha_Root_Background,dimension.getWidth()
//                ,dimension.getHeight(),false,false);
        }
        
        ImageView image = new ImageView();
        image.setImage(background);   
        root.getChildren().add(image);    
        
        button();
    }
    /*В этом методе я создаю и розмещаю кнопки */
    private void button()
    { 
     connectAccount = new Button("ACCOUNT");
          startGame = new Button("START");
           exitGame = new Button("EXIT");
           saveGame = new Button("SAVE");
           loadGame = new Button("LOAD");
             option = new Button("OPTION");   
             garage = new Button("GARAGE");
             System.out.println(width+" "+height);
             connectAccount.setMinSize(150, 75);
             connectAccount.setLayoutX(width/1.4);
             connectAccount.setLayoutY(height/5.25);
             root.getChildren().add(connectAccount);
             
             startGame.setMinSize(150, 75);
             startGame.setLayoutX(width/1.4);
             startGame.setLayoutY(height/3.5);
             startGame.setDisable(true);
             root.getChildren().add(startGame);
             
             garage.setMinSize(150, 75);
             garage.setLayoutX(width/1.4);
             garage.setLayoutY(height/2.625);
             garage.setDisable(true);
             root.getChildren().add(garage);
             
             loadGame.setMinSize(150, 75);
             loadGame.setLayoutX(width/1.4);
             loadGame.setLayoutY(height/2.1);
             loadGame.setDisable(true);
             root.getChildren().add(loadGame);
             
             saveGame.setMinSize(150, 75);
             saveGame.setLayoutX(width/1.4);
             saveGame.setLayoutY(height/1.75);
             saveGame.setDisable(true);
             root.getChildren().add(saveGame);
             
             option.setMinSize(150, 75);
             option.setLayoutX(width/1.4);
             option.setLayoutY(height/1.5);
             root.getChildren().add(option);
             
             exitGame.setMinSize(150, 75);
             exitGame.setLayoutX(width/1.4);
             exitGame.setLayoutY(height/1.3125);
             root.getChildren().add(exitGame);
             
             //PASHA
             
             ActionButton();
    }
    /*в етом методе я предаю действия кнопкам*/
    private void ActionButton()
    {
        exitGame.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                //primaryStage.close();
                
            }
        });
        root.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            public void handle(KeyEvent e) 
            {
                if(e.getCode() == KeyCode.ESCAPE)
                {
                    //primaryStage.close();
                }
            }
            
        });
        connectAccount.setOnAction(new EventHandler<ActionEvent>()
        {

            public void handle(ActionEvent e)
            {
                //new Registration(primaryStage);
            }
        });
    }
}