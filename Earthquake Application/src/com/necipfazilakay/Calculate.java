package com.necipfazilakay;

import java.io.*;
import java.util.ArrayList;

public class Calculate  {
    int totalEarthquakes = 0;
    int totalNumOfEarthquakes2020 = 0;



    ArrayList<String> allEarthquakesInTwentyYears = new ArrayList<>();
    ArrayList<Integer> allEarthquakesIn2020 = new ArrayList<>();

    ArrayList<String> low = new ArrayList<>();
    ArrayList<String> middle = new ArrayList<>();
    ArrayList<String> high = new ArrayList<>();

    String[] change = new String[4];

    public Calculate(){
        // twentyYearAverage();
    }

    /**
     * This method is used to convert values
     * in an array to double and sum them up.
     * @param arr an ArrayList
     * @return double sum of elements in ArrayList.
     */
    public double summingFunc(ArrayList arr){
        Double sum = 0.0;
        for (Object i:arr ) {
            if (isStringInt(String.valueOf(i))){
                sum += Double.valueOf(i.toString());
            }
        }

        return sum;
    }
    /**
     * This method is used to gather
     * data of last 20 years earthquake information from text files and
     * add these information to corresponding arraylists
     */
    public void twentyYearAverage(){
        try {
            FileInputStream fileInputStream = new FileInputStream("2000-2020allinfos.txt");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String str;
            int i  = 0;
            while (true){
                str = bufferedReader.readLine();
                if (str == null)
                    break;
                change = str.split("&&");
                allEarthquakesInTwentyYears.add(change[1]);
                low.add(change[2]);
                middle.add(change[3]);
                high.add(change[4]);

                i++;
            }
        }catch ( Exception e){
            System.err.println(e);
        }
    }



    public int totalEarthquakes(){
        for (Object i : allEarthquakesInTwentyYears) {
            if (isStringInt(String.valueOf(i))){
                totalEarthquakes += Integer.valueOf(i.toString());
            }
        }
        return totalEarthquakes;
    }


    public double averageFunc(ArrayList arr){
        Double average = 0.0;
        for (Object i:arr ) {
            if (isStringInt(String.valueOf(i))){
                average += Double.valueOf(i.toString());
            }
        }
        average = average/ arr.size();
        return average; // gönderilen arrayin içerisindeki sayıların ortalamasını alır
    }

    public static boolean isStringInt(String s){
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }





















    public ArrayList twentyYearTxt(){
      try {
          FileInputStream fileInputStream = new FileInputStream("2020.txt");
          DataInputStream dataInputStream = new DataInputStream(fileInputStream);
          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
          String str;
          while (true){
              str = bufferedReader.readLine();
              if (str == null)
                  break;
              allEarthquakesIn2020.add(Integer.valueOf(str));
          }
      }catch (Exception e){
          System.err.println(e);
      }
        return allEarthquakesIn2020;
    }

    public int totalNumOfTwentyYear(){
        totalNumOfEarthquakes2020 = 0;
        for (Object i : twentyYearTxt()) {
            totalNumOfEarthquakes2020 += Integer.valueOf(i.toString());
        }
        return totalNumOfEarthquakes2020;
    }


}
