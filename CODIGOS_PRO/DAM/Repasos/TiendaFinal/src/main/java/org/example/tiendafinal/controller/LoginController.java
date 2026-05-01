package org.example.tiendafinal.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.tiendafinal.MainApplication;
import org.example.tiendafinal.dao.UsuarioDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField editCorreo, editPass;

    @FXML
    private Button btnLogin;

    private UsuarioDAO usuarioDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instances();
        actions();
    }

    private void instances() {
        usuarioDAO = new UsuarioDAO();
    }

    private void actions() {
        btnLogin.setOnAction(event -> {
            // llamo al DAO para hacer el login -> el metodo del DAO tendra que darme algo
            // validar campos
            int[] datos = usuarioDAO.getLogin(editCorreo.getText(), editPass.getText());
            if (datos != null) {
                FXMLLoader loader = null;
                String title = "";
                switch (datos[1]) {
                    case 1 -> {
                        title = "Administracion de tienda";
                        loader = new FXMLLoader(MainApplication.class.getResource("admin-view.fxml"));
                    }
                    case 2 -> {
                        title = "Compras y carrito";
                        loader = new FXMLLoader(MainApplication.class.getResource("user-view.fxml"));
                    }
                }
                try {
                    Parent root = loader.load();
                    Stage ventana = new Stage();
                    Scene scene = new Scene(root);
                    ventana.setScene(scene);
                    ventana.setTitle(title);
                    ventana.show();
                    ((Stage)btnLogin.getScene().getWindow()).close();

                } catch (IOException e) {
                    System.out.println("No se encuentra el fichero");
                }
            } else {
                System.out.println("No hay usuario");
            }
        });
        // btnLogin.addEventHandler(MouseEvent.ANY, event->{});


    }
}
