package edu.matko.soric.gpu.visualization;

import com.google.gson.Gson;
import model.GPUbean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.parser.Entity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    Service service;

    @GetMapping("/GPU-data")
    public String displayData(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        service.loadCSVdataToDatabase();

        List<GPU_DTO_1> gpu_dto_1List = service.getDto1();

        model.addAttribute("gpuList", gpu_dto_1List);
        return "GPU-data";
    }

    @GetMapping(value = "/api/dto1")
    public ResponseEntity<List<GPU_DTO_1>> dto1Function() {
        List<GPU_DTO_1> dto1List = service.getDto1();
        if (dto1List.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<GPU_DTO_1>>(dto1List, HttpStatus.OK);
    }

}
