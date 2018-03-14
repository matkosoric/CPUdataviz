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
                "ID int AUTO_INCREMENT PRIMARY KEY, " +
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

        String InsertQuery = "INSERT INTO cpuinfo (" +
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

                "VALUES" + "    (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                                "?, ?, ?, ?, ?)";


        String SelectQuery = "SELECT * FROM cpuinfo";

        try {
            dbConnection.setAutoCommit(false);

            // CREATE TABLE
            createPreparedStatement = dbConnection.prepareStatement(CreateQuery);
            createPreparedStatement.executeUpdate();
            createPreparedStatement.close();

            // INSERT DATA
            insertPreparedStatement = dbConnection.prepareStatement(InsertQuery);
            
            for (CPUbean cpuElement : cpuBeansList) {

                insertPreparedStatement.setString(1, cpuElement.getArchitecture());
                insertPreparedStatement.setLong(2, cpuElement.getBest_Resolution1());
                insertPreparedStatement.setLong(3, cpuElement.getBest_Resolution2());
                insertPreparedStatement.setLong(4, cpuElement.getBoost_Clock());
                insertPreparedStatement.setLong(5, cpuElement.getCore_Speed());
                insertPreparedStatement.setString(6, cpuElement.getDVI_Connection());
                insertPreparedStatement.setString(7, cpuElement.getDedicated());
                insertPreparedStatement.setString(8, cpuElement.getDirect_X());
                insertPreparedStatement.setLong(9, cpuElement.getDisplayPort_Connection());
                insertPreparedStatement.setLong(10, cpuElement.getHDMI_Connection());

                insertPreparedStatement.setString(11, cpuElement.getIntegrated());
                insertPreparedStatement.setString(12, cpuElement.getL2_Cache());
                insertPreparedStatement.setString(13, cpuElement.getManufacturer());
                insertPreparedStatement.setLong(14, cpuElement.getMax_Power());
                insertPreparedStatement.setLong(15, cpuElement.getMemory());
                insertPreparedStatement.setString(16, cpuElement.getMemory_Bandwidth());
                insertPreparedStatement.setString(17, cpuElement.getMemory_Bus());
                insertPreparedStatement.setLong(18, cpuElement.getMemory_Speed());
                insertPreparedStatement.setString(19, cpuElement.getMemory_Type());
                insertPreparedStatement.setString(20, cpuElement.getName());

                insertPreparedStatement.setString(21, cpuElement.getNotebook_GPU());
                insertPreparedStatement.setString(22, cpuElement.getOpen_GL());
                insertPreparedStatement.setString(23, cpuElement.getPSU());
                insertPreparedStatement.setString(24, cpuElement.getPixel_Rate());
                insertPreparedStatement.setString(25, cpuElement.getPower_Connector());
                insertPreparedStatement.setString(26, cpuElement.getProcess());
                insertPreparedStatement.setString(27, cpuElement.getROPs());
                insertPreparedStatement.setDate(28, java.sql.Date.valueOf(cpuElement.getRelease_Date()));
                insertPreparedStatement.setString(29, cpuElement.getRelease_Price());
                insertPreparedStatement.setString(30, cpuElement.getResolution_WxH());

                insertPreparedStatement.setString(31, cpuElement.getSLI_Crossfire());
                insertPreparedStatement.setString(32, cpuElement.getShader());
                insertPreparedStatement.setLong(33, cpuElement.getTMUs());
                insertPreparedStatement.setString(34, cpuElement.getTexture_Rate());
                insertPreparedStatement.setString(35, cpuElement.getVGA_Connection());

                insertPreparedStatement.executeUpdate();

            }

            insertPreparedStatement.close();

            // print
//            selectPreparedStatement = dbConnection.prepareStatement(SelectQuery);
//            ResultSet rs = selectPreparedStatement.executeQuery();
//            while (rs.next()) {
//                System.out.println("Id " + rs.getInt("id") + " Release date: " + rs.getDate("Release_Date"));
//            }
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
