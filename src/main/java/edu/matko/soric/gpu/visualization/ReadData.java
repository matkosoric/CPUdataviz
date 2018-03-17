package edu.matko.soric.gpu.visualization;

import com.opencsv.CSVReader;
import model.GPUbean;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ReadData {

    public static List<GPUbean> readAllData () {

        // reading data set from a csv file and parsing elements to a bean

        String data = "E:\\Java projekti\\CPUdataviz\\src\\main\\resources\\All_GPUs.csv";
        //        String data = "/home/matko/IdeaProjects/CPUdataviz/src/main/resources/All_GPUs.csv";
        CSVReader reader = null;
        ArrayList<GPUbean> cpuList = new ArrayList<GPUbean>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy").withLocale(Locale.ENGLISH);

        try {
            reader = new CSVReader(new FileReader(data));
            String [] line;
            reader.readNext();
            while ((line = reader.readNext()) != null ) {

                LocalDate date = LocalDate.MIN;
                Long bestResolution1 = 0L;
                Long bestResolution2 = 0L;
                Long boostClock = 0L;
                Long coreSpeed = 0L;
                Long displayPortConnection = 0L;
                Long hdmiConnection = 0L;
                Long maxPower = 0L;
                Long memory = 0L;
                Long memory_speed = 0L;
                Long tmu = 0L;


                // parsiranje stringova u numeričke vrijednosti
                try {

                    // best resolution
                    if (line[1] != null && line[1].trim().length() > 0) {
                        bestResolution1 = Long.parseLong(line[1].substring(0, line[1].indexOf("x")-1));
                        bestResolution2 = Long.parseLong(line[1].substring((line[1].indexOf("x")+2), line[1].length()));
                    }

                    // boost clock
                    if (line[2] != null
                            && line[2].length()>0
                            && !line[2].startsWith("\n")) {
                        boostClock = Long.parseLong(line[2].substring(0, line[2].indexOf(" ")));
                    }

                    // core speed
                    if (line[3] != null
                            && line[3].length()>0
                            && !line[3].startsWith("\n")) {
                        coreSpeed = Long.parseLong(line[3].substring(0, line[3].indexOf(" ")));
                    }

                    // display port connection
                    if (line[7] != null
                            && line[7].length() > 0) {
                        displayPortConnection = Long.parseLong(line[7]);
                    }

                    // hdmi connection
                    if (line[8] != null
                            && line[8].length() > 0
                            && !line[8].startsWith("\n")) {
                        hdmiConnection = Long.parseLong(line[8]);
                    }

                    // max power
                    if (line[12] != null
                            && (line[12].length()>2)
                            && (!line[12].startsWith("\n"))) {
                        maxPower = Long.parseLong(line[12].substring(0, line[12].indexOf(" ")));
                    }

                    // memory
                    if (line[13] != null
                            && line[13].length() > 1
                            && !line[13].startsWith("\n")) {
                        memory = Long.parseLong(line[13].substring(0, line[13].indexOf(" ")) );
                    }

                    // memory_speed
                    if (line[16] != null
                            && line[16].length() > 1
                            && !line[16].startsWith("\n")) {
                        memory_speed = Long.parseLong(line[16].substring(0, line[16].indexOf(" ")));
                    }

                    // release date
                    if (line[26] != null && (!line[26].contains("Release") || !line[26].startsWith("\n"))) {
                        date = LocalDate.parse(line[26].substring(1, line[26].length() - 1).trim(), formatter);
                    }

                    // tmu
                    if (line[31] != null
                            && line[31].length() > 0
                            && (!line[31].startsWith("\n"))) {
                        tmu = Long.parseLong(line[31].trim());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cpuList.add(new GPUbean(
                        line[0], bestResolution1, bestResolution2, boostClock, coreSpeed, line[4], line[5], line[6],
                        displayPortConnection, hdmiConnection, line[9], line[10],
                        line[11], maxPower, memory, line[14], line[15], memory_speed,
                        line[17], line[18], line[19], line[20], line[21], line[22], line[23],
                        line[24], line[25], date,
                        line[27], line[28], line[29], line[30], tmu,
                        line[32], line[33]
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("Parsing complete!");
        return cpuList;
    }
}
