package com.necipfazilakay;

public class Istanbul extends cities{

    public Istanbul(){
        setNufus(pullCityInfos("population"));
        setBinaSayisi(pullCityInfos("buildingNumber"));
        setYogunluk(pullCityInfos("density"));
    }

    @Override
    String population() {
        setNufus(pullCityInfos("population"));

        return getNufus();
    }


    @Override
    String buildingNumber() {
        setBinaSayisi(pullCityInfos("buildingNumber"));
        return getBinaSayisi();
    }

    @Override
    String density() {
        setYogunluk(pullCityInfos("density"));
        return getYogunluk();
    }

    @Override
    public String pullCityInfos(String selected) {

        super.pullCityInfos(selected);
        String[] asd;
        asd = cityInformations.get(1).split("&&");

        if (selected == "population")
            return asd[1];
        else if (selected == "buildingNumber")
            return asd[2];
        else if (selected == "density")
            return asd[3];


        return selected;
    }
}
