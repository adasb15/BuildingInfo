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
import pl.put.poznan.buildinginfo.classes.Room;
import pl.put.poznan.buildinginfo.logic.BuildingTransformer;

/**
 * The {@code BuildingInfoController} class is a REST controller responsible for handling HTTP requests
 * related to buildings, floors, and rooms. It provides endpoints for calculating various attributes such as
 * area, volume (cube), lighting, heating, and energy efficiency.
 */
@RestController
@RequestMapping("/api/building")
public class BuildingInfoController {

    /**
     * Logger for tracking activities within the controller.
     */
    private final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);
    
    /**
     * Transformer for managing and processing building data.
     */
    private final BuildingTransformer buildingTransformer;

    /**
     * Constructs a {@code BuildingInfoController} with a provided {@link BuildingTransformer}.
     *
     * @param buildingTransformer the transformer for managing buildings
     */
    public BuildingInfoController(BuildingTransformer buildingTransformer) {
        this.buildingTransformer = buildingTransformer;
    }

    /**
     * Calculates the total area of a building by its ID.
     *
     * @param buildings the list of buildings received in the request body
     * @param id the ID of the building
     * @return a response entity containing the calculated area or an error message
     */
    @PostMapping(value = "/{id}/area", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateBuildingArea(@RequestBody List<Building> buildings, @PathVariable int id) {
        logger.info(">> calculateBuildingArea: ID = {}", id);

        for (Building building : buildings) {
            buildingTransformer.addBuildingFromJson(building);
        }

        String result = buildingTransformer.getAreaOfBuilding(id);

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);

        logger.info("<< calculateBuildingArea: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * Calculates the area of a floor within a building.
     *
     * @param buildings the list of buildings received in the request body
     * @param buildingId the ID of the building
     * @param floorId the ID of the floor
     * @return a response entity containing the calculated floor area or an error message
     */
    @PostMapping(value = "/{buildingId}/floor/{floorId}/area", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateFloorArea(@RequestBody List<Building> buildings, @PathVariable int buildingId, @PathVariable int floorId) {
        logger.info(">> calculateFloorArea: Building ID = {}, Floor ID = {}", buildingId, floorId);

        for (Building building : buildings) {
            buildingTransformer.addBuildingFromJson(building);
        }

        String result = buildingTransformer.getAreaOfFloor(buildingId, floorId);

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);

        logger.info("<< calculateFloorArea: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

     /**
     * Calculates the area of a room within a floor and building.
     *
     * @param buildings the list of buildings received in the request body
     * @param buildingId the ID of the building
     * @param floorId the ID of the floor
     * @param roomId the ID of the room
     * @return a response entity containing the calculated room area or an error message
     */
    @PostMapping(value = "/{buildingId}/floor/{floorId}/room/{roomId}/area", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateRoomArea(@RequestBody List<Building> buildings, @PathVariable int buildingId, @PathVariable int floorId, @PathVariable int roomId) {
        logger.info(">> calculateRoomArea: Building ID = {}, Floor ID = {}, Room ID = {}", buildingId, floorId, roomId);

        for (Building building : buildings) {
            buildingTransformer.addBuildingFromJson(building);
        }

        String result = buildingTransformer.getAreaOfRoom(buildingId, floorId, roomId);

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);

        logger.info("<< calculateRoomArea: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * Calculates the volume (cube) of a building by its ID.
     *
     * @param buildings the list of buildings received in the request body
     * @param id the ID of the building
     * @return a response entity containing the calculated volume or an error message
     */
    @PostMapping(value = "/{id}/cube", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateBuildingCube(@RequestBody List<Building> buildings, @PathVariable int id) {
        logger.info(">> calculateBuildingCube: ID = {}", id);
        
        for (Building building : buildings) {
            buildingTransformer.addBuildingFromJson(building);
        }

        String result = buildingTransformer.getCubeOfBuilding(id);
        
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        
        logger.info("<< calculateBuildingCube: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * Calculates the volume (cube) of a floor within a building.
     *
     * @param buildings the list of buildings received in the request body
     * @param buildingId the ID of the building
     * @param floorId the ID of the floor
     * @return a response entity containing the calculated floor volume or an error message
     */
    @PostMapping(value = "/{buildingId}/floor/{floorId}/cube", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateFloorCube(@RequestBody List<Building> buildings, @PathVariable int buildingId, @PathVariable int floorId) {
        logger.info(">> calculateFloorCube: Building ID = {}, Floor ID = {}", buildingId, floorId);
        
        for (Building building : buildings) {
            buildingTransformer.addBuildingFromJson(building);
        }

        String result = buildingTransformer.getCubeOfFloor(buildingId, floorId);
        
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        
        logger.info("<< calculateFloorCube: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * Calculates the volume (cube) of a room within a floor and building.
     *
     * @param buildings the list of buildings received in the request body
     * @param buildingId the ID of the building
     * @param floorId the ID of the floor
     * @param roomId the ID of the room
     * @return a response entity containing the calculated room volume or an error message
     */
    @PostMapping(value = "/{buildingId}/floor/{floorId}/room/{roomId}/cube", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateRoomCube(@RequestBody List<Building> buildings, @PathVariable int buildingId, @PathVariable int floorId, @PathVariable int roomId) {
        logger.info(">> calculateRoomCube: Building ID = {}, Floor ID = {}, Room ID = {}", buildingId, floorId, roomId);
        
        for (Building building : buildings) {
            buildingTransformer.addBuildingFromJson(building);
        }

        String result = buildingTransformer.getCubeOfRoom(buildingId, floorId, roomId);
        
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        
        logger.info("<< calculateRoomCube: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * Calculates the lighting efficiency of a building by its ID.
     *
     * @param buildings the list of buildings received in the request body
     * @param id the ID of the building
     * @return a response entity containing the calculated lighting efficiency or an error message
     */
    @PostMapping(value = "/{id}/light", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateBuildingLight(@RequestBody List<Building> buildings, @PathVariable int id) {
        logger.info(">> calculateBuildingLight: ID = {}", id);
        
        for (Building building : buildings) {
            buildingTransformer.addBuildingFromJson(building);
        }
        
        String result = buildingTransformer.getLightOfBuilding(id);
        
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        
        logger.info("<< calculateBuildingLight: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * Calculates the lighting efficiency of a floor within a building by their IDs.
     *
     * @param buildings the list of buildings received in the request body
     * @param buildingId the ID of the building
     * @param floorId the ID of the floor
     * @return a response entity containing the calculated lighting efficiency of the floor or an error message
     */
    @PostMapping(value = "/{buildingId}/floor/{floorId}/light", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateFloorLight(@RequestBody List<Building> buildings, @PathVariable int buildingId, @PathVariable int floorId) {
        logger.info(">> calculateFloorLight: Building ID = {}, Floor ID = {}", buildingId, floorId);
        
        for (Building building : buildings) {
            buildingTransformer.addBuildingFromJson(building);
        }
        
        String result = buildingTransformer.getLightOfFloor(buildingId, floorId);
        
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        
        logger.info("<< calculateFloorLight: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * Calculates the lighting efficiency of a room within a floor and building by their IDs.
     *
     * @param buildings the list of buildings received in the request body
     * @param buildingId the ID of the building
     * @param floorId the ID of the floor
     * @param roomId the ID of the room
     * @return a response entity containing the calculated lighting efficiency of the room or an error message
     */
    @PostMapping(value = "/{buildingId}/floor/{floorId}/room/{roomId}/light", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateRoomLight(@RequestBody List<Building> buildings, @PathVariable int buildingId, @PathVariable int floorId, @PathVariable int roomId) {
        logger.info(">> calculateRoomLight: Building ID = {}, Floor ID = {}, Room ID = {}", buildingId, floorId, roomId);
        
        for (Building building : buildings) {
            buildingTransformer.addBuildingFromJson(building);
        }
        
        String result = buildingTransformer.getLightOfRoom(buildingId, floorId, roomId);
        
        Map<String, String> responseBody = new HashMap<>();
        
        responseBody.put("result", result);
        logger.info("<< calculateRoomLight: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * Calculates the heating efficiency of a building by its ID.
     *
     * @param buildings the list of buildings received in the request body
     * @param id the ID of the building
     * @return a response entity containing the calculated heating efficiency or an error message
     */
    @PostMapping(value = "/{id}/heating", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateBuildingHeating(@RequestBody List<Building> buildings, @PathVariable int id) {
        logger.info(">> calculateBuildingHeating: ID = {}", id);
        
        for (Building building : buildings) {
            buildingTransformer.addBuildingFromJson(building);
        }
        
        String result = buildingTransformer.getHeatingOfBuilding(id);
        
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        
        logger.info("<< calculateBuildingHeating: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * Calculates the heating efficiency of a floor within a building by their IDs.
     *
     * @param buildings the list of buildings received in the request body
     * @param buildingId the ID of the building
     * @param floorId the ID of the floor
     * @return a response entity containing the calculated heating efficiency of the floor or an error message
     */
    @PostMapping(value = "/{buildingId}/floor/{floorId}/heating", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateFloorHeating(@RequestBody List<Building> buildings, @PathVariable int buildingId, @PathVariable int floorId) {
        logger.info(">> calculateFloorHeating: Building ID = {}, Floor ID = {}", buildingId, floorId);
        
        for (Building building : buildings) {
            buildingTransformer.addBuildingFromJson(building);
        }
        
        String result = buildingTransformer.getHeatingOfFloor(buildingId, floorId);
        
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        
        logger.info("<< calculateFloorHeating: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * Calculates the heating efficiency of a room within a floor and building by their IDs.
     *
     * @param buildings the list of buildings received in the request body
     * @param buildingId the ID of the building
     * @param floorId the ID of the floor
     * @param roomId the ID of the room
     * @return a response entity containing the calculated heating efficiency of the room or an error message
     */
    @PostMapping(value = "/{buildingId}/floor/{floorId}/room/{roomId}/heating", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> calculateRoomHeating(@RequestBody List<Building> buildings, @PathVariable int buildingId, @PathVariable int floorId, @PathVariable int roomId) {
        logger.info(">> calculateRoomHeating: Building ID = {}, Floor ID = {}, Room ID = {}", buildingId, floorId, roomId);
        
        for (Building building : buildings) {
            buildingTransformer.addBuildingFromJson(building);
        }
        
        String result = buildingTransformer.getHeatingOfRoom(buildingId, floorId, roomId);
        
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", result);
        
        logger.info("<< calculateRoomHeating: {}", result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }


    /**
     * Calculates the heating efficiency of a building by its ID.
     *
     * @param buildings the list of buildings received in the request body
     * @param id the ID of the building
     * @return a response entity containing the calculated heating efficiency or an error message
     */
    @PostMapping(value = "/{id}/heating", consumes = "application/json", produces = "application/json")
    @PostMapping(value = "/{id}/rooms_above_threshold/{threshold}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Double>> calculateBuildingHeat(@RequestBody List<Building> buildings, @PathVariable int id, @PathVariable float threshold) {
        logger.info(">> calculateRoomsAboveThreshold: ID = {}, threshold = {}", id, threshold);

        for (Building building : buildings) {
            buildingTransformer.addBuildingFromJson(building);
        }

        // Szukamy budynku po ID
        List<Room> foundRooms = buildingTransformer.getAllBuildings()
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Building with ID " + id + " not found"))
                .getRoomsAboveEnergyThreshold(threshold);

        Map<String, Double> responseBody = new HashMap<>();

        for (int i = 0; i < foundRooms.size(); i++) {
            responseBody.put("room_"+i, (double) foundRooms.get(i).getId());
        }

        logger.info("<< calculateRoomsAboveThreshold: {}", responseBody.toString());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * Handles invalid input data exceptions.
     *
     * @param ex the exception instance
     * @return a response entity containing the error message
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.error("Invalid input: {}", ex.getMessage());
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles general server errors.
     *
     * @param ex the exception instance
     * @return a response entity containing a generic error message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception ex) {
        logger.error("Unhandled exception", ex);
        Map<String, String> response = new HashMap<>();
        response.put("error", "Internal server error");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
