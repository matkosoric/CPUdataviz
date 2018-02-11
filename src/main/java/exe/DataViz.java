package exe;

import com.opencsv.*;
import com.opencsv.bean.CsvToBean;
import model.CPUbean;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DataViz {

    public static void main(String[] args) {

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
                    LocalDate date;
                    try {
                        date = LocalDate.parse(line[26].substring(1, line[26].length() - 1).trim(), formatter);
                    } catch (Exception e) {
                        date = null;
                    }
                    cpuList.add(new CPUbean(
                            line[0], line[1], line[2], line[3], line[4], line[5], line[6],
                            Long.getLong(line[7]), Long.getLong(line[8]), line[9], line[10],
                            line[11], line[12], line[13], line[14], line[15], line[16],
                            line[17], line[18], line[19], line[20], line[21], line[22], line[23],
                            line[24], Long.getLong(line[25]), date,
                            line[27], line[28], line[29], line[30], Long.getLong(line[31]),
                            line[32], line[33]
                    ));
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (CPUbean element : cpuList)
            System.out.println(element.getRelease_Date());

    }

}



