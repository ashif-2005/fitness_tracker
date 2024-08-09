package com.example.fit;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;

public class loginController {

    @FXML
    private TextField pass;

    @FXML
    private TextField user;

    @FXML
    void handleLogin() throws SQLException {
        String userText = user.getText();
        String passText = pass.getText();
        if(userText.isEmpty() || passText.isEmpty()){
            System.out.println("Enter the Credentials correctly");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter the Credentials correctly");
            alert.show();
        }
        else{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness_tracker", "root", "Ashif@2005");
            String sql = "select * from user where user_name=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,userText);
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("User Dose Not Exist");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User Does Not Exist");
                alert.show();
            }
            else {
                String sql1 = "select password from user where user_name=?";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                statement.setString(1, userText);
                ResultSet resultSet1 = statement.executeQuery();
                while (resultSet1.next()) {
                    String pas = resultSet1.getString("password");
                    if (pas.equals(passText)) {
                        HelloApplication.stage_var.setTitle("User Page");
                        HelloApplication.stage_var.setScene(HelloApplication.user);
                    } else {
                        System.out.println("Invalid UserName or Password");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Invalid UserName or Password");
                        alert.show();
                    }
                }
            }
        }
        user.clear();
        pass.clear();
    }

    @FXML
    void handelSignup(){
        HelloApplication.stage_var.setTitle("Signup");
        HelloApplication.stage_var.setScene(HelloApplication.signup);
    }
}
