package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HelloController {

    // Code from https://stackoverflow.com/questions/13246211/how-to-get-stage-from-controller-during-initialization
    private Stage myStage;
    public void setStage(Stage stage) {
        myStage = stage;
    }
    private String svarTekst = "";
    private double tall1 = 0;
    private double tall2 = 0;
    private String operator;
    private boolean isMaximised = false;
    @FXML
    private Label welcomeText;
    @FXML
    private Button closeBtn;
    @FXML
    private Button maximise;
    @FXML
    private Button minimize;
    @FXML
    private AnchorPane anchorPane;

    public void btnTall(ActionEvent actionEvent) {

        Button btn = (Button) actionEvent.getSource();
        try {
            int nyttSifer = Integer.parseInt(btn.getId());
            svarTekst += btn.getId();
            welcomeText.setText(svarTekst);
        } catch (Exception exception) {
            return;
        }
    }

    public void btnPluss(ActionEvent actionEvent){
        tall1 = Double.parseDouble(welcomeText.getText());
        welcomeText.setText("");
        svarTekst = "";
        operator = "pluss";
    }

    public void btnMinus(ActionEvent actionEvent){
        tall1 = Double.parseDouble(welcomeText.getText());
        welcomeText.setText("");
        svarTekst = "";
        operator = "minus";
    }

    public void btnDel(ActionEvent actionEvent){
        tall1 = Double.parseDouble(welcomeText.getText());
        welcomeText.setText("");
        svarTekst = "";
        operator = "del";
    }

    public void btnMod(ActionEvent actionEvent){
        tall1 = Double.parseDouble(welcomeText.getText());
        welcomeText.setText("");
        svarTekst = "";
        operator = "mod";
    }

    public void btnEnOver(ActionEvent actionEvent){
        tall1 = Double.parseDouble(welcomeText.getText());
        welcomeText.setText("");
        welcomeText.setText(String.valueOf(1/ tall1));
        svarTekst = String.valueOf(1 / tall1);
    }

    public void btnIAndre(ActionEvent actionEvent){
        tall1 = Double.parseDouble(welcomeText.getText());
        welcomeText.setText("");
        welcomeText.setText(String.valueOf(Math.pow(tall1, 2)));
        svarTekst = String.valueOf(Math.pow(tall1, 2));
    }

    public void btnRot(ActionEvent actionEvent){
        tall1 = Double.parseDouble(welcomeText.getText());
        welcomeText.setText("");
        welcomeText.setText(String.valueOf(Math.sqrt(tall1)));
        svarTekst = String.valueOf(Math.sqrt(tall1));
    }

    public void btnGange(ActionEvent actionEvent){
        tall1 = Double.parseDouble(welcomeText.getText());
        welcomeText.setText("");
        svarTekst = "";
        operator = "gange";
    }

    public void btnErLik(ActionEvent actionEvent){
        tall2 = Double.parseDouble(welcomeText.getText());
        double sum = 0;
        switch (operator) {

            case "pluss":
                sum = tall1 + tall2;

            case "minus":
                sum = tall1 - tall2;

            case "del":
                sum = tall1 / tall2;

            case "gange":
                sum = tall1 * tall2;

            case "mod":
                sum = tall1 % tall2;


            welcomeText.setText(String.valueOf(sum));
            svarTekst = String.valueOf(sum);
        }
    }

    public void btnPunktum(ActionEvent actionEvent){
        svarTekst += ".";
        welcomeText.setText(svarTekst);
    }

    public void btnNegate(ActionEvent actionEvent){
        double negateTall = Double.parseDouble(welcomeText.getText());
        negateTall *= -1;
        svarTekst = String.valueOf(negateTall);
        welcomeText.setText(svarTekst);
    }

    public void btnBack(ActionEvent actionEvent){
        ArrayList<Character> charArrayListe = new ArrayList<Character>();
        for(char i : welcomeText.getText().toCharArray()){
            charArrayListe.add(i);
        }

        // Fjerner siste elementet
        int sisteElementIndex = charArrayListe.size() - 1;
        charArrayListe.remove(sisteElementIndex);
        System.out.println(charArrayListe);
        svarTekst = charArrayListe.toString();

        // Fjerner alle uønskede tegn fra Stringen
        svarTekst = svarTekst.replace("[", "");
        svarTekst = svarTekst.replace("]", "");
        svarTekst = svarTekst.replace(",", "");
        svarTekst = svarTekst.replace(" ", "");
        welcomeText.setText(svarTekst);
    }

    public void btnMax(ActionEvent actionEvent){
        if(isMaximised == true){
            myStage.setMaximized(false);
        } else {
            myStage.setMaximized(true);
        }
        isMaximised = !isMaximised;
    }

    public void btnClear(ActionEvent actionEvent){
        welcomeText.setText("");
        svarTekst = "";
        tall1 = 0;
        tall2 = 0;
    }

    public void btnClearEtTall(ActionEvent actionEvent){
        welcomeText.setText("");
        svarTekst = "";
        tall1 = 0;
        tall2 = 0;
    }

    public void exitButtonHoverEnter(){
        closeBtn.setStyle("-fx-background-color: #ff3333;");
    }

    public void exitButtonHoverExit(){
        closeBtn.setStyle("-fx-background-color: #261E1A;");
    }

    public void maximiseButtonHoverEnter(){
        maximise.setStyle("-fx-background-color: #3B3431;");
    }

    public void maximiseButtonHoverExit(){
        maximise.setStyle("-fx-background-color: #261E1A;");
    }

    public void minimizeButtonHoverEnter(){
        minimize.setStyle("-fx-background-color: #3B3431;");
    }

    public void minimizeButtonHoverExit(){
        minimize.setStyle("-fx-background-color: #261E1A;");
    }

    public void closeApplication(ActionEvent actionEvent){
        System.exit(0);
    }
}