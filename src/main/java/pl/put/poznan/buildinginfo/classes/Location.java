package pl.put.poznan.buildinginfo.classes;



public abstract class Location {

    private int id;
    private String name;
  
    public Location(int id, String name) {
          this.id = id;
          this.name = name;
      }

  //miejsce na gettery (getID, getName)
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    //miejsce na settery (setID,setName)
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    //gettery i settery tych parametrów (kubatura, oświetlenie itd)
    public float getArea(){
        return 0;
    }

    public float getHeating(){
        return 0;
    }
    public float getLight(){
        return 0;
    }
    public float getCube(){
        return 0;
    }


}
