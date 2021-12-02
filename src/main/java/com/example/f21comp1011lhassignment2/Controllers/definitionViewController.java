package com.example.f21comp1011lhassignment2.Controllers;

import com.example.f21comp1011lhassignment2.Models.Definition;
import com.example.f21comp1011lhassignment2.Models.DictionaryResponse;
import com.example.f21comp1011lhassignment2.Models.Meaning;
import com.example.f21comp1011lhassignment2.Utilities.APIUtility;
import com.example.f21comp1011lhassignment2.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class definitionViewController  implements Initializable {
    @FXML
    private Label wordText;

    @FXML
    private Label phoneticText;

    @FXML
    private Label originText;

    @FXML
    private Label definitionText;

    @FXML
    private Label exampleText;

    @FXML
    private ComboBox<String> meaningBox;

    @FXML
    private ComboBox<String> definitionBox;

    @FXML
    private ListView<String> antonymsListView;

    @FXML
    private ListView<String> synonymsListView;

    private int meaningSelection;
    private int definitionSelection;

    private DictionaryResponse[] word;
    private Meaning[] meanings;
    private Definition[] definitions;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        word = APIUtility.getWordFromJSON();

        wordText.setText(word[0].getWord());
        phoneticText.setText(word[0].getPhonetic());
        originText.setText(word[0].getOrigin());

        definitionText.setText("");
        exampleText.setText("");

        populateMeaningBox();



        EventHandler<ActionEvent> event =
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                        meaningSelection = (meaningBox.getSelectionModel().getSelectedIndex());
                        clearFieldMeaningSelect();
                        meaningIndexNullFix();
                        definitions = meanings[meaningSelection].getDefinitions();
                        populateDefinitionBox();
                        definitionBox.getSelectionModel().selectFirst();
                        definitionIndexNullFix();
                    }
                };

        meaningBox.setOnAction(event);



        EventHandler<ActionEvent> event2 =
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                        definitionIndexNullFix();
                        definitionSelection = (definitionBox.getSelectionModel().getSelectedIndex());
                        definitionIndexNullFix();
                        definitionText.setText("");
                        exampleText.setText("");
                        synonymsListView.getItems().clear();
                        antonymsListView.getItems().clear();

                        definitionText.setText(definitions[definitionSelection].getDefinition());
                        exampleText.setText(definitions[definitionSelection].getExample());

                        populateSynonymsList();
                        populateAntonymsList();

                    }
                };

        definitionBox.setOnAction(event2);

    }

    public void clearAllFields(){
        wordText.setText("");
        phoneticText.setText("");
        originText.setText("");
        definitionText.setText("");
        exampleText.setText("");
        meaningBox.getItems().clear();
        definitionBox.getItems().clear();
        synonymsListView.getItems().clear();
        antonymsListView.getItems().clear();

    }

    public void clearFieldMeaningSelect()
    {
        definitionText.setText("");
        exampleText.setText("");

        definitionBox.getItems().clear();

        synonymsListView.getItems().clear();
        antonymsListView.getItems().clear();
    }

    public void populateMeaningBox()
    {
        meanings = word[0].getMeanings();

        for (Meaning mean : meanings)
        {
            meaningBox.getItems().add(mean.getPartOfSpeech());
        }
    }

    public void populateDefinitionBox()
    {
        Definition[] def = meanings[meaningSelection].getDefinitions();
        for (Definition definition : def)
        {
            definitionBox.getItems().add(definition.getDefinition());
        }

    }


    public void definitionIndexNullFix()
    {
        if (definitionSelection == -1)
        {
            definitionSelection = 0;
        }
    }

    public void meaningIndexNullFix()
    {

        if (meaningSelection == -1)
        {
            meaningSelection = 0;
        }
    }



    public void populateSynonymsList()
    {
        if (definitions[definitionSelection].getSynonyms().length > 0)
        {
            List<String> synonyms = List.of(definitions[definitionSelection].getSynonyms());

            for (int i = 0; i < synonyms.size(); i++) {
                synonymsListView.getItems().add(synonyms.get(i));
            }
        }
    }


    public void populateAntonymsList()
    {
        if (definitions[definitionSelection].getAntonyms().length > 0)
        {
            List<String> antonyms = List.of(definitions[definitionSelection].getAntonyms());
            for (int i = 0; i < antonyms.size(); i++) {
                antonymsListView.getItems().add(antonyms.get(i));
            }
        }
    }




    @FXML
    void changeToWordView(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"word-view.fxml","Search Word View");
    }
}

