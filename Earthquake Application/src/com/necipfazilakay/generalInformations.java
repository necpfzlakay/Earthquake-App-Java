package com.necipfazilakay;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
public class Data {

    public static void main(String[] args) {


        cities city = new Ankara();
        System.out.println("population: " + city.population());
        System.out.println("number of building: " + city.buildingNumber());
        System.out.println("yogunluk: " + city.density());

        generalInformations general = new generalInformations();
        System.out.println(general.getYirmiYil() + " yirmiyil");
        System.out.println(general.getOrtalamaDepremSayisi() + " ort deprem");
        System.out.println(general.getAverageHighIntensity() + " high");
        System.out.println(general.getAverageMiddleIntensity() + " middle");
        System.out.println(general.getAverageLowIntensity() + " low");
        System.out.println(general.getAverageintensity() + " average intensity");
        System.out.println(general.getIkiBinYirmi());
    }

}
*/
public class generalInformations extends Calculate{
    private int yirmiYil; // 20 yılda gerçekleşen toplam deprem sayısı
    private int ikiBinYirmi; // 2020 de gerçekleşen toplam deprem sayısı
    private double averageintensity;
    private double averageLowIntensity; // 3.9 ve aşağı yıllık deprem ortalaması
    private double averageMiddleIntensity; // 4.0 ve 5.9 arası
    private double averageHighIntensity; // 6.0 ve 10 arası
    private double ortalamaDepremSayisi; // yıllık ortalama deprem sayısı

    public generalInformations(){


        twentyYearAverage();
        setYirmiYil(totalEarthquakes());
        setOrtalamaDepremSayisi(super.averageFunc(allEarthquakesInTwentyYears));
        setAverageintensity( avgTotalIntensity( ));
        setAverageLowIntensity(super.averageFunc(low));
        setAverageMiddleIntensity(super.averageFunc(middle));
        setAverageHighIntensity(super.averageFunc(high));
        setIkiBinYirmi(super.totalNumOfTwentyYear());
    }

    double lowTotal = 0.0;
    double middleTotal = 0.0;
    double HighTotal = 0.0;
    /**
     * This method is used to calculate
     * average of intensities of earthquakes in last 20 years.
     * @return int This returns the result .
     */
    public double avgTotalIntensity() {
        lowTotal = super.summingFunc(low);
        middleTotal = super.summingFunc(middle);
        HighTotal = super.summingFunc(high);
        lowTotal = (lowTotal*100)/228804;
        middleTotal = (middleTotal*100)/228804;
        HighTotal = (HighTotal*100)/228804;
        return (middleTotal+lowTotal+HighTotal)/30;
    }

    /**
     * This method is used to send number of earthquakes in last 20 years
     * @return ArrayList number of earthquakes year by year for last 20 years as arraylist.
     */
    public ArrayList pushTwentyYear(){
        return allEarthquakesInTwentyYears;
    }
    /**
     * This method is used to send number of earthquakes in last 20 years
     * @return ArrayList number of earthquakes year by year for last 20 years as arraylist.
     */
    public ArrayList push2020(){
        return allEarthquakesIn2020;
    }

    public double getAverageintensity() {
        return averageintensity;
    }
    public void setAverageintensity(double averageintensity) {
        this.averageintensity = averageintensity;
    }
    public double getAverageLowIntensity() {
        return averageLowIntensity;
    }
    public void setAverageLowIntensity(double averageLowIntensity) {
        this.averageLowIntensity = averageLowIntensity;
    }
    public double getAverageMiddleIntensity() {
        return averageMiddleIntensity;
    }
    public void setAverageMiddleIntensity(double averageMiddleIntensity) {
        this.averageMiddleIntensity = averageMiddleIntensity;
    }
    public double getAverageHighIntensity() {
        return averageHighIntensity;
    }
    public void setAverageHighIntensity(double averageHighIntensity) {
        this.averageHighIntensity = averageHighIntensity;
    }
    public int getYirmiYil() {
        return yirmiYil;
    }
    public void setYirmiYil(int yirmiYil) {
        this.yirmiYil = yirmiYil;
    }
    public int getIkiBinYirmi() {
        return ikiBinYirmi;
    }
    public void setIkiBinYirmi(int ikiBinYirmi) {
        this.ikiBinYirmi = ikiBinYirmi;
    }
    public double getOrtalamaDepremSayisi() {
        return ortalamaDepremSayisi;
    }
    public void setOrtalamaDepremSayisi(double ortalamaDepremSayisi) {
        this.ortalamaDepremSayisi = ortalamaDepremSayisi;
    }
}







