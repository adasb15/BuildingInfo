package pl.put.poznan.buildinginfo.classes;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class FloorTest {

    private Floor floor;
    private Room roomMock1;
    private Room roomMock2;

    @BeforeEach
    public void setUp() {
        // Create mock objects for Room
        roomMock1 = mock(Room.class);
        roomMock2 = mock(Room.class);

        // Configure mock behavior
        when(roomMock1.getArea()).thenReturn(50.0f);
        when(roomMock2.getArea()).thenReturn(30.0f);

        when(roomMock1.getCube()).thenReturn(150.0f);
        when(roomMock2.getCube()).thenReturn(90.0f);

        when(roomMock1.getLight()).thenReturn(200.0f);
        when(roomMock2.getLight()).thenReturn(100.0f);

        when(roomMock1.getHeating()).thenReturn(500.0f);
        when(roomMock2.getHeating()).thenReturn(300.0f);

        when(roomMock1.getAverageRoomHeating()).thenReturn(10.0f);
        when(roomMock2.getAverageRoomHeating()).thenReturn(8.0f);

        // Create a Floor object and add mock rooms
        floor = new Floor();
        floor.setRooms(Arrays.asList(roomMock1, roomMock2));
    }

    @Test
    public void testGetFloorArea() {
        float result = floor.getFloorArea();
        assertEquals(80.0f, result, 0.001);
    }

    @Test
    public void testGetFloorCube() {
        float result = floor.getFloorCube();
        assertEquals(240.0f, result, 0.001);
    }

    @Test
    public void testGetFloorLight() {
        float result = floor.getFloorLight();
        assertEquals(300.0f, result, 0.001);
    }

    @Test
    public void testGetFloorHeating() {
        float result = floor.getFloorHeating();
        assertEquals(800.0f, result, 0.001);
    }

    @Test
    public void testGetAverageFloorLight() {
        float result = floor.getAverageFloorLight();
        assertEquals(3.75f, result, 0.001);
    }

    @Test
    public void testGetAverageFloorHeating() {
        float result = floor.getAverageFloorHeating();
        assertEquals(3.333f, result, 0.001);
    }

    @Test
    public void testGetRoomsAboveEnergyThreshold() {
        List<Room> result = floor.getRoomsAboveEnergyThreshold(9.0f);
        assertEquals(1, result.size());
        assertTrue(result.contains(roomMock1));
        assertFalse(result.contains(roomMock2));
    }

    @Test
    public void testInteractionsWithMocks() {
        // Verify that the mocked methods were called during the tests
        floor.getFloorArea();
        verify(roomMock1).getArea();
        verify(roomMock2).getArea();
    }
}
