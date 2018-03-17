package edu.matko.soric.gpu.visualization;

import model.GPUbean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/GPU-data")
    public String displayData(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        // reading data set from a csv file
        List<GPUbean> gpuListRaw = ReadData.readAllData();

        // populating in-memory H2 database with a list
        try {
            Bean2database.addToDatabase(gpuListRaw);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // get data from in-memory database
        List<GPU_DTO_1> gpu_dto_1List = new ArrayList<>();
        try {
            gpu_dto_1List = Bean2database.selectCoreSpeedMemoryReleaseDate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        model.addAttribute("gpuList", gpu_dto_1List);
        return "GPU-data";
    }


}
