package edu.matko.soric.gpu.visualization;

import java.time.LocalDate;

public class GPU_DTO_1 {


    private Long Id;
    private Long Core_Speed;
    private Long Memory;
    private LocalDate Release_Date;


    public GPU_DTO_1 (Long pId, Long pCore_Speed, Long pMemory, LocalDate pRelease_Date) {
        Id = pId;
        Core_Speed = pCore_Speed;
        Memory = pMemory;
        Release_Date = pRelease_Date;
    }

    public GPU_DTO_1 () {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getCore_Speed() {
        return Core_Speed;
    }

    public void setCore_Speed(Long core_Speed) {
        Core_Speed = core_Speed;
    }

    public Long getMemory() {
        return Memory;
    }

    public void setMemory(Long memory) {
        Memory = memory;
    }

    public LocalDate getRelease_Date() {
        return Release_Date;
    }

    public void setRelease_Date(LocalDate release_Date) {
        Release_Date = release_Date;
    }
}
