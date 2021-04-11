package com.newests;
import org.json.*;
import java.io.*;
import java.util.ArrayList;


public class LastEarthquakes {

    /**
     * This method is used to scan text files and
     * gather recent earthquake information from there,
     * adjust them and keep as ArrayList.
     * @return ArrayList This returns adjusted ArrayList.
     */
    public static ArrayList<String> newest(){


        String str;
        String[] arrays;
        ArrayList<String> yer = new ArrayList<>();
        ArrayList<String> enlem = new ArrayList<>();
        ArrayList<String> boylam = new ArrayList<>();
        ArrayList<String> derinlik = new ArrayList<>();
        ArrayList<String> siddet = new ArrayList<>();
        ArrayList<String> tarih = new ArrayList<>();
        ArrayList<String> saat = new ArrayList<>();

        ArrayList<String> result = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("lastEqarthquakes.txt");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            str = bufferedReader.readLine();
            arrays = str.split("},\\{");
            for (Object i: arrays ) {

                //System.out.println("{" +i + "}");
                String first = "lastEqarthquakes.txt";
                JSONObject json =  new JSONObject("{"+i+"}");

                yer.add(json.getString("yer"));
                enlem.add(json.getString("enlem"));
                boylam.add(json.getString("boylam"));
                derinlik.add(json.getString("derinlik"));
                siddet.add(json.getString("siddet"));
                tarih.add(json.getString("boylam"));
                saat.add(json.getString("tarih"));
            }
            for (int i = 0; i<arrays.length;i++){
                result.add("-----------\n");
                result.add("Place: " +yer.get(i) + "\n");
                result.add("Latitude: " +enlem.get(i) + "\n");
                result.add("Longitude: "+boylam.get(i) + "\n");
                result.add("Depth: "+derinlik.get(i) + "\n");
                result.add("Intensity: "+siddet.get(i) + "\n");
                result.add("Date: "+tarih.get(i) + "\n");
                result.add("Hour: "+saat.get(i) + "\n");
                result.add("-----------\n");

            }
        }catch (Exception e){
            System.err.println(e);
        }
        return result;
    }
}




