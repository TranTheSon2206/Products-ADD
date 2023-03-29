package products.demo;

import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class productController {
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField price;
    @FXML
    private TextField descripstion;
    @FXML
    private TextField qty;
    @FXML
    private TextField ketqua;
    public void onAddBtn(ActionEvent actionEvent) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","");
            Scanner scanner=new Scanner(System.in);
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO `products` (`productId`, `name`, `price`, `description`, `qty`) VALUES (?, ?, ?, ?, ?)");

//


            pstmt.setString(1, id.getText());
            pstmt.setString(2, name.getText());
            pstmt.setString(3, price.getText());
            pstmt.setString(4,descripstion.getText());
            pstmt.setString(5, qty.getText());
            pstmt.addBatch();


            int check = pstmt.executeUpdate();
            if (check >= 1) {
                System.out.println("Update row " + check);
            } else {
                System.out.println("No Update");
            }
            conn.commit();



        }
        catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void onUpdateBtn(ActionEvent actionEvent) {
    }

    public void onDeleteBtn(ActionEvent actionEvent) {
    }
}