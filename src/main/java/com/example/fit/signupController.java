package com.example.fit;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;

public class signupController {

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    void handelLogin(){
        HelloApplication.stage_var.setTitle("Login");
        HelloApplication.stage_var.setScene(HelloApplication.login);
    }

    @FXML
    void handelSignup() throws SQLException {
        String User = username.getText();
        String Pass = password.getText();
        if(User.isEmpty() || Pass.isEmpty()){
            System.out.println("Enter the Credentilas correctly");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter the Credentilas correctly");
            alert.show();
        }
        else {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness_tracker", "root", "Ashif@2005");
            String sql = "select * from user where user_name=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, User);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.isBeforeFirst()) {
                System.out.println("User Already Exist");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User Name Already Exist");
                alert.show();
            } else {
                String sql1 = "insert into user values (?,?)";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                statement1.setString(1, User);
                statement1.setString(2, Pass);
                statement1.execute();
                HelloApplication.stage_var.setTitle("User Page");
                HelloApplication.stage_var.setScene(HelloApplication.user);
                username.clear();
                password.clear();
            }
        }
    }
}
