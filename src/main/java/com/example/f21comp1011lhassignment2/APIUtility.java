package com.example.f21comp1011lhassignment2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class APIUtility {

    public static DictionaryResponse[] getMoviesFromJSON()
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

}