package abstractClass;

public abstract class Athlete extends Object
{
  private int age;
  private String name;

  public Athlete (String athleteName, int athleteAge){
    name = athleteName;
    age = athleteAge;
  }

  // each child determines conditioning level
  // ABSTRACT METHOD

  public abstract void speed();

  public abstract char type();

  public void setAge(int c)
  {
    age = c;
  }

  public int getAge()
  {
    return age;
  }

  public void setName(String cName){
    name = cName;
  }

  public String getName(){
    return name;
  }

}