package com.necipfazilakay;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class cities {
    private String nufus;
    private String binaSayisi;
    private String yogunluk;

    abstract String population();
    abstract String buildingNumber();
    abstract String density();

    ArrayList<String> cityInformations = new ArrayList<>();


    public String pullCityInfos(String wantedInfo){

        try {
            FileInputStream fileInputStream = new FileInputStream("cities.txt");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String str;
            while (true){
                str = bufferedReader.readLine();
                if (str == null)
                    break;
                cityInformations.add(str);
            }
        }catch (Exception e){
            System.err.println(e);
        }

        return wantedInfo;
    }




    public String getNufus() {
        return nufus;
    }
    public void setNufus(String nufus) {
        this.nufus = nufus;
    }
    public String getBinaSayisi() {
        return binaSayisi;
    }
    public void setBinaSayisi(String binaSayisi) {
        this.binaSayisi = binaSayisi;
    }
    public String  getYogunluk() {
        return yogunluk;
    }
    public void setYogunluk(String yogunluk) {
        this.yogunluk = yogunluk;
    }




}
