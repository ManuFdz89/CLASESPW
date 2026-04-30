package org.example.tiedafx.controller;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.tiedafx.TiendaApplication;
import org.example.tiedafx.dao.UserDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField editMail, editPass;

    @FXML
    private Button btnLogin;
    private UserDAO userDAO;
    private Task<int[]> taskLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        instances();
        actions();
    }

    private void instances() {
        userDAO = new UserDAO();

    }

    private void actions() {
        btnLogin.setOnAction(event -> {
            String correo = editMail.getText();
            String pass = editPass.getText();

            // con task
            taskLogin = new Task<int[]>() {
                @Override
                protected int[] call() throws Exception {
                    return userDAO.getLogin(correo,pass);
                }
            };

            new Thread(taskLogin).start(); // no se cuanto tarda en terminar
            taskLogin.setOnSucceeded(data->{
                int[] reponse = taskLogin.getValue();
                if (reponse == null) {
                    System.out.println("No esta el usuario");
                } else {
                    Stage stage = new Stage();
                    FXMLLoader loader = null;
                    String title = "";
                    switch (reponse[1]) {
                        case 1 -> {
                            title = "Administracion";
                            loader = new FXMLLoader(TiendaApplication.class.getResource("admin-view.fxml"));
                        }
                        case 2,3 ->
                        {
                            title = "Compras";
                            loader = new FXMLLoader(TiendaApplication.class.getResource("user-view.fxml"));
                            if(reponse[1]==2){

                            } else if(reponse[1]==3){

                            }
                        }
                    }
                    try {
                        Parent parent = loader.load();
                        if(reponse[1]==2 || reponse[1]==3){
                            UserController userController = loader.getController();
                            userController.setId(reponse[0]);

                        }
                        Scene scene = new Scene(parent);
                        stage.setScene(scene);
                        stage.setTitle(title);
                        stage.show();
                        ((Stage)btnLogin.getScene().getWindow()).close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            });




        });
    }
}
