package edu.matko.soric.cpu.visualization;

import com.opencsv.CSVReader;
import model.CPUbean;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ReadData {

    public static List<CPUbean> readAllData () {

        // reading data set from a csv file and parsing elements to a bean

        //        String data = "C:\\SOURCE CODE\\datavisualization\\src\\main\\resources\\All_GPUs.csv";
        String data = "/home/matko/IdeaProjects/CPUdataviz/src/main/resources/All_GPUs.csv";
        CSVReader reader = null;
        ArrayList<CPUbean> cpuList = new ArrayList<CPUbean>();
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
                Long maxPower = 0L;
                Long memory = 0L;
                Long memory_speed = 0L;


                // parsiranje stringova u numeričke vrijednosti
                try {

                    // best resolution
                    if (line[1] != null && line[1].length() > 0) {
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

                } catch (Exception e) {
                    e.printStackTrace();
                }
                cpuList.add(new CPUbean(
                        line[0], bestResolution1, bestResolution2, boostClock, coreSpeed, line[4], line[5], line[6],
                        Long.getLong(line[7]), Long.getLong(line[8]), line[9], line[10],
                        line[11], maxPower, memory, line[14], line[15], memory_speed,
                        line[17], line[18], line[19], line[20], line[21], line[22], line[23],
                        line[24], line[25], date,
                        line[27], line[28], line[29], line[30], Long.getLong(line[31]),
                        line[32], line[33]
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Parsing complete!");
        return cpuList;

    }

}
