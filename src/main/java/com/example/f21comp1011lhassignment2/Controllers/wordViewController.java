package com.example.f21comp1011lhassignment2.Controllers;

import com.example.f21comp1011lhassignment2.Models.DictionaryResponse;
import com.example.f21comp1011lhassignment2.Utilities.APIUtility;
import com.example.f21comp1011lhassignment2.Models.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private ListView<String> synlistView;

    @FXML
    private ListView<String> antlistView;

    @FXML
    private Label definitionText;

    @FXML
    private Label exampleLabel;


    @FXML
    private ComboBox<String> meaningBox;

    @FXML
    private ComboBox<String> defBox;

    @FXML
    private TextField searchText;

    @FXML
    private Button searchButton;

    private int selection;
    private int finalPick;

    @FXML
    void getSearchResult(ActionEvent event)
    {
        wordText.setText("BUTTON WORKS");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DictionaryResponse[] result = APIUtility.getMoviesFromJSON();

        wordText.setText(result[0].getWord());
        phoneticText.setText(result[0].getPhonetic());
        originText.setText(result[0].getOrigin());




        Meaning[] meanings = result[0].getMeanings();

        for (Meaning mean : meanings)
        {
            meaningBox.getItems().add(mean.getPartOfSpeech());
        }



        EventHandler<ActionEvent> event =
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                        selection = (meaningBox.getSelectionModel().getSelectedIndex());
                        defBox.getItems().clear();
                        definitionText.setText("");
                        exampleLabel.setText("");
                        synlistView.getItems().clear();
                        antlistView.getItems().clear();

                        Definition[] def = meanings[selection].getDefinitions();
                        for (Definition definition : def)
                        {
                            defBox.getItems().add(definition.getDefinition());
                        }

                        defBox.getSelectionModel().selectFirst();

                        if (finalPick == -1)
                        {
                            finalPick = 0;
                        }



                    }
                };

        meaningBox.setOnAction(event);



        Definition[] def = meanings[selection].getDefinitions();





        EventHandler<ActionEvent> event2 =
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                        if (finalPick == -1)
                        {
                            finalPick = 0;
                        }
                        finalPick = (defBox.getSelectionModel().getSelectedIndex());
                        if (finalPick == -1)
                        {
                            finalPick = 0;
                        }
                        definitionText.setText("");
                        exampleLabel.setText("");
                        synlistView.getItems().clear();
                        antlistView.getItems().clear();

                        definitionText.setText(def[finalPick].getDefinition());
                        exampleLabel.setText(def[finalPick].getExample());


                        if (def[finalPick].getSynonyms().length > 0)
                        {
                            List<String> synonms = List.of(def[finalPick].getSynonyms());


                            for (int i = 0; i < synonms.size(); i++) {
                                synlistView.getItems().add(synonms.get(i));
                            }

                        }




                        if (def[finalPick].getAntonyms().length > 0)
                        {
                            List<String> anynons = List.of(def[finalPick].getAntonyms());
                            for (int i = 0; i < anynons.size(); i++) {
                                antlistView.getItems().add(anynons.get(i));
                            }
                        }


//


                    }
                };

        defBox.setOnAction(event2);


//       definitionText.setText(def[finalPick].getDefinition());
//       exampleLabel.setText(def[finalPick].getExample());
//
//
//        List<String> synonms = List.of(def[finalPick].getSynonyms());
//
//        for (int i = 0; i < synonms.size(); i++) {
//            synlistView.getItems().add(synonms.get(i));
//        }
//
//
//
//        List<String> anynons = List.of(def[finalPick].getAntonyms());
//        for (int i = 0; i < anynons.size(); i++) {
//            antlistView.getItems().add(anynons.get(i));
//        }


    }
}
