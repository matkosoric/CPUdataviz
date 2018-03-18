package edu.matko.soric.gpu.visualization;

import model.GPUbean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    public Service () {
    }

    public void loadCSVdataToDatabase () {

        // reading data set from a csv file
        List<GPUbean> gpuListRaw = ReadData.readAllData();
        // populating in-memory H2 database with a list
        try {
            Bean2database.addToDatabase(gpuListRaw);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<GPU_DTO_1>  getDto1 () {
        // get data from in-memory database
        List<GPU_DTO_1> gpu_dto_1List = new ArrayList<>();
        try {
            gpu_dto_1List = Bean2database.selectCoreSpeedMemoryReleaseDate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gpu_dto_1List;
    }
}
