package com.example.f21comp1011lhassignment2.Utilities;

import com.example.f21comp1011lhassignment2.Models.DictionaryResponse;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    public static DictionaryResponse[] getWordFromJSON()
    {
        Gson gson = new Gson();
        DictionaryResponse[] result = null;

        try(
                FileReader fileReader = new FileReader("apiResponse.json");
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            result = gson.fromJson(jsonReader, DictionaryResponse[].class);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
            return result;

    }

    public static DictionaryResponse[] getWordFromAPI(String searchText) throws IOException, InterruptedException {
        DictionaryResponse[] result = null;

        searchText = searchText.replace(" ", "%20");

        String uri = "https://api.dictionaryapi.dev/api/v2/entries/en/"+searchText;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers
                .ofFile(Paths.get("apiResponse.json")));

        result = getWordFromJSON();
        return result;
    }


}
