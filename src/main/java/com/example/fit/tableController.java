package com.example.fit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class tableController {

    @FXML
    private TableColumn<student, String> dept;

    @FXML
    private TableColumn<student, String> name;

    @FXML
    private TableView<student> table;

    @FXML
    private TableColumn<student, String> year;

    @FXML
    public void initialize() {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));

        try {
            List<student> students = getStudents();
            ObservableList<student> data = FXCollections.observableArrayList(students);
            table.setItems(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<student> getStudents() throws SQLException {
        List<student> students = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ashif", "root", "Ashif@2005");
        String sql = "select * from fitness";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String dept = resultSet.getString("dept");
            String year = resultSet.getString("year");
            students.add(new student(name, dept, year));
        }
        return students;
    }



}
