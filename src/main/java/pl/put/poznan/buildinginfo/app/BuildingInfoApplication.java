package pl.put.poznan.buildinginfo.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.buildinginfo.classes.Building;
import pl.put.poznan.buildinginfo.classes.Floor;
import pl.put.poznan.buildinginfo.classes.Room;
import pl.put.poznan.buildinginfo.classes.JSONReader;

@SpringBootApplication
public class BuildingInfoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Wczytanie danych z pliku JSON
        String jsonFilePath = "src/main/resources/data.json";
        Building building = JSONReader.loadBuildingFromJson(jsonFilePath);

    }
}
