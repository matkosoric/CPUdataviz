package edu.matko.soric.cpu.visualization;

import model.CPUbean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/CPU-data")
    public String displayData(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        // reading data set from a csv file
        List<CPUbean> cpuList = ReadData.readAllData();

        // populating in-memory H2 database with a list
        try {
            Bean2database.addToDatabase(cpuList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // get data from in-memory database


        model.addAttribute("name", name);
        return "CPU-data";
    }


}
