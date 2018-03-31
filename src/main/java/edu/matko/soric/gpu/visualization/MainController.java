package edu.matko.soric.gpu.visualization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    Service service;

    @GetMapping("/GPU-speed")
    public String displayDataSpeed(@RequestParam(name="name", required=false) String name, Model model) {
        List<GPU_DTO_1> gpu_dto_1List = service.getDto1();
        return "GPU-speed";
    }

    @GetMapping("/GPU-memory")
    public String displayDataMemory(@RequestParam(name="name", required=false) String name, Model model) {
        List<GPU_DTO_1> gpu_dto_1List = service.getDto1();
        return "GPU-memory";
    }

    @GetMapping(value = "/api/dto1")
    public ResponseEntity<List<GPU_DTO_1>> dto1Function() {
        List<GPU_DTO_1> dto1List = service.getDto1();
        if (dto1List.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<GPU_DTO_1>>(dto1List, HttpStatus.OK);
    }

}
