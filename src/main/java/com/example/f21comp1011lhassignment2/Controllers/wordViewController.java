package com.example.f21comp1011lhassignment2.Controllers;

import com.example.f21comp1011lhassignment2.Models.DictionaryResponse;
import com.example.f21comp1011lhassignment2.Utilities.APIUtility;
import com.example.f21comp1011lhassignment2.Models.*;
import com.example.f21comp1011lhassignment2.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.TextFlow;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class wordViewController implements Initializable{

    @FXML
    private Label errorLabel;

    @FXML
    private Label wordText;

    @FXML
    private Label phoneticText;

    @FXML
    private Label originText;

    @FXML
    private TextField searchText;

    @FXML
    private Button searchButton;

    @FXML
    private Label definitionText;

    private int meaningSelection;
    private int definitionSelection;

    private DictionaryResponse[] word;
    private Meaning[] meanings;
    private Definition[] definitions;

    @FXML
    void getSearchResult(ActionEvent event) throws IOException, InterruptedException
    {
        try{
            word = APIUtility.getMoviesFromAPI(searchText.getText());
            displayData();
        } catch(IllegalStateException e)
        {
            errorLabel.setVisible(true);
            errorLabel.setText("Word not found.");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        errorLabel.setVisible(false);
        word = APIUtility.getWordFromJSON();

        displayData();
    }

    public void displayData()
    {
        wordText.setText(word[0].getWord());
        phoneticText.setText(word[0].getPhonetic());
        originText.setText(word[0].getOrigin());


        meanings = word[0].getMeanings();
        definitions = meanings[meaningSelection].getDefinitions();
        definitionText.setText(definitions[0].getDefinition());
    }



    @FXML
    void changeToDefinitionView(ActionEvent event) throws IOException
    {
        SceneChanger.changeScenes(event,"definition-view.fxml","Detail Word View");
    }


}
