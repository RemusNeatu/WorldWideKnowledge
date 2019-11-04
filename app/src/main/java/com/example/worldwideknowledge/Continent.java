package com.example.worldwideknowledge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Continent {
    private ArrayList<Country> countries;

    protected Continent() {
        countries = new ArrayList<Country>();
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public List<Country> getRandomCountries(int numberForQuiz) {
        numberForQuiz = Math.min(numberForQuiz, countries.size());

        ArrayList<Country> sol = (ArrayList<Country>) countries.clone();
        Collections.shuffle(sol);
        return sol.subList(0, numberForQuiz);
    }
}
