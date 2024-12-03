package pl.put.poznan.buildinginfo.classes;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JSONReader {

    public static Building loadBuildingFromJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Odczyt JSON z pliku i mapowanie na obiekt Building
            return objectMapper.readValue(new File(filePath), Building.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load data from the JSON file.");
        }
    }
}
