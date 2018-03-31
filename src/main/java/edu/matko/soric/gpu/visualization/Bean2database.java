package edu.matko.soric.gpu.visualization;

import model.GPUbean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Bean2database {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    public static void addToDatabase (List<GPUbean> gpuBeansList) throws SQLException{

        PreparedStatement createPreparedStatement = null;
        PreparedStatement insertPreparedStatement = null;

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

        String CreateQuery = "CREATE TABLE GPUINFO (" +
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

        String InsertQuery = "INSERT INTO gpuinfo (" +
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


        String SelectQuery = "SELECT * FROM gpuinfo";

        try {
            dbConnection.setAutoCommit(false);

            // CREATE TABLE
            createPreparedStatement = dbConnection.prepareStatement(CreateQuery);
            createPreparedStatement.executeUpdate();
            createPreparedStatement.close();

            // INSERT DATA
            insertPreparedStatement = dbConnection.prepareStatement(InsertQuery);

            for (GPUbean gpuElement : gpuBeansList) {

                insertPreparedStatement.setString(1, gpuElement.getArchitecture());
                insertPreparedStatement.setLong(2, gpuElement.getBest_Resolution1());
                insertPreparedStatement.setLong(3, gpuElement.getBest_Resolution2());
                insertPreparedStatement.setLong(4, gpuElement.getBoost_Clock());
                insertPreparedStatement.setLong(5, gpuElement.getCore_Speed());
                insertPreparedStatement.setString(6, gpuElement.getDVI_Connection());
                insertPreparedStatement.setString(7, gpuElement.getDedicated());
                insertPreparedStatement.setString(8, gpuElement.getDirect_X());
                insertPreparedStatement.setLong(9, gpuElement.getDisplayPort_Connection());
                insertPreparedStatement.setLong(10, gpuElement.getHDMI_Connection());

                insertPreparedStatement.setString(11, gpuElement.getIntegrated());
                insertPreparedStatement.setString(12, gpuElement.getL2_Cache());
                insertPreparedStatement.setString(13, gpuElement.getManufacturer());
                insertPreparedStatement.setLong(14, gpuElement.getMax_Power());
                insertPreparedStatement.setLong(15, gpuElement.getMemory());
                insertPreparedStatement.setString(16, gpuElement.getMemory_Bandwidth());
                insertPreparedStatement.setString(17, gpuElement.getMemory_Bus());
                insertPreparedStatement.setLong(18, gpuElement.getMemory_Speed());
                insertPreparedStatement.setString(19, gpuElement.getMemory_Type());
                insertPreparedStatement.setString(20, gpuElement.getName());

                insertPreparedStatement.setString(21, gpuElement.getNotebook_GPU());
                insertPreparedStatement.setString(22, gpuElement.getOpen_GL());
                insertPreparedStatement.setString(23, gpuElement.getPSU());
                insertPreparedStatement.setString(24, gpuElement.getPixel_Rate());
                insertPreparedStatement.setString(25, gpuElement.getPower_Connector());
                insertPreparedStatement.setString(26, gpuElement.getProcess());
                insertPreparedStatement.setString(27, gpuElement.getROPs());
                insertPreparedStatement.setDate(28, java.sql.Date.valueOf(gpuElement.getRelease_Date()));
                insertPreparedStatement.setString(29, gpuElement.getRelease_Price());
                insertPreparedStatement.setString(30, gpuElement.getResolution_WxH());

                insertPreparedStatement.setString(31, gpuElement.getSLI_Crossfire());
                insertPreparedStatement.setString(32, gpuElement.getShader());
                insertPreparedStatement.setLong(33, gpuElement.getTMUs());
                insertPreparedStatement.setString(34, gpuElement.getTexture_Rate());
                insertPreparedStatement.setString(35, gpuElement.getVGA_Connection());

                insertPreparedStatement.executeUpdate();

            }

            insertPreparedStatement.close();

            dbConnection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.close();
        }
    }


    public static List<GPU_DTO_1> selectCoreSpeedMemoryReleaseDate () throws SQLException {

        List<GPU_DTO_1> gpu_dto_1List = new ArrayList<>();

        try (
                Connection dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
                PreparedStatement selectPreparedStatement = dbConnection.prepareStatement("SELECT * FROM gpuinfo WHERE Core_Speed > 0 ORDER BY Release_Date");
                ResultSet resultSet = selectPreparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                GPU_DTO_1 gpuDTO = new GPU_DTO_1();
                gpuDTO.setId(resultSet.getLong("id"));
                gpuDTO.setCore_Speed(resultSet.getLong("Core_Speed"));
                gpuDTO.setMemory(resultSet.getLong("Memory"));
                gpuDTO.setRelease_Date(resultSet.getDate("Release_Date").toLocalDate());
                gpu_dto_1List.add(gpuDTO);
            }
        }
        return gpu_dto_1List;
    }

}
