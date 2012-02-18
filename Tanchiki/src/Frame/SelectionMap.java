/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.awt.Color;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.sound.midi.SysexMessage;
import tanchiki.Constants;


public class SelectionMap extends SuperScene
{
    ImageView[] view;
    int index = 0;
    Group root_noButton;
     Button button_left,
            button_right;
    public SelectionMap(Stage stage,HashMap<String,SuperScene> scenes)
    {
        init(true, 0, 0, stage, scenes, "D:/ramsstein.mp3");
        Image[] images = new Image[3];
        view = new ImageView[3];
        for (int i = 0; i < 3; i++)
        {
            images[i] = new Image(Constants.BAIZOR_DIRECT_ROOT+"img/map_"+(i+1)+".jpg",width/1.75,height/1.3125,true,true);
            view[i] = new ImageView(images[i]);
            System.out.println(view[i]);
        }
        view[0].setLayoutY(height/5);
       view[0].setLayoutX(width/5);
       root.getChildren().add(view[0]);
    
      button_left = new Button("LEFT");
      button_left.setLayoutX(width/10);
      button_left.setLayoutY(height/2.5);
      button_left.setMinSize(50, 50);
      
      button_right = new Button("RIGHT");
      button_right.setLayoutX(width/1.2);
      button_right.setLayoutY(height/2.5);
      button_right.setMinSize(50, 50);
      
      root.getChildren().add(button_left);
       root.getChildren().add(button_right);
     
              
      Action();
    }
    public void Action()
    {
               button_left.setOnKeyPressed(new EventHandler<KeyEvent>()
               {
                  public void handle(KeyEvent e)
                  {
                    if(e.getCode() == KeyCode.LEFT)
                    {
                        System.out.print("LEFT");
                    }
                  }          
               });
            button_left.setOnAction(new EventHandler<ActionEvent>()
            {

                @Override
                public void handle(ActionEvent e)
                {
                   System.out.print("LEFT");
                }
                
            });
            new LettersPane();
    }
     public class LettersPane extends SuperScene.LettersPane
    {
        public LettersPane() 
        {           
            // Обработка событий клавиатуры
            
            setOnKeyPressed(new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent ke)
                {
                    if(ke.getCode() == KeyCode.RIGHT)
                    {
                        System.out.println("RIGHT");
                    }
                    if(ke.getCode() == KeyCode.LEFT)
                    {
                        System.out.println("LEFT");
                    }
                }
            });
        }
    }
}
