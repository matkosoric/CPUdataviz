package model;

import com.opencsv.bean.CsvBindByName;

import java.time.LocalDate;

public class CPUbean {

    public CPUbean(String architecture, Long best_Resolution1, Long best_Resolution2, Long boost_Clock,
                   Long core_Speed, String DVI_Connection, String dedicated, String direct_X,
                   Long displayPort_Connection, Long HDMI_Connection, String integrated, String l2_Cache,
                   String manufacturer, Long max_Power, Long memory, String memory_Bandwidth,
                   String memory_Bus, Long memory_Speed, String memory_Type, String name,
                   String notebook_GPU, String open_GL, String PSU, String pixel_Rate, String power_Connector,
                   String process, String ROPs, LocalDate release_Date, String release_Price, String resolution_WxH,
                   String SLI_Crossfire, String shader, Long TMUs, String texture_Rate, String VGA_Connection) {
        Architecture = architecture;
        Best_Resolution1 = best_Resolution1;
        Best_Resolution2 = best_Resolution2;
        Boost_Clock = boost_Clock;
        Core_Speed = core_Speed;
        this.DVI_Connection = DVI_Connection;
        Dedicated = dedicated;
        Direct_X = direct_X;
        DisplayPort_Connection = displayPort_Connection;
        this.HDMI_Connection = HDMI_Connection;
        Integrated = integrated;
        L2_Cache = l2_Cache;
        Manufacturer = manufacturer;
        Max_Power = max_Power;
        Memory = memory;
        Memory_Bandwidth = memory_Bandwidth;
        Memory_Bus = memory_Bus;
        Memory_Speed = memory_Speed;
        Memory_Type = memory_Type;
        Name = name;
        Notebook_GPU = notebook_GPU;
        Open_GL = open_GL;
        this.PSU = PSU;
        Pixel_Rate = pixel_Rate;
        Power_Connector = power_Connector;
        Process = process;
        this.ROPs = ROPs;
        Release_Date = release_Date;
        Release_Price = release_Price;
        Resolution_WxH = resolution_WxH;
        this.SLI_Crossfire = SLI_Crossfire;
        Shader = shader;
        this.TMUs = TMUs;
        Texture_Rate = texture_Rate;
        this.VGA_Connection = VGA_Connection;
    }

    @CsvBindByName
    private String Architecture;
    @CsvBindByName
    private Long Best_Resolution1;
    @CsvBindByName
    private Long Best_Resolution2;
    @CsvBindByName
    private Long Boost_Clock;
    @CsvBindByName
    private Long Core_Speed;
    @CsvBindByName
    private String DVI_Connection;
    @CsvBindByName
    private String Dedicated;
    @CsvBindByName
    private String Direct_X;
    @CsvBindByName
    private Long DisplayPort_Connection;
    @CsvBindByName
    private Long HDMI_Connection;
    @CsvBindByName
    private String Integrated;
    @CsvBindByName
    private String L2_Cache;
    @CsvBindByName
    private String Manufacturer;
    @CsvBindByName
    private Long Max_Power;
    @CsvBindByName
    private Long Memory;
    @CsvBindByName
    private String Memory_Bandwidth;
    @CsvBindByName
    private String Memory_Bus;
    @CsvBindByName
    private Long Memory_Speed;
    @CsvBindByName
    private String Memory_Type;
    @CsvBindByName
    private String Name;
    @CsvBindByName
    private String Notebook_GPU;
    @CsvBindByName
    private String Open_GL;
    @CsvBindByName
    private String PSU;
    @CsvBindByName
    private String Pixel_Rate;
    @CsvBindByName
    private String Power_Connector;
    @CsvBindByName
    private String Process;
    @CsvBindByName
    private String ROPs;
    @CsvBindByName
    private LocalDate Release_Date;
    @CsvBindByName
    private String Release_Price;
    @CsvBindByName
    private String Resolution_WxH;
    @CsvBindByName
    private String SLI_Crossfire;
    @CsvBindByName
    private String Shader;
    @CsvBindByName
    private Long TMUs;
    @CsvBindByName
    private String Texture_Rate;
    @CsvBindByName
    private String VGA_Connection;


    public String getArchitecture() {
        return Architecture;
    }

    public void setArchitecture(String architecture) {
        Architecture = architecture;
    }

    public Long getBest_Resolution1() {
        return Best_Resolution1;
    }

    public void setBest_Resolution1(Long best_Resolution1) {
        Best_Resolution1 = best_Resolution1;
    }

    public Long getBest_Resolution2() { return Best_Resolution2; }

    public void setBest_Resolution2(Long best_Resolution2) {
        Best_Resolution2 = best_Resolution2;
    }

    public Long getBoost_Clock() {
        return Boost_Clock;
    }

    public void setBoost_Clock(Long boost_Clock) {
        Boost_Clock = boost_Clock;
    }

    public Long getCore_Speed() { return Core_Speed; }

    public void setCore_Speed(Long core_Speed) { Core_Speed = core_Speed; }

    public String getDVI_Connection() {
        return DVI_Connection;
    }

    public void setDVI_Connection(String DVI_Connection) {
        this.DVI_Connection = DVI_Connection;
    }

    public String getDedicated() {
        return Dedicated;
    }

    public void setDedicated(String dedicated) {
        Dedicated = dedicated;
    }

    public String getDirect_X() {
        return Direct_X;
    }

    public void setDirect_X(String direct_X) {
        Direct_X = direct_X;
    }

    public Long getDisplayPort_Connection() {
        return DisplayPort_Connection;
    }

    public void setDisplayPort_Connection(Long displayPort_Connection) {
        DisplayPort_Connection = displayPort_Connection;
    }

    public Long getHDMI_Connection() {
        return HDMI_Connection;
    }

    public void setHDMI_Connection(Long HDMI_Connection) {
        this.HDMI_Connection = HDMI_Connection;
    }

    public String getIntegrated() {
        return Integrated;
    }

    public void setIntegrated(String integrated) {
        Integrated = integrated;
    }

    public String getL2_Cache() {
        return L2_Cache;
    }

    public void setL2_Cache(String l2_Cache) {
        L2_Cache = l2_Cache;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public Long getMax_Power() {
        return Max_Power;
    }

    public void setMax_Power(Long max_Power) {
        Max_Power = max_Power;
    }

    public Long getMemory() {
        return Memory;
    }

    public void setMemory(Long memory) {
        Memory = memory;
    }

    public String getMemory_Bandwidth() {
        return Memory_Bandwidth;
    }

    public void setMemory_Bandwidth(String memory_Bandwidth) {
        Memory_Bandwidth = memory_Bandwidth;
    }

    public String getMemory_Bus() {
        return Memory_Bus;
    }

    public void setMemory_Bus(String memory_Bus) {
        Memory_Bus = memory_Bus;
    }

    public Long getMemory_Speed() {
        return Memory_Speed;
    }

    public void setMemory_Speed(Long memory_Speed) {
        Memory_Speed = memory_Speed;
    }

    public String getMemory_Type() {
        return Memory_Type;
    }

    public void setMemory_Type(String memory_Type) {
        Memory_Type = memory_Type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNotebook_GPU() {
        return Notebook_GPU;
    }

    public void setNotebook_GPU(String notebook_GPU) {
        Notebook_GPU = notebook_GPU;
    }

    public String getOpen_GL() {
        return Open_GL;
    }

    public void setOpen_GL(String open_GL) {
        Open_GL = open_GL;
    }

    public String getPSU() {
        return PSU;
    }

    public void setPSU(String PSU) {
        this.PSU = PSU;
    }

    public String getPixel_Rate() {
        return Pixel_Rate;
    }

    public void setPixel_Rate(String pixel_Rate) {
        Pixel_Rate = pixel_Rate;
    }

    public String getPower_Connector() {
        return Power_Connector;
    }

    public void setPower_Connector(String power_Connector) {
        Power_Connector = power_Connector;
    }

    public String getProcess() {
        return Process;
    }

    public void setProcess(String process) {
        Process = process;
    }

    public String getROPs() {
        return ROPs;
    }

    public void setROPs(String ROPs) {
        this.ROPs = ROPs;
    }

    public LocalDate getRelease_Date() {
        return Release_Date;
    }

    public void setRelease_Date(LocalDate release_Date) {
        Release_Date = release_Date;
    }

    public String getRelease_Price() {
        return Release_Price;
    }

    public void setRelease_Price(String release_Price) {
        Release_Price = release_Price;
    }

    public String getResolution_WxH() {
        return Resolution_WxH;
    }

    public void setResolution_WxH(String resolution_WxH) {
        Resolution_WxH = resolution_WxH;
    }

    public String getSLI_Crossfire() {
        return SLI_Crossfire;
    }

    public void setSLI_Crossfire(String SLI_Crossfire) {
        this.SLI_Crossfire = SLI_Crossfire;
    }

    public String getShader() {
        return Shader;
    }

    public void setShader(String shader) {
        Shader = shader;
    }

    public Long getTMUs() {
        return TMUs;
    }

    public void setTMUs(Long TMUs) {
        this.TMUs = TMUs;
    }

    public String getTexture_Rate() {
        return Texture_Rate;
    }

    public void setTexture_Rate(String texture_Rate) {
        Texture_Rate = texture_Rate;
    }

    public String getVGA_Connection() {
        return VGA_Connection;
    }

    public void setVGA_Connection(String VGA_Connection) {
        this.VGA_Connection = VGA_Connection;
    }
}
