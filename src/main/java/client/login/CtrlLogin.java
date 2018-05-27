package client.login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.dto.LoginDto;
import services.loginservice.ServiceLogin;

public class CtrlLogin {

    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;

    public void loginBtnClick(ActionEvent event){
        String userName = "";
        String Password = "";
        userName = txtUserName.getText();
        Password = txtPassword.getText();

        ServiceLogin service = new ServiceLogin();
        LoginDto resLogInDto = service.login(userName,Password);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("Your name and Password ");
        alert.setContentText(resLogInDto.getUserName() +resLogInDto.getPassword());

        alert.showAndWait();
    }



}
