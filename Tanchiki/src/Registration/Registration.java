package Registration;
import Frame.SuperScene;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tanchiki.Constants;

/**
 *
 * @author Pavel
 */
/*В этом класе я реализую регистрацию*/
public class Registration extends SuperScene
{
    ImageView image;
    MySqlServer server;
    TextField 
            fieldAccount,
            /*Дальше кнопки отвечают за регистрацию*/
            fieldAccountRegistration,
            fieldEmail,
            fieldAnti_Bot;
    PasswordField 
            passwordField,
            passwordFieldRegistration,
            passwordFieldRegistrationCopy;        

    Text 
            textFieldlabel,
            PasswordFieldLabel,
    /*Создаем надписи вверху полей регистрации*/
            AccountLabelRegistration,
            PasswordLabelRegistration,
            PasswordLabelRegistrationCopy,
            labelEmail,
    /*Надписи о предупреждениях*/
            AccountError,
            PasswordError,
            emailError;


    Button
            connect,
            createAccount,
            back,
            option;
    
    Statement stmt;

    public Registration(Stage stage,HashMap<String,SuperScene> scenes)
    {
        init(true,0,0,stage,scenes,"D:/ramsstein.mp3");
        
//        image = new ImageView(new Image(Constants.Pasha_Root_Background_Registration,
//                width,height,false,false));
//        root.getChildren().add(image);
        connectComponent();
        registrationComponent();
         server = new MySqlServer();
         this.stmt = server.stmt;
    }
    /*В этом методе я создаю и размещаю все компоненты каторые отвечаю за вход*/
    private void connectComponent()
    {
        textFieldlabel = new Text(width/14,height/13.125,"User name");
        textFieldlabel.setFont(new Font(20));
        root.getChildren().add(textFieldlabel);

        fieldAccount = new TextField();
        fieldAccount.setMinSize(width/23.3, height/52.5);
        fieldAccount.setLayoutX(width/14);
        fieldAccount.setLayoutY(height/10.5);
        root.getChildren().add(fieldAccount);

        PasswordFieldLabel = new Text(width/14,height/5.83,"Password");
        PasswordFieldLabel.setFont(new Font(20));
        root.getChildren().add(PasswordFieldLabel);

        passwordField = new PasswordField();
        passwordField.setMinSize(width/23.3, height/52.5);
        passwordField.setLayoutX(width/14);
        passwordField.setLayoutY(height/5.25);
        root.getChildren().add(passwordField);

        connect = new Button("connect");
        connect.setLayoutX(width/10);
        connect.setLayoutY(height/4.375);
        root.getChildren().add(connect);
    }
    private void registrationComponent()
    {
        AccountLabelRegistration = new Text(width/1.75,height/13.125,"User name");
        AccountLabelRegistration.setFont(new Font(20));
        root.getChildren().add(AccountLabelRegistration);

        fieldAccountRegistration = new TextField();
        fieldAccountRegistration.setMinSize(width/23.3, height/52.5);
        fieldAccountRegistration.setLayoutX(width/1.75);
        fieldAccountRegistration.setLayoutY(height/10.5);
        root.getChildren().add(fieldAccountRegistration);

        PasswordLabelRegistration = new Text(width/23.3,height/5.83,"Enter your password");
        PasswordLabelRegistration.setFont(new Font(20));
        root.getChildren().add(PasswordLabelRegistration);

        passwordFieldRegistration = new PasswordField();
        passwordFieldRegistration.setMinSize(width/23.3, height/52.5);
        passwordFieldRegistration.setLayoutX(width/1.75);
        passwordFieldRegistration.setLayoutY( height/5.25);
        root.getChildren().add(passwordFieldRegistration);

        PasswordLabelRegistrationCopy = new Text(width/23.3,height/3.75,"repeat Enter Password");
        PasswordLabelRegistrationCopy.setFont(new Font(20));
        root.getChildren().add(PasswordLabelRegistrationCopy);

        passwordFieldRegistrationCopy = new PasswordField();
        passwordFieldRegistrationCopy.setMinSize(width/23.3, height/52.5);
        passwordFieldRegistrationCopy.setLayoutX(width/1.75);
        passwordFieldRegistrationCopy.setLayoutY(height/3.5);
        root.getChildren().add(passwordFieldRegistrationCopy);

        labelEmail = new Text(width/23.3,height/2.76,"enter your Email");
        labelEmail.setFont(new Font(20));
        root.getChildren().add(labelEmail);

        fieldEmail = new TextField();
        fieldEmail.setMinSize(width/23.3, height/52.5);
        fieldEmail.setLayoutX(width/1.75);
        fieldEmail.setLayoutY(height/2.65);
        root.getChildren().add(fieldEmail);

        createAccount = new Button("create");
        createAccount.setLayoutX(width/1.667);
        createAccount.setLayoutY(height/2.4);
        root.getChildren().add(createAccount);


        back = new Button("Back");
        back.setLayoutX(width/2.8);
        back.setLayoutY(height/2.1);
        root.getChildren().add(back);

      option = new Button("Option");
      option.setLayoutX(width/2);
      option.setLayoutY(height/2);
      option.setDisable(false);
      root.getChildren().add(option);
        
      
        registrationError();

    }
    /*В этой функции происходит поиск ошибок во время геристрации*/
    public void registrationError()
    {
        createAccount.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                String account = fieldAccountRegistration.getText();
                String password = passwordFieldRegistration.getText();
                
                try
                {
                    ResultSet executeQuery = stmt.executeQuery("SELECT * FROM Registration WHERE ACCOUNT ="
                                                     +"'"+account+"'");
                   if(executeQuery.next())
                   {
                       fieldAccountRegistration.setText("");
                   }
                   else
                   {
                       stmt.executeUpdate("INSERT INTO registration (ACCOUNT,PASSWORD) VALUES('"
                               + account +"','"+ password+"')");        
                   }          
                }
                catch(Exception r)
                {            
                    r.printStackTrace();
                }
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                //returnMenu.start(primaryStage);
            }
        });
        option.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
               updateScene("SelectionMap");
            }
        });
        connect.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                String account = fieldAccount.getText();
                String password =  passwordField.getText();
                try
                {
                    if(account.equals("admin")&&password.equals("admin"))
                    {
                        option.setDisable(false);
                    }
                       ResultSet executeQuery = stmt.executeQuery("SELECT PASSWORD FROM new_schema.Registration WHERE ACCOUNT ="
                                                     +"'"+account+"'");
                       executeQuery.next();
                       if(executeQuery.getString(1).equals(password))
                       {
                           option.setDisable(false);
                       }
                       else
                       {
                           fieldAccount.setText("");
                           passwordField.setText("");
                       }
                }
                catch(Exception exc)
                {
                     fieldAccount.setText("");
                     passwordField.setText("");
                }
            }
        });
    }
}