package sample;

import com.sun.javafx.menu.MenuItemBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.PregameController.cash;

public class GameController implements Initializable {
    @FXML
    TextField myPortafoglio = new TextField();
    @FXML
    TextField myBet = new TextField();
    @FXML
    Button btnBet = new Button();


    int bet;

    @FXML
    public void loadBalance() {
        myPortafoglio.setText("Balance: $" + cash);
    }

    public void plus1(){
        bet +=1;
    }

    public void plus5(){
        bet +=5;
    }

    public void plus10(){
        bet +=10;
    }

    public void plus25(){
        bet +=25;
    }

    public void plus50(){
        bet +=50;
    }

    public void plus100(){
        bet +=100;
    }

    public void bet(){
        if(cash >= bet){
            myBet.setText("Hai puntato: $" + bet);
            cash = cash - bet;
            myPortafoglio.setText("$" + cash);
        }
        else
            btnBet.setDisable(true);
    }

    public void reset() {
        btnBet.setDisable(false);
        myBet.setText("");
        bet = 0;
    }

    
    public void switchToMenu(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadBalance();
    }


}
