package beeProject;

public class beeAStar 
{

  public static int[][][] cube;

  public beeAStar(int length){
    cube = new int[length][length][length];
    for(int xx=0; xx< cube.length;xx++)
    {
      for(int yy=0;yy<cube[xx].length;yy++)
      {
        for (int zz=0; zz<cube[yy].length;zz++){
          cube[xx][yy][zz]=1;
        }
      }
    }
  }
  /*
  a grid value of 1 means the point is open
  a grid value of -1 means the point has DEBRIS
  a grid value of 2 means, FOR THIS MOVE OF 1 BEE, the point
     PRECEEDE a likely move to a point filled with DEBRIS
     for a grid qith a value of 2, set D to 2

     YOU MUST RESET THESE VALUES BACK TO ZERO (0)  ONCE THE BEE REACHED ITS HIVE

  */
  public static int counter;

  public void addDebris(int x, int y, int z){
    cube[x][y][z] = -1;
  }
  
  public int travel(int cnx, int cny, int cnz, int gx, int gy, int gz)
  {
    counter = 0;
    int goalx=gx,goaly=gy,goalz=gz,d=1,gn=1;
    int cnodex = cnx, cnodey = cny, cnodez = cnz;

   /* dx = Math.abs(cnodex-goalx);
     dy = Math.abs(cnodey-goaly);

    int hn = d*(dx+dy);
    int gn = 1;
    int fn = gn + hn;
    */

    int BM[];

    //  ITERATE THRU MOVES UNTIL THE GOAL IS REACHED
    while(true)
      {
   //   BM = bestMove(cnodex,cnodey,goalx,goaly,d,gn);
      BM = bestMovePRIME(cnodex,cnodey,cnodez,goalx,goaly,goalz,d,gn);

      // System.out.println("BEST MOVE FROM (" + cnodex + "," + cnodey + "," + cnodez + ")  IS TO  ("+BM[0] + ","+ BM[1] + "," + BM[2] + ")");
  
      cnodex = BM[0];
      cnodey = BM[1];
      cnodez = BM[2];
      counter++;

        if(cnodex == goalx && cnodey == goaly && cnodez == goalz)
        {
          // System.out.println("THE BEE HAS REACHED ITS GOAL !!!");
          break;
        }
      }
      return(counter);
  }


  // return -1 for debris, 0 for open, -2 for out of bounds value
  static int isThereDebris(int x, int y, int z)
  {
    /* -1 indicates debris OR 1 indicates Point we are evluating is outside the 
    bounds of the grid */
    if(x >= cube.length || y >= cube.length || z >= cube.length){
      return -2;
    }
    if(x <= 0 || y <= 0 || z <= 0){
      return -2;
    }
    else if(cube[x][y][z] == -1){
      return -1;
    }
    else{
      return 0;
    }
  }
  /*
    BEFORE calculating the thnA value, we call this method to check to see 
    if the point is one to be lightly considered due to it being a point
    preceding a blocked point (debris), in this case the point has a value of 2
    which should be used as the d value in the thnA calculation, so return that
    value, otherwise return 1
  */
  static int setD(int x, int y, int z)
  {
    if(cube[x][y][z] == 2){
      return 2;
    }
    else{
      return 1;
    }

  }

  static int[] bestMovePRIME(int nx, int ny, int nz, int gx, int gy, int gz, int d, int gn) 
  {
    int hnA = 0; // best h(n)
    int thnA = 0; // temp h(n)
    int bx=0,by=0,bz=0;  // best x y move
    int dx,dy,dz;     // heuristics
    int adjX=0, adjY=0, adjZ=0;
    int debrisCheck=0;
   
    for(int i = 0;i<18;i++) // loop thru possib le moves, N S E W
      {
        adjX = nx;
        adjY = ny;
        adjZ = nz;
        if (i == 0){
          adjX++;
        }
        if (i == 1){
          adjX--;
        }
        if (i == 2){
          adjY++;
        }
        if (i == 3){
          adjY--;
        }
        if (i == 4){
          adjZ++;
        }
        if (i == 5){
          adjZ--;
        }

        if (i == 6){
          adjX++;
          adjY++;
        }
        if (i == 7){
          adjX++;
          adjY--;
        }
        if (i == 8){
          adjX--;
          adjY++;
        }
        if (i == 9){
          adjX--;
          adjY--;
        }

        if (i == 10){
          adjX++;
          adjZ++;
        }
        if (i == 11){
          adjX++;
          adjZ--;
        }
        if (i == 12){
          adjX--;
          adjZ++;
        }
        if (i == 13){
          adjX--;
          adjZ--;
        }

        if (i == 14){
          adjY++;
          adjZ++;
        }
        if (i == 15){
          adjY++;
          adjZ--;
        }
        if (i == 16){
          adjY--;
          adjZ++;
        }
        if (i == 17){
          adjY--;
          adjZ--;
        }
        
        
      debrisCheck = isThereDebris(adjX, adjY, adjZ); //-1 debris, 1 out of grid point
  
      if(debrisCheck < 0) // cant use this node or vertix
        {
         thnA = 99999; 
          
          if(debrisCheck == -1)
          {
             cube[nx][ny][nz] = 2;
          }
        }
        else // debrisCheck  is 0 so CALC a thnA
        {
          d = setD(adjX,adjY,adjZ);
          dx = Math.abs(adjX-gx);
          dy = Math.abs(adjY-gy);
          dz = Math.abs(adjZ-gz);
          thnA = d*(dx+dy+dz) + gn;

        }
       //////////////// SHOULD ONLY DO IF debrisCheck = 0       
        if(thnA <= hnA || hnA == 0)
        {
         hnA = thnA;
         bx= adjX;
         by=adjY;
         bz = adjZ;
        }
      }
 
    int fxy[] = new int[] {bx,by,bz};
    return fxy;
  }
}

