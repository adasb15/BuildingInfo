package pl.put.poznan.buildinginfo.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.put.poznan.buildinginfo.classes.Building;
import pl.put.poznan.buildinginfo.classes.Floor;
import pl.put.poznan.buildinginfo.classes.Room;
import pl.put.poznan.buildinginfo.logic.BuildingTransformer;

@RestController
@RequestMapping("/api/building")
public class BuildingInfoController {

    // Logger do rejestrowania działań w kontrolerze
    private final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);
    
    // Transformator do zarządzania budynkami
    private final BuildingTransformer buildingTransformer;

    // Konstruktor przyjmujący transformer budynków
    public BuildingInfoController(BuildingTransformer buildingTransformer) {
        this.buildingTransformer = buildingTransformer;
    }

    // Endpoint do obliczania powierzchni budynku
    @PostMapping(value = "/{id}/area", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Double>> calculateBuildingArea(@RequestBody Building building, @PathVariable int id) {
        logger.info(">> calculateBuildingArea: ID = {}", id);

        // Dodajemy budynek do listy w transformerze
        buildingTransformer.addBuildingFromJson(building);

        // Szukamy budynku po ID
        Building foundBuilding = buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + id + " not found"));

        // Obliczamy powierzchnię budynku
        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("area", (double) foundBuilding.getBuildingArea());

        logger.info("<< calculateBuildingArea: {}", responseBody.toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Endpoint do obliczania powierzchni piętra
    @PostMapping(value = "/{buildingId}/floor/{floorId}/area", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Double>> calculateFloorArea(@RequestBody Building building, @PathVariable int buildingId, @PathVariable int floorId) {
        logger.info(">> calculateFloorArea: Building ID = {}, Floor ID = {}", buildingId, floorId);

        // Dodajemy budynek do listy w transformerze
        buildingTransformer.addBuildingFromJson(building);

        // Szukamy budynku po ID
        Building foundBuilding = buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == buildingId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + buildingId + " not found"));

        // Szukamy piętra po ID
        Floor foundFloor = foundBuilding.getFloors()
                .stream()
                .filter(f -> f.getId() == floorId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Floor with ID " + floorId + " not found"));

        // Obliczamy powierzchnię piętra
        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("area", (double) foundFloor.getFloorArea());

        logger.info("<< calculateFloorArea: {}", responseBody.toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Endpoint do obliczania powierzchni pomieszczenia
    @PostMapping(value = "/{buildingId}/floor/{floorId}/room/{roomId}/area", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Double>> calculateRoomArea(@RequestBody Building building, @PathVariable int buildingId, @PathVariable int floorId, @PathVariable int roomId) {
        logger.info(">> calculateRoomArea: Building ID = {}, Floor ID = {}, Room ID = {}", buildingId, floorId, roomId);

        // Dodajemy budynek do listy w transformerze
        buildingTransformer.addBuildingFromJson(building);

        // Szukamy budynku po ID
        Building foundBuilding = buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == buildingId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + buildingId + " not found"));

        // Szukamy piętra po ID
        Floor foundFloor = foundBuilding.getFloors()
                .stream()
                .filter(f -> f.getId() == floorId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Floor with ID " + floorId + " not found"));

        // Szukamy pomieszczenia po ID
        Room foundRoom = foundFloor.getRooms()
                .stream()
                .filter(r -> r.getId() == roomId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Room with ID " + roomId + " not found"));

        // Obliczamy powierzchnię pomieszczenia
        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("area", (double) foundRoom.getArea());

        logger.info("<< calculateRoomArea: {}", responseBody.toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Endpoint do obliczania kubatury budynku
    @PostMapping(value = "/{id}/cube", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Double>> calculateBuildingCube(@RequestBody Building building, @PathVariable int id) {
        logger.info(">> calculateBuildingCube: ID = {}", id);

        // Dodajemy budynek do listy w transformerze
        buildingTransformer.addBuildingFromJson(building);

        // Szukamy budynku po ID
        Building foundBuilding = buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + id + " not found"));

        // Obliczamy kubaturę budynku
        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("cube", (double) foundBuilding.getBuildingCube());

        logger.info("<< calculateBuildingCube: {}", responseBody.toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Endpoint do obliczania kubatury piętra
    @PostMapping(value = "/{buildingId}/floor/{floorId}/cube", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Double>> calculateFloorCube(@RequestBody Building building, @PathVariable int buildingId, @PathVariable int floorId) {
        logger.info(">> calculateFloorCube: Building ID = {}, Floor ID = {}", buildingId, floorId);

        // Dodajemy budynek do listy w transformerze
        buildingTransformer.addBuildingFromJson(building);

        // Szukamy budynku po ID
        Building foundBuilding = buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == buildingId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + buildingId + " not found"));

        // Szukamy piętra po ID
        Floor foundFloor = foundBuilding.getFloors()
                .stream()
                .filter(f -> f.getId() == floorId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Floor with ID " + floorId + " not found"));

        // Obliczamy kubaturę piętra
        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("cube", (double) foundFloor.getFloorCube());

        logger.info("<< calculateFloorCube: {}", responseBody.toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Endpoint do obliczania kubatury pomieszczenia
    @PostMapping(value = "/{buildingId}/floor/{floorId}/room/{roomId}/cube", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Double>> calculateRoomCube(@RequestBody Building building, @PathVariable int buildingId, @PathVariable int floorId, @PathVariable int roomId) {
        logger.info(">> calculateRoomCube: Building ID = {}, Floor ID = {}, Room ID = {}", buildingId, floorId, roomId);

        // Dodajemy budynek do listy w transformerze
        buildingTransformer.addBuildingFromJson(building);

        // Szukamy budynku po ID
        Building foundBuilding = buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == buildingId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + buildingId + " not found"));

        // Szukamy piętra po ID
        Floor foundFloor = foundBuilding.getFloors()
                .stream()
                .filter(f -> f.getId() == floorId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Floor with ID " + floorId + " not found"));

        // Szukamy pomieszczenia po ID
        Room foundRoom = foundFloor.getRooms()
                .stream()
                .filter(r -> r.getId() == roomId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Room with ID " + roomId + " not found"));

        // Obliczamy kubaturę pomieszczenia
        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("cube", (double) foundRoom.getCube());

        logger.info("<< calculateRoomCube: {}", responseBody.toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Endpoint do obliczania ilości światła w budynku
    @PostMapping(value = "/{id}/light", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Double>> calculateBuildingLight(@RequestBody Building building, @PathVariable int id) {
        logger.info(">> calculateBuildingLight: ID = {}", id);

        // Dodajemy budynek do listy w transformerze
        buildingTransformer.addBuildingFromJson(building);

        // Szukamy budynku po ID
        Building foundBuilding = buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + id + " not found"));

        // Obliczamy ilość światła w budynku
        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("light", (double) foundBuilding.getAverageBuildingLight());

        logger.info("<< calculateBuildingLight: {}", responseBody.toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Endpoint do obliczania ilości światła w piętrze
    @PostMapping(value = "/{buildingId}/floor/{floorId}/light", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Double>> calculateFloorLight(@RequestBody Building building, @PathVariable int buildingId, @PathVariable int floorId) {
        logger.info(">> calculateFloorLight: Building ID = {}, Floor ID = {}", buildingId, floorId);

        // Dodajemy budynek do listy w transformerze
        buildingTransformer.addBuildingFromJson(building);

        // Szukamy budynku po ID
        Building foundBuilding = buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == buildingId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + buildingId + " not found"));

        // Szukamy piętra po ID
        Floor foundFloor = foundBuilding.getFloors()
                .stream()
                .filter(f -> f.getId() == floorId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Floor with ID " + floorId + " not found"));

        // Obliczamy ilość światła w piętrze
        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("light", (double) foundFloor.getAverageFloorLight());

        logger.info("<< calculateFloorLight: {}", responseBody.toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Endpoint do obliczania ilości światła w pomieszczeniu
    @PostMapping(value = "/{buildingId}/floor/{floorId}/room/{roomId}/light", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Double>> calculateRoomLight(@RequestBody Building building, @PathVariable int buildingId, @PathVariable int floorId, @PathVariable int roomId) {
        logger.info(">> calculateRoomLight: Building ID = {}, Floor ID = {}, Room ID = {}", buildingId, floorId, roomId);

        // Dodajemy budynek do listy w transformerze
        buildingTransformer.addBuildingFromJson(building);

        // Szukamy budynku po ID
        Building foundBuilding = buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == buildingId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + buildingId + " not found"));

        // Szukamy piętra po ID
        Floor foundFloor = foundBuilding.getFloors()
                .stream()
                .filter(f -> f.getId() == floorId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Floor with ID " + floorId + " not found"));

        // Szukamy pomieszczenia po ID
        Room foundRoom = foundFloor.getRooms()
                .stream()
                .filter(r -> r.getId() == roomId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Room with ID " + roomId + " not found"));

        // Obliczamy ilość światła w pomieszczeniu
        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("light", (double) foundRoom.getAverageRoomLight());

        logger.info("<< calculateRoomLight: {}", responseBody.toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Endpoint do obliczania ilości ciepła w budynku
    @PostMapping(value = "/{id}/heating", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Double>> calculateBuildingHeating(@RequestBody Building building, @PathVariable int id) {
        logger.info(">> calculateBuildingHeating: ID = {}", id);

        // Dodajemy budynek do listy w transformerze
        buildingTransformer.addBuildingFromJson(building);

        // Szukamy budynku po ID
        Building foundBuilding = buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + id + " not found"));

        // Obliczamy ilość ciepła w budynku
        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("heating", (double) foundBuilding.getAverageBuildingHeating());

        logger.info("<< calculateBuildingHeating: {}", responseBody.toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Endpoint do obliczania ilości ciepła w piętrze
    @PostMapping(value = "/{buildingId}/floor/{floorId}/heating", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Double>> calculateFloorHeating(@RequestBody Building building, @PathVariable int buildingId, @PathVariable int floorId) {
        logger.info(">> calculateFloorHeating: Building ID = {}, Floor ID = {}", buildingId, floorId);

        // Dodajemy budynek do listy w transformerze
        buildingTransformer.addBuildingFromJson(building);

        // Szukamy budynku po ID
        Building foundBuilding = buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == buildingId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + buildingId + " not found"));

        // Szukamy piętra po ID
        Floor foundFloor = foundBuilding.getFloors()
                .stream()
                .filter(f -> f.getId() == floorId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Floor with ID " + floorId + " not found"));

        // Obliczamy ilość ciepła w piętrze
        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("heating", (double) foundFloor.getAverageFloorHeating());

        logger.info("<< calculateFloorHeating: {}", responseBody.toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Endpoint do obliczania ilości ciepła w pomieszczeniu
    @PostMapping(value = "/{buildingId}/floor/{floorId}/room/{roomId}/heating", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Double>> calculateRoomHeating(@RequestBody Building building, @PathVariable int buildingId, @PathVariable int floorId, @PathVariable int roomId) {
        logger.info(">> calculateRoomHeating: Building ID = {}, Floor ID = {}, Room ID = {}", buildingId, floorId, roomId);

        // Dodajemy budynek do listy w transformerze
        buildingTransformer.addBuildingFromJson(building);

        // Szukamy budynku po ID
        Building foundBuilding = buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == buildingId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + buildingId + " not found"));

        // Szukamy piętra po ID
        Floor foundFloor = foundBuilding.getFloors()
                .stream()
                .filter(f -> f.getId() == floorId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Floor with ID " + floorId + " not found"));

        // Szukamy pomieszczenia po ID
        Room foundRoom = foundFloor.getRooms()
                .stream()
                .filter(r -> r.getId() == roomId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Room with ID " + roomId + " not found"));

        // Obliczamy ilość ciepła w pomieszczeniu
        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("heating", (double) foundRoom.getAverageRoomHeating());

        logger.info("<< calculateRoomHeating: {}", responseBody.toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/romms_above_threshold/{threshold}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Double>> calculateBuildingHeat(@RequestBody Building building, @PathVariable int id, @PathVariable float threshold) {
        logger.info(">> calculateRoomsAboveThreshold: ID = {}", id);

        // Dodajemy budynek do listy
        buildingTransformer.addBuildingFromJson(building);

        // Szukamy budynku po ID
        List<Room> foundRooms = buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + id + " not found"))
                .getRoomsAboveEnergyThreshold(threshold);

        // Obliczamy powierzchnię
        Map<String, Double> responseBody = new HashMap<>();

        for (int i = 0; i < foundRooms.size(); i++) {
            responseBody.put("room_" + i, (double) foundRooms.get(i).getId());
        }

        logger.info("<< calculateRoomsAboveThreshold: {}", responseBody.toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Obsługuje błędy związane z nieprawidłowymi danymi wejściowymi
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.error("Invalid input: {}", ex.getMessage());
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Obsługuje ogólne błędy serwera
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception ex) {
        logger.error("Unhandled exception", ex);
        Map<String, String> response = new HashMap<>();
        response.put("error", "Internal server error");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
