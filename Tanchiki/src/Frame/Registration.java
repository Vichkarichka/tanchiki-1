package Frame;

import java.awt.Dimension;
import java.awt.Toolkit;
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
import tanchiki.Constants;
import tanchiki.SuperScene;

/**
 *
 * @author Pavel
 */
/*В этом класе я реализую регистрацию*/
public class Registration extends SuperScene
{
    ImageView image;

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
            back;


    public Registration()
    {
        init(true,0,0);

        image = new ImageView(new Image(Constants.Pasha_Root_Background_Registration,
                width,height,false,false));
        root.getChildren().add(image);
        connectComponent();
        registrationComponent();
    }
    /*В этом методе я создаю и размещаю все компоненты каторые отвечаю за вход*/
    private void connectComponent()
    {
        textFieldlabel = new Text(100,80,"User name");
        textFieldlabel.setFont(new Font(20));
        root.getChildren().add(textFieldlabel);

        fieldAccount = new TextField();
        fieldAccount.setMinSize(60, 20);
        fieldAccount.setLayoutX(100);
        fieldAccount.setLayoutY(100);
        root.getChildren().add(fieldAccount);

        PasswordFieldLabel = new Text(100,180,"Password");
        PasswordFieldLabel.setFont(new Font(20));
        root.getChildren().add(PasswordFieldLabel);

        passwordField = new PasswordField();
        passwordField.setMinSize(60, 20);
        passwordField.setLayoutX(100);
        passwordField.setLayoutY(200);
        root.getChildren().add(passwordField);

        connect = new Button("connect");
        connect.setLayoutX(140);
        connect.setLayoutY(240);
        root.getChildren().add(connect);
    }
    private void registrationComponent()
    {
        AccountLabelRegistration = new Text(800,80,"User name");
        AccountLabelRegistration.setFont(new Font(20));
        root.getChildren().add(AccountLabelRegistration);

        fieldAccountRegistration = new TextField();
        fieldAccountRegistration.setMinSize(60, 20);
        fieldAccountRegistration.setLayoutX(800);
        fieldAccountRegistration.setLayoutY(100);
        root.getChildren().add(fieldAccountRegistration);

        PasswordLabelRegistration = new Text(800,180,"Enter your password");
        PasswordLabelRegistration.setFont(new Font(20));
        root.getChildren().add(PasswordLabelRegistration);

        passwordFieldRegistration = new PasswordField();
        passwordFieldRegistration.setMinSize(60, 20);
        passwordFieldRegistration.setLayoutX(800);
        passwordFieldRegistration.setLayoutY(200);
        root.getChildren().add(passwordFieldRegistration);

        PasswordLabelRegistrationCopy = new Text(800,280,"repeat Enter Password");
        PasswordLabelRegistrationCopy.setFont(new Font(20));
        root.getChildren().add(PasswordLabelRegistrationCopy);

        passwordFieldRegistrationCopy = new PasswordField();
        passwordFieldRegistrationCopy.setMinSize(60, 20);
        passwordFieldRegistrationCopy.setLayoutX(800);
        passwordFieldRegistrationCopy.setLayoutY(300);
        root.getChildren().add(passwordFieldRegistrationCopy);

        labelEmail = new Text(800,380,"enter your Email");
        labelEmail.setFont(new Font(20));
        root.getChildren().add(labelEmail);

        fieldEmail = new TextField();
        fieldEmail.setMinSize(60, 20);
        fieldEmail.setLayoutX(800);
        fieldEmail.setLayoutY(400);
        root.getChildren().add(fieldEmail);

        createAccount = new Button("create");
        createAccount.setLayoutX(840);
        createAccount.setLayoutY(440);
        root.getChildren().add(createAccount);


        back = new Button("Back");
        back.setLayoutX(500);
        back.setLayoutY(500);
        root.getChildren().add(back);

        registrationError();

    }
    /*В этой функции происходит поиск ошибок во время геристрации*/
    public void registrationError()
    {
        createAccount.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                /*Тут делать все проверки*/
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                //returnMenu.start(primaryStage);
            }
        });
    }
}