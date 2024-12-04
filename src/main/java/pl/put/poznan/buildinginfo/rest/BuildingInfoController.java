package pl.put.poznan.buildinginfo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.put.poznan.buildinginfo.classes.Building;
import pl.put.poznan.buildinginfo.classes.Room;
import pl.put.poznan.buildinginfo.logic.BuildingTransformer;

@RestController
@RequestMapping("/api/building")
public class BuildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);

    private final BuildingTransformer buildingTransformer;

    public BuildingInfoController(BuildingTransformer buildingTransformer) {
        this.buildingTransformer = buildingTransformer;
    }

    // Endpoint: Pobierz wszystkie budynki
    @GetMapping
    public List<Building> getBuildings() {
        logger.info("Fetching all buildings...");
        return buildingTransformer.getAllBuildings();
    }

    @GetMapping("/test")
        public String testEndpoint() {
        return "Hello World!";
    }

    // Endpoint: Pobierz łączną powierzchnię budynku o podanym ID
    @GetMapping("/{id}/area")
    public float getBuildingArea(@PathVariable int id) {
        logger.info("Fetching total area for building with ID: {}", id);
        return buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + id + " not found"))
                .getBuildingArea();
    }

    // Endpoint: Pobierz łączną kubaturę budynku o podanym ID
    @GetMapping("/{id}/cube")
    public float getBuildingCube(@PathVariable int id) {
        logger.info("Fetching total cube for building with ID: {}", id);
        return buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + id + " not found"))
                .getBuildingCube();
    }

    // Endpoint: Pobierz średnią moc oświetlenia na jednostkę powierzchni dla budynku
    @GetMapping("/{id}/light/average")
    public float getAverageBuildingLight(@PathVariable int id) {
        logger.info("Fetching average light per square meter for building with ID: {}", id);
        return buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + id + " not found"))
                .getAverageBuildingLight();
    }

    // Endpoint: Dodaj nowy budynek
    @PostMapping
    public void addBuilding(@RequestBody Building building) {
        logger.info("Adding a new building: {}", building.getName());
        buildingTransformer.addBuildings(List.of(building));
    }

    // Endpoint: Pobierz pomieszczenia przekraczające próg zużycia energii cieplnej
    @GetMapping("/{id}/rooms-above-threshold/{threshold}")
    public List<Room> getRoomsAboveThreshold(@PathVariable int id, @PathVariable float threshold) {
        logger.info("Fetching rooms with heating above {} for building with ID: {}", threshold, id);
        return buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + id + " not found"))
                .getRoomsAboveEnergyThreshold(threshold);
    }
}
