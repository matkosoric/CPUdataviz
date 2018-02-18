package edu.matko.soric.cpu.visualization;

import model.CPUbean;

import java.sql.*;
import java.util.List;

public class Bean2database {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    public static Integer addToDatabase (List<CPUbean> cpuBeans) throws SQLException{

        Integer rowsAffected = 0;

        PreparedStatement createPreparedStatement = null;
        PreparedStatement insertPreparedStatement = null;
        PreparedStatement selectPreparedStatement = null;

        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        String CreateQuery = "CREATE TABLE CPUINFO (" +
                "ID int PRIMARY KEY AUTO_INCREMENT, " +
                "Architecture varchar(255), " +
                "Best_Resolution varchar(255), " +
                "Boost_Clock varchar(255), " +
                "Core_Speed varchar(255), " +
                "DVI_Connection varchar(255), " +
                "Dedicated varchar(255), " +
                "Direct_X varchar(255), " +
                "DisplayPort_Connection INT, " +
                "HDMI_Connection INT, " +
                "Integrated varchar(255), " +
                "L2_Cache varchar(255), " +
                "Manufacturer varchar(255), " +
                "Max_Power varchar(255), " +
                "Memory varchar(255), " +
                "Memory_Bandwidth varchar(255), " +
                "Memory_Bus varchar(255), " +
                "Memory_Speed varchar(255), " +
                "Memory_Type varchar(255), " +
                "Name varchar(255), " +
                "Notebook_GPU varchar(255), " +
                "Open_GL varchar(255), " +
                "PSU varchar(255), " +
                "Pixel_Rate varchar(255), " +
                "Power_Connector varchar(255), " +
                "Process varchar(255), " +
                "ROPs INT, " +
                "Release_Date DATE, " +
                "Release_Price varchar(255), " +
                "Resolution_WxH varchar(255), " +
                "SLI_Crossfire varchar(255), " +
                "Shader varchar(255), " +
                "TMUs INT, " +
                "Texture_Rate varchar(255), " +
                "VGA_Connection varchar(255)" +
            ")";




        String InsertQuery = "INSERT INTO cpuinfo" + "(id, name) values" + "(?,?)";


        String SelectQuery = "SELECT * FROM cpuinfo";

        try {
            dbConnection.setAutoCommit(false);

            // CREATE TABLE
            createPreparedStatement = dbConnection.prepareStatement(CreateQuery);
            createPreparedStatement.executeUpdate();
            createPreparedStatement.close();

            // INSERT DATA

//            insertPreparedStatement = dbConnection.prepareStatement(InsertQuery);
//            insertPreparedStatement.setInt(1, 1);
//            insertPreparedStatement.setString(2, "Jose");
//            insertPreparedStatement.executeUpdate();
//            insertPreparedStatement.close();

            selectPreparedStatement = dbConnection.prepareStatement(SelectQuery);
            ResultSet rs = selectPreparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println("Id " + rs.getInt("id") + " Name " + rs.getString("name"));
            }
            selectPreparedStatement.close();

            dbConnection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.close();
        }


        return rowsAffected;

    }


}
