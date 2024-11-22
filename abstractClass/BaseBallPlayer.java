package abstractClass;

public class BaseBallPlayer extends Athlete {

    private int swingSpeed;

    public BaseBallPlayer(String name, int age, int playerSwingSpeed){
        super(name, age);
        swingSpeed = playerSwingSpeed;
    }

    public void speed()
    {
       System.out.println(getName() + "'s swing speed is " + swingSpeed + " miles per hour.");
    }

    public char type(){
        return 'b';
    }

    public void baseBallHello(){
        System.out.println(getName() + " says a Baseball Baseball Hello!");
    }

}