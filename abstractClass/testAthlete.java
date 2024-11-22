package abstractClass;

public class testAthlete {
      public static void main(String[] args)
      {

        Athlete[] playerList = new Athlete[5];
        playerList[0] = new SoccerPlayer("Daniel", 15, 60);
        playerList[1] = new BaseBallPlayer("Jake", 15, 72);
        playerList[2] = new BaseBallPlayer("Patricio", 16, 80);
        playerList[3] = new SoccerPlayer("Roger", 15, 55);
        playerList[4] = new BaseBallPlayer("Ryan", 15, 65);

        for (Athlete player : playerList){
          System.out.println(player.getName());
          player.speed();
        //   if (player.type() == 's'){
        //     player.soccerHello();
        //   }
        //   if (player.type() == 'b'){
        //     player.baseBallHello();
        //   }
        // }
       
      }
}