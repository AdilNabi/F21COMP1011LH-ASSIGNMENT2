package com.example.f21comp1011lhassignment2;

import com.example.f21comp1011lhassignment2.Models.DictionaryResponse;
import com.example.f21comp1011lhassignment2.Utilities.APIUtility;

public class Main {
    public static void main(String[] args) {
        DictionaryResponse[] result = APIUtility.getWordFromJSON();
//        System.out.println(result);




        for(DictionaryResponse dictionaryResponse : result) {
            System.out.println(dictionaryResponse.getWord());
        }
    }
}
