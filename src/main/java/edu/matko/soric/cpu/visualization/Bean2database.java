package edu.matko.soric.cpu.visualization;

import model.CPUbean;

import java.sql.*;
import java.util.List;

public class Bean2database {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    public static Integer addToDatabase (List<CPUbean> cpuBeansList) throws SQLException{

        Integer rowsAffected = 0;

        PreparedStatement createPreparedStatement = null;
        PreparedStatement insertPreparedStatement = null;
        PreparedStatement selectPreparedStatement = null;

        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String CreateQuery = "CREATE TABLE CPUINFO (" +
                "ID int PRIMARY KEY, " +
                "Architecture varchar(255), " +
                "Best_Resolution1 INT, " +
                "Best_Resolution2 INT, " +
                "Boost_Clock INT, " +
                "Core_Speed INT, " +
                "DVI_Connection varchar(255), " +
                "Dedicated varchar(255), " +
                "Direct_X varchar(255), " +
                "DisplayPort_Connection INT, " +
                "HDMI_Connection INT, " +
                "Integrated varchar(255), " +
                "L2_Cache varchar(255), " +
                "Manufacturer varchar(255), " +
                "Max_Power INT, " +
                "Memory INT, " +
                "Memory_Bandwidth varchar(255), " +
                "Memory_Bus varchar(255), " +
                "Memory_Speed INT, " +
                "Memory_Type varchar(255), " +
                "Name varchar(255), " +
                "Notebook_GPU varchar(255), " +
                "Open_GL varchar(255), " +
                "PSU varchar(255), " +
                "Pixel_Rate varchar(255), " +
                "Power_Connector varchar(255), " +
                "Process varchar(255), " +
                "ROPs varchar(255), " +
                "Release_Date DATE, " +
                "Release_Price varchar(255), " +
                "Resolution_WxH varchar(255), " +
                "SLI_Crossfire varchar(255), " +
                "Shader varchar(255), " +
                "TMUs INT, " +
                "Texture_Rate varchar(255), " +
                "VGA_Connection varchar(255)" +
            ")";

        String InsertQuery = "INSERT INTO cpuinfo (Id, " +
                "Architecture, " +
                "Best_Resolution1, " +
                "Best_Resolution2, " +
                "Boost_Clock, " +
                "Core_Speed, " +
                "DVI_Connection, " +
                "Dedicated, " +
                "Direct_X, " +
                "DisplayPort_Connection, " +
                "HDMI_Connection, " +
                "Integrated, " +
                "L2_Cache, " +
                "Manufacturer, " +
                "Max_Power, " +
                "Memory, " +
                "Memory_Bandwidth, " +
                "Memory_Bus, " +
                "Memory_Speed, " +
                "Memory_Type, " +
                "Name, " +
                "Notebook_GPU, " +
                "Open_GL, " +
                "PSU, " +
                "Pixel_Rate, " +
                "Power_Connector, " +
                "Process, " +
                "ROPs, " +
                "Release_Date, " +
                "Release_Price, " +
                "Resolution_WxH, " +
                "SLI_Crossfire, " +
                "Shader, " +
                "TMUs, " +
                "Texture_Rate, " +
                "VGA_Connection) " +
                "VALUES" + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        String SelectQuery = "SELECT * FROM cpuinfo";

        try {
            dbConnection.setAutoCommit(false);

            // CREATE TABLE
            createPreparedStatement = dbConnection.prepareStatement(CreateQuery);
            createPreparedStatement.executeUpdate();
            createPreparedStatement.close();

            // INSERT DATA
            insertPreparedStatement = dbConnection.prepareStatement(InsertQuery);
            insertPreparedStatement.setLong(1, 1);
            insertPreparedStatement.setString(2, cpuBeansList.get(0).getArchitecture());
            insertPreparedStatement.setLong(3, cpuBeansList.get(0).getBest_Resolution1());
            insertPreparedStatement.setLong(4, cpuBeansList.get(0).getBest_Resolution2());
            insertPreparedStatement.setLong(5, cpuBeansList.get(0).getBoost_Clock());
            insertPreparedStatement.setLong(6, cpuBeansList.get(0).getCore_Speed());
            insertPreparedStatement.setString(7, cpuBeansList.get(0).getDVI_Connection());
            insertPreparedStatement.setString(8, cpuBeansList.get(0).getDedicated());
            insertPreparedStatement.setString(9, cpuBeansList.get(0).getDirect_X());
            insertPreparedStatement.setLong(10, cpuBeansList.get(0).getDisplayPort_Connection());
            insertPreparedStatement.setLong(11, cpuBeansList.get(0).getHDMI_Connection());
            insertPreparedStatement.setString(12, cpuBeansList.get(0).getIntegrated());
            insertPreparedStatement.setString(13, cpuBeansList.get(0).getL2_Cache());
            insertPreparedStatement.setString(14, cpuBeansList.get(0).getManufacturer());
            insertPreparedStatement.setLong(15, cpuBeansList.get(0).getMax_Power());
            insertPreparedStatement.setLong(16, cpuBeansList.get(0).getMemory());
            insertPreparedStatement.setString(17, cpuBeansList.get(0).getMemory_Bandwidth());
            insertPreparedStatement.setString(18, cpuBeansList.get(0).getMemory_Bus());
            insertPreparedStatement.setLong(19, cpuBeansList.get(0).getMemory_Speed());
            insertPreparedStatement.setString(20, cpuBeansList.get(0).getMemory_Type());
            insertPreparedStatement.setString(21, cpuBeansList.get(0).getName());
            insertPreparedStatement.setString(22, cpuBeansList.get(0).getNotebook_GPU());
            insertPreparedStatement.setString(23, cpuBeansList.get(0).getOpen_GL());
            insertPreparedStatement.setString(24, cpuBeansList.get(0).getPSU());
            insertPreparedStatement.setString(25, cpuBeansList.get(0).getPixel_Rate());
            insertPreparedStatement.setString(26, cpuBeansList.get(0).getPower_Connector());
            insertPreparedStatement.setString(27, cpuBeansList.get(0).getProcess());
            insertPreparedStatement.setString(28, cpuBeansList.get(0).getROPs());
            insertPreparedStatement.setDate(29, java.sql.Date.valueOf(cpuBeansList.get(0).getRelease_Date()));
            insertPreparedStatement.setString(30, cpuBeansList.get(0).getRelease_Price());
            insertPreparedStatement.setString(31, cpuBeansList.get(0).getResolution_WxH());
            insertPreparedStatement.setString(32, cpuBeansList.get(0).getSLI_Crossfire());
            insertPreparedStatement.setString(33, cpuBeansList.get(0).getShader());
            insertPreparedStatement.setLong(34, cpuBeansList.get(0).getTMUs());
            insertPreparedStatement.setString(35, cpuBeansList.get(0).getTexture_Rate());
            insertPreparedStatement.setString(36, cpuBeansList.get(0).getVGA_Connection());



            insertPreparedStatement.executeUpdate();
            insertPreparedStatement.close();


//            for (CPUbean element : cpuBeansList) {
//
//
//
//            }

//            insertPreparedStatement.setString(2, "Jose");

            selectPreparedStatement = dbConnection.prepareStatement(SelectQuery);
            ResultSet rs = selectPreparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println("Id " + rs.getInt("id") + " Release date: " + rs.getDate("Release_Date"));
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
