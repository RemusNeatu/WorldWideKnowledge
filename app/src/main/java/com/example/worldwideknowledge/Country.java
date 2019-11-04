package com.example.worldwideknowledge;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

class Country {
    private String name;
    private String capital;
    private String region;
    private String subregion;

    public Country(String name, String capital, String region, String subregion) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.subregion = subregion;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", region='" + region + '\'' +
                ", subregion='" + subregion + '\'' +
                '}';
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return Objects.equals(getName(), country.getName()) &&
                Objects.equals(getCapital(), country.getCapital()) &&
                Objects.equals(getRegion(), country.getRegion()) &&
                Objects.equals(getSubregion(), country.getSubregion());
    }
}
