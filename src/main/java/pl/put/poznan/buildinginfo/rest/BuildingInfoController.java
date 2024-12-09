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
    public ResponseEntity<Map<String, String>> calculateBuildingArea(@PathVariable int id) {
        logger.info(">> calculateBuildingArea: ID = {}", id);

        // Call transformer to get the area
        String result = buildingTransformer.getAreaOfBuilding(id);

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);

        logger.info("<< calculateBuildingArea: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Endpoint do obliczania powierzchni piętra
    @PostMapping(value = "/{buildingId}/floor/{floorId}/area", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateFloorArea(@PathVariable int buildingId, @PathVariable int floorId) {
        logger.info(">> calculateFloorArea: Building ID = {}, Floor ID = {}", buildingId, floorId);

        // Call transformer to get the area
        String result = buildingTransformer.getAreaOfFloor(buildingId, floorId);

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);

        logger.info("<< calculateFloorArea: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Endpoint do obliczania powierzchni pomieszczenia
    @PostMapping(value = "/{buildingId}/floor/{floorId}/room/{roomId}/area", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateRoomArea(@PathVariable int buildingId, @PathVariable int floorId, @PathVariable int roomId) {
        logger.info(">> calculateRoomArea: Building ID = {}, Floor ID = {}, Room ID = {}", buildingId, floorId, roomId);

        // Call transformer to get the area
        String result = buildingTransformer.getAreaOfRoom(buildingId, floorId, roomId);

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);

        logger.info("<< calculateRoomArea: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Cubature Endpoints
    @PostMapping(value = "/{id}/cube", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateBuildingCube(@PathVariable int id) {
        logger.info(">> calculateBuildingCube: ID = {}", id);
        String result = buildingTransformer.getCubeOfBuilding(id);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        logger.info("<< calculateBuildingCube: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping(value = "/{buildingId}/floor/{floorId}/cube", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateFloorCube(@PathVariable int buildingId, @PathVariable int floorId) {
        logger.info(">> calculateFloorCube: Building ID = {}, Floor ID = {}", buildingId, floorId);
        String result = buildingTransformer.getCubeOfFloor(buildingId, floorId);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        logger.info("<< calculateFloorCube: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping(value = "/{buildingId}/floor/{floorId}/room/{roomId}/cube", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateRoomCube(@PathVariable int buildingId, @PathVariable int floorId, @PathVariable int roomId) {
        logger.info(">> calculateRoomCube: Building ID = {}, Floor ID = {}, Room ID = {}", buildingId, floorId, roomId);
        String result = buildingTransformer.getCubeOfRoom(buildingId, floorId, roomId);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        logger.info("<< calculateRoomCube: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Lighting Endpoints
    @PostMapping(value = "/{id}/light", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateBuildingLight(@PathVariable int id) {
        logger.info(">> calculateBuildingLight: ID = {}", id);
        String result = buildingTransformer.getLightOfBuilding(id);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        logger.info("<< calculateBuildingLight: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping(value = "/{buildingId}/floor/{floorId}/light", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateFloorLight(@PathVariable int buildingId, @PathVariable int floorId) {
        logger.info(">> calculateFloorLight: Building ID = {}, Floor ID = {}", buildingId, floorId);
        String result = buildingTransformer.getLightOfFloor(buildingId, floorId);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        logger.info("<< calculateFloorLight: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping(value = "/{buildingId}/floor/{floorId}/room/{roomId}/light", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateRoomLight(@PathVariable int buildingId, @PathVariable int floorId, @PathVariable int roomId) {
        logger.info(">> calculateRoomLight: Building ID = {}, Floor ID = {}, Room ID = {}", buildingId, floorId, roomId);
        String result = buildingTransformer.getLightOfRoom(buildingId, floorId, roomId);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        logger.info("<< calculateRoomLight: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Heating Endpoints
    @PostMapping(value = "/{id}/heating", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateBuildingHeating(@PathVariable int id) {
        logger.info(">> calculateBuildingHeating: ID = {}", id);
        String result = buildingTransformer.getHeatingOfBuilding(id);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        logger.info("<< calculateBuildingHeating: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping(value = "/{buildingId}/floor/{floorId}/heating", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateFloorHeating(@PathVariable int buildingId, @PathVariable int floorId) {
        logger.info(">> calculateFloorHeating: Building ID = {}, Floor ID = {}", buildingId, floorId);
        String result = buildingTransformer.getHeatingOfFloor(buildingId, floorId);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        logger.info("<< calculateFloorHeating: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping(value = "/{buildingId}/floor/{floorId}/room/{roomId}/heating", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateRoomHeating(@PathVariable int buildingId, @PathVariable int floorId, @PathVariable int roomId) {
        logger.info(">> calculateRoomHeating: Building ID = {}, Floor ID = {}, Room ID = {}", buildingId, floorId, roomId);
        String result = buildingTransformer.getHeatingOfRoom(buildingId, floorId, roomId);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        logger.info("<< calculateRoomHeating: {}", result);
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
