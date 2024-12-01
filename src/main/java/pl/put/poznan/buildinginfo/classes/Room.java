package pl.put.poznan.buildinginfo.classes;


public class Room extends Location {
//miejsce na dane
//powierzchnia, ogrzewanie, swiatło i kubatura
private float area;
private float heating;
private float light;
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

}
