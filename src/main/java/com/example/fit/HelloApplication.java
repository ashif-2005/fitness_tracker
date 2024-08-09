package com.example.fit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage stage_var;
    public static Scene login;
    public static Scene signup;
    public static Scene table;
    public static Scene user;
    public static Scene workout;
    public static Scene category;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("getStarted.fxml"));
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("signup.fxml"));
        FXMLLoader fxmlLoader3 = new FXMLLoader(HelloApplication.class.getResource("table.fxml"));
        FXMLLoader fxmlLoader4 = new FXMLLoader(HelloApplication.class.getResource("user.fxml"));
        FXMLLoader fxmlLoader5 = new FXMLLoader(HelloApplication.class.getResource("workout.fxml"));
        FXMLLoader fxmlLoader6 = new FXMLLoader(HelloApplication.class.getResource("category.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        Scene scene1 = new Scene(fxmlLoader1.load());
        Scene scene2 = new Scene(fxmlLoader2.load());
        Scene scene3 = new Scene(fxmlLoader3.load());
        Scene scene4 = new Scene(fxmlLoader4.load());
        Scene scene5 = new Scene(fxmlLoader5.load());
        Scene scene6 = new Scene(fxmlLoader6.load());

        stage_var = stage;
        login = scene1;
        signup = scene2;
        table = scene3;
        user = scene4;
        workout = scene5;
        category = scene6;

        stage.setTitle("Fitness Tracker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}