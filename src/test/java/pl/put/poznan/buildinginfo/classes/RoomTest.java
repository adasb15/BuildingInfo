package pl.put.poznan.buildinginfo.classes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Room class.
 */
public class RoomTest {

    private Room room;

    @BeforeEach
    public void setUp() {
        // Initialize the Room object with test values
        room = new Room(1, "Test Room", 50.0f, 500.0f, 200.0f, 150.0f);
    }

    @Test
    public void testGetArea() {
        float result = room.getArea();
        assertEquals(50.0f, result, 0.001);
    }

    @Test
    public void testGetHeating() {
        float result = room.getHeating();
        assertEquals(500.0f, result, 0.001);
    }

    @Test
    public void testGetLight() {
        float result = room.getLight();
        assertEquals(200.0f, result, 0.001);
    }

    @Test
    public void testGetCube() {
        float result = room.getCube();
        assertEquals(150.0f, result, 0.001);
    }

    @Test
    public void testGetAverageRoomLight() {
        float result = room.getAverageRoomLight();
        assertEquals(4.0f, result, 0.001);
    }

    @Test
    public void testGetAverageRoomHeating() {
        float result = room.getAverageRoomHeating();
        assertEquals(3.333f, result, 0.001);
    }

    @Test
    public void testGetAverageRoomLightThrowsException() {
        Room zeroAreaRoom = new Room(2, "Zero Area Room", 0.0f, 300.0f, 100.0f, 100.0f);
        assertThrows(IllegalArgumentException.class, zeroAreaRoom::getAverageRoomLight);
    }

    @Test
    public void testGetAverageRoomHeatingThrowsException() {
        Room zeroCubeRoom = new Room(3, "Zero Cube Room", 50.0f, 300.0f, 100.0f, 0.0f);
        assertThrows(IllegalArgumentException.class, zeroCubeRoom::getAverageRoomHeating);
    }
}
