package pl.put.poznan.buildinginfo.classes;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

/**
 * Test class for the Building class.
 */
public class BuildingTest {

    private Building building;
    private Floor floorMock1;
    private Floor floorMock2;
    private Room roomMock1;
    private Room roomMock2;

    @BeforeEach
    public void setUp() {
        // Create mock objects for Floor and Room
        floorMock1 = mock(Floor.class);
        floorMock2 = mock(Floor.class);

        roomMock1 = mock(Room.class);
        roomMock2 = mock(Room.class);

        // Configure mock behavior for Room
        when(roomMock1.getAverageRoomHeating()).thenReturn(10.0f);
        when(roomMock2.getAverageRoomHeating()).thenReturn(8.0f);

        when(roomMock1.getArea()).thenReturn(50.0f);
        when(roomMock2.getArea()).thenReturn(30.0f);

        when(roomMock1.getCube()).thenReturn(150.0f);
        when(roomMock2.getCube()).thenReturn(90.0f);

        when(roomMock1.getLight()).thenReturn(200.0f);
        when(roomMock2.getLight()).thenReturn(100.0f);

        when(roomMock1.getHeating()).thenReturn(500.0f);
        when(roomMock2.getHeating()).thenReturn(300.0f);

        // Configure mock behavior for Floor
        when(floorMock1.getFloorArea()).thenReturn(80.0f);
        when(floorMock2.getFloorArea()).thenReturn(60.0f);

        when(floorMock1.getFloorCube()).thenReturn(240.0f);
        when(floorMock2.getFloorCube()).thenReturn(180.0f);

        when(floorMock1.getFloorLight()).thenReturn(300.0f);
        when(floorMock2.getFloorLight()).thenReturn(200.0f);

        when(floorMock1.getFloorHeating()).thenReturn(800.0f);
        when(floorMock2.getFloorHeating()).thenReturn(600.0f);

        when(floorMock1.getRoomsAboveEnergyThreshold(9.0f)).thenReturn(Arrays.asList(roomMock1));
        when(floorMock2.getRoomsAboveEnergyThreshold(9.0f)).thenReturn(Arrays.asList());

        // Create a Building object and add mock floors
        building = new Building();
        building.setFloors(Arrays.asList(floorMock1, floorMock2));
    }

    @Test
    public void testGetBuildingArea() {
        float result = building.getBuildingArea();
        assertEquals(140.0f, result, 0.001);
    }

    @Test
    public void testGetBuildingCube() {
        float result = building.getBuildingCube();
        assertEquals(420.0f, result, 0.001);
    }

    @Test
    public void testGetBuildingLight() {
        float result = building.getBuildingLight();
        assertEquals(500.0f, result, 0.001);
    }

    @Test
    public void testGetBuildingHeating() {
        float result = building.getBuildingHeating();
        assertEquals(1400.0f, result, 0.001);
    }

    @Test
    public void testGetAverageBuildingLight() {
        float result = building.getAverageBuildingLight();
        assertEquals(3.571f, result, 0.001);
    }

    @Test
    public void testGetAverageBuildingHeating() {
        float result = building.getAverageBuildingHeating();
        assertEquals(3.333f, result, 0.001);
    }

    @Test
    public void testGetRoomsAboveEnergyThreshold() {
        List<Room> result = building.getRoomsAboveEnergyThreshold(9.0f);
        assertEquals(1, result.size());
        assertTrue(result.contains(roomMock1));
    }

    @Test
    public void testInteractionsWithMocks() {
        // Verify that the mocked methods were called during the tests
        building.getBuildingArea();
        verify(floorMock1).getFloorArea();
        verify(floorMock2).getFloorArea();
    }
}
