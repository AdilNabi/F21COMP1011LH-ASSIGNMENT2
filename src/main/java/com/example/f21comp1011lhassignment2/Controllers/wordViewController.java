package com.example.f21comp1011lhassignment2.Controllers;

import com.example.f21comp1011lhassignment2.Models.DictionaryResponse;
import com.example.f21comp1011lhassignment2.Utilities.APIUtility;
import com.example.f21comp1011lhassignment2.Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.TextFlow;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class wordViewController implements Initializable{


    @FXML
    private Label wordText;

    @FXML
    private Label phoneticText;

    @FXML
    private Label originText;

    @FXML
    private ListView<String> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DictionaryResponse[] result = APIUtility.getMoviesFromJSON();

        wordText.setText(result[0].getWord());
        phoneticText.setText(result[0].getPhonetic());
        originText.setText(result[0].getOrigin());

        Meaning[] example = result[0].getMeanings();

       Definition[] def = example[0].getDefinitions();



        List<String> synonms = List.of(def[0].getSynonyms());

        for (int i = 0; i < synonms.size(); i++) {
            listView.getItems().add(synonms.get(i));
        }

    }
}
