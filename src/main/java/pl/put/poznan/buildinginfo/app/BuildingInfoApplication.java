package pl.put.poznan.buildinginfo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pl.put.poznan.buildinginfo.classes.Building;
import pl.put.poznan.buildinginfo.classes.JSONReader;
import pl.put.poznan.buildinginfo.logic.BuildingTransformer;

@SpringBootApplication(scanBasePackages = "pl.put.poznan.buildinginfo")
public class BuildingInfoApplication implements CommandLineRunner {

    // Wstrzyknięcie zależności do BuildingTransformer
    @Autowired
    private BuildingTransformer buildingTransformer;

    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String jsonFilePath = "src/main/resources/data.json";

        try {
            Building building = JSONReader.loadBuildingFromJson(jsonFilePath);
            
            // Dodanie wczytanego budynku do listy w BuildingTransformer
            buildingTransformer.addBuildings(List.of(building));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Błąd podczas wczytywania pliku JSON!");
        }
    }
}
