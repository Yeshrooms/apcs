package abstractClass;

public class SoccerPlayer extends Athlete {

    private int kickSpeed;

    public SoccerPlayer(String name, int age, int playerKickSpeed){
        super(name, age);
        kickSpeed = playerKickSpeed;
    }

    public void speed()
    {
       System.out.println(getName() + "'s kick speed is " + kickSpeed + " miles per hour.");
    }

    public char type(){
        return 's';
    }
    
    public void soccerHello(){
        System.out.println(getName() + " says a Soccer Soccer Hello!");
    }

}