package pl.put.poznan.buildinginfo.classes;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Room extends Location {
//miejsce na dane
//powierzchnia, ogrzewanie, swiatło i kubatura
@JsonProperty("area")
private float area;
@JsonProperty("heating")
private float heating;

@JsonProperty("light")
private float light;
@JsonProperty("cube")
private float cube;
//trzeba bedzie dodac te parametry ktore nalezy liczyc


//konstruktor
public Room (int id, String name, float area, float heating,
float light, float cube){
  super(id, name);
  this.area = area;
  this.heating = heating;
  this.light = light;
  this.cube = cube;
}

  public Room() {
    super(0, "");  // Konstruktor bezargumentowy wymagany dla wczytania JSON
  }
  //gettery (ale potem bo muszą byc override z Location)
  @Override
  public float getArea() {
      return area;
  }

  @Override
  public float getHeating() {
      return heating;
  }

  @Override
  public float getLight() {
      return light;
  }

  @Override
  public float getCube() {
      return cube;
  }

  public float getAverageRoomLight(){
    if (area == 0) {
      throw new IllegalArgumentException("Area cannot be zero for average light calculation.");
    }
    return light/area;
  }

  public float getAverageRoomHeating(){
    if (cube == 0) {
      throw new IllegalArgumentException("Cube cannot be zero for average heating calculation.");
    }
    return heating / cube;
  }
}
