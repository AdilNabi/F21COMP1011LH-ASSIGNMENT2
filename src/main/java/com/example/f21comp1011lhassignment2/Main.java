package com.example.f21comp1011lhassignment2;

public class Main {
    public static void main(String[] args) {
        DictionaryResponse[] result = APIUtility.getMoviesFromJSON();
//        System.out.println(result);




        for(DictionaryResponse dictionaryResponse : result) {
            System.out.println(dictionaryResponse.getWord());
        }
    }
}