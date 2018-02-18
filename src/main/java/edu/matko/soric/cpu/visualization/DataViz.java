package edu.matko.soric.cpu.visualization;

import model.CPUbean;

import java.sql.SQLException;
import java.util.List;

public class DataViz {

    public static void main(String[] args) {

        // reading data set from a csv file
        List<CPUbean> cpuList = ReadData.readAllData();

        // populating in-memory H2 database with a list
        try {
            Integer rowsAffected = Bean2database.addToDatabase(cpuList);
        } catch (SQLException e) {
            e.printStackTrace();
        }






    }

}



