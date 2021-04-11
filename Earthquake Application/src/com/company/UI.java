package com.company;

import com.necipfazilakay.*;
import com.newests.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 * <h1>Earthquake Application</h1>
 * The Earthquake Application shows recent earthquakes in Turkey,
 * Shows related information to earth quakes about cities in Turkey,
 * Shows general information about earthquakes in Turkey and
 * Demonstrates charts about earthquakes in Turkey.
 * <p>
 * @author Toygar Simsek, Necip Fazil Akay, Berkcan Yilmaz, Merve Cilengir, Emre Sekeroglu
 * @version 1.0
 * @since 2021-01-10
 */

public class UI{

    private JPanel window;
    private JButton istanbulButton;
    private JButton ankaraButton;
    private JButton izmirButton;
    private JLabel cityName;
    private JLabel date;
    private JLabel population;
    private JTextPane textPane;
    private JPanel statisticsDown;
    private JPanel statisticsUp;
    private JButton chart1;
    private JButton chart2;
    private JLabel buildingNumber;
    private JLabel density;
    private JLabel lasttwentyyears;
    private JLabel lastyear;
    private JLabel peopleperbuilding;
    private JLabel medium;
    private JLabel high;
    private JLabel average;
    private JLabel low;
    private JLabel avarageintensity;


    /**
     * This method is used to create charts.
     *
     * @param data Values which is shown in graph
     * @param bottomLabels Labels to write bottom of the chart
     * @param upperLimit Max value that will be shown in chart
     * @param leftLabelNum Number of labels to write left of the chart
     */
    public void graph(ArrayList<Integer> data, ArrayList<String> bottomLabels,int upperLimit,int leftLabelNum) {

        for(int i=0; i<20; i++) {
            statisticsUp.getComponent(i).setVisible(true);
            statisticsDown.getComponent(i).setVisible(true);
        }

        for(int i=19; i>data.size()-1; i--) {
            statisticsUp.getComponent(i).setVisible(false);
            statisticsDown.getComponent(i).setVisible(false);
        }


        JPanel leftLabels = (JPanel) statisticsUp.getComponent(20);

        for(int i=0; i<15; i++) {
            leftLabels.getComponent(i).setVisible(true);
        }
        for(int i=14; i>leftLabelNum-1; i--) {
            leftLabels.getComponent(i).setVisible(false);
        }

        for(int i=0; i<leftLabelNum; i++) {
            JLabel leftLabel = (JLabel) leftLabels.getComponent(i);
            leftLabel.setText(String.valueOf((upperLimit/leftLabelNum)*(leftLabelNum-i)));
        }

        for(int i=0; i<bottomLabels.size(); i++) {
                JLabel bottomLabel = (JLabel) statisticsDown.getComponent(i);
                bottomLabel.setText(bottomLabels.get(i));
        }


        for(int i = 0; i<data.size(); i++) {
            int amount =  Integer.parseInt(String.valueOf(data.get(i)));
            int ratio = 15*amount/upperLimit;
            JPanel st1 = (JPanel) statisticsUp.getComponent(i);
            for(int j=0; j<15; j++) {
                st1.getComponent(j).setBackground(Color.LIGHT_GRAY);
                if(j>14-ratio) {
                    st1.getComponent(j).setBackground(Color.RED);
                }
            }
        }

    }



    public UI() {


        generalInformations info = new generalInformations();
        LastEarthquakes lastEarthquakes = new LastEarthquakes();

        cities istanbul = new Istanbul();
        cities ankara = new Ankara();
        cities izmir = new Izmir();

        String a = "";
        for (String line:lastEarthquakes.newest()) {
            a += line;
        }
        textPane.setText(a);


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        istanbulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cityName.setText("ISTANBUL");
                population.setText("  Population: " + istanbul.getNufus());
                buildingNumber.setText("  Num of buildings: " + istanbul.getBinaSayisi());
                density.setText("  Population density: " + istanbul.getYogunluk());
                peopleperbuilding.setText("  People per building: " + Float.parseFloat(istanbul.getNufus())/Float.parseFloat(istanbul.getBinaSayisi()));

                lasttwentyyears.setText("  Num of earthquakes last 20 years: " + info.getYirmiYil());
                lastyear.setText("  Num of earthquakes in 2020: " + info.getIkiBinYirmi());
                low.setText("  3.9 and down annual earthquakes average: " + info.getAverageLowIntensity());
                medium.setText("  Between 4.0 and 5.9 annual earthquakes average: " + info.getAverageMiddleIntensity());
                high.setText("  Between 6.0 and 10.0 annual earthquakes average: " + info.getAverageHighIntensity());
                average.setText("  Num of annual earthquakes average: " + info.getOrtalamaDepremSayisi());
                avarageintensity.setText("  Average intensity last 20 years: " + info.avgTotalIntensity());
                df.setTimeZone(TimeZone.getTimeZone("Europe/Istanbul"));
                date.setText(df.format(new Date()));
            }
        });
        ankaraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cityName.setText("ANKARA");
                population.setText("  Population: " + ankara.getNufus());
                buildingNumber.setText("  Num of buildings: " + ankara.getBinaSayisi());
                density.setText("  Population density: " + ankara.getYogunluk());
                peopleperbuilding.setText("  People per building: " + Float.parseFloat(ankara.getNufus())/Float.parseFloat(ankara.getBinaSayisi()));

                df.setTimeZone(TimeZone.getTimeZone("Europe/Istanbul"));
                date.setText(df.format(new Date()));
            }
        });
        izmirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cityName.setText("IZMIR");
                population.setText("  Population: " + izmir.getNufus());
                buildingNumber.setText("  Num of buildings: " + izmir.getBinaSayisi());
                density.setText("  Population density: " + izmir.getYogunluk());
                peopleperbuilding.setText("  People per building: " + Float.parseFloat(izmir.getNufus())/Float.parseFloat(izmir.getBinaSayisi()));

                df.setTimeZone(TimeZone.getTimeZone("Europe/Istanbul"));
                date.setText(df.format(new Date()));
            }
        });
        chart1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> labels = new ArrayList<String>();
                labels.add("2000");
                labels.add("2001");
                labels.add("2002");
                labels.add("2003");
                labels.add("2004");
                labels.add("2005");
                labels.add("2006");
                labels.add("2007");
                labels.add("2008");
                labels.add("2009");
                labels.add("2010");
                labels.add("2011");
                labels.add("2012");
                labels.add("2013");
                labels.add("2014");
                labels.add("2015");
                labels.add("2016");
                labels.add("2017");
                labels.add("2018");
                labels.add("2019");
                graph(info.pushTwentyYear(), labels,35000,5);
            }
        });
        chart2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> labels = new ArrayList<String>();
                labels.add("Jan");
                labels.add("Feb");
                labels.add("Mar");
                labels.add("Apr");
                labels.add("May");
                labels.add("Jun");
                labels.add("Jul");
                labels.add("Aug");
                labels.add("Sep");
                labels.add("Oct");
                labels.add("Nov");
                labels.add("Dec");
                graph(info.push2020(), labels,6000,5);
            }
        });
        istanbulButton.doClick();
        chart1.doClick();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Earthquake Application");
        frame.setSize(1225, 725);
        frame.setContentPane(new UI().window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.setResizable(false);

    }


}
