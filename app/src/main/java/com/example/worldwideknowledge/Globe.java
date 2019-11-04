package com.example.worldwideknowledge;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Globe {
    private static Continent africa;
    private static Continent asia;
    private static Continent europe;
    private static Continent nortAmerica;
    private static Continent oceania;
    private static Continent southAmerica;

    static {
        africa = new Continent();
        asia = new Continent();
        nortAmerica = new Continent();
        europe = new Continent();
        oceania = new Continent();
        southAmerica = new Continent();
    }

    public static void addCountry(Country country, String continent) {
        if (continent.equals("Africa")) {
            africa.addCountry(country);
            return;
        }
        if (continent.equals("Asia")) {
            asia.addCountry(country);
            return;
        }
        if (continent.equals("Europe")) {
            europe.addCountry(country);
            return;
        }
        if (continent.equals("North America")) {
            nortAmerica.addCountry(country);
            return;
        }
        if (continent.equals("Oceania")) {
            oceania.addCountry(country);
            return;
        }
        if (continent.equals("South America")) {
            southAmerica.addCountry(country);
            return;
        }
    }

    public static List<Country> getRandomCountries(int numberForQuiz, String continent) {
        if (continent.equals("Africa")) {
            return africa.getRandomCountries(numberForQuiz);
        }
        if (continent.equals("Asia")) {
            return asia.getRandomCountries(numberForQuiz);
        }
        if (continent.equals("Europe")) {
            return europe.getRandomCountries(numberForQuiz);
        }
        if (continent.equals("North America")) {
            return nortAmerica.getRandomCountries(numberForQuiz);
        }
        if (continent.equals("Oceania")) {
            return oceania.getRandomCountries(numberForQuiz);
        }
        if (continent.equals("South America")) {
            return southAmerica.getRandomCountries(numberForQuiz);
        }
        return new ArrayList<Country>();
    }
}
