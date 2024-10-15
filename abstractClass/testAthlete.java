package abstractClass;

public class testAthlete {
    class Main {
        public static void main(String[] args)
        {
          System.out.println("Hello world!");
       
          SoccerPlayer s = new SoccerPlayer();
       
          s.calcConditioningLevel();
       
          Athlete x = new SoccerPlayer();
          x.calcConditioningLevel();
       
          Athlete v = new BaseBallPlayer();
          v.calcConditioningLevel();
       
       
          // CAN I DO THIS ??
          Athlete a = new Athlete();
          // cant do THIS
          a.calcCondioningLevel();
       
        }
       }
       
}
