package pl.put.poznan.buildinginfo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main starter class of application
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.buildinginfo"})
public class BuildingInfoApplication {
    /**
     * Main method of application
     * @param args extra arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);
    }
}
