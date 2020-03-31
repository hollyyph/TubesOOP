import java.util.Scanner;  // Import the Scanner class


class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);  // Create a Scanner object
    
    Game game = new Game();
    System.out.println("");
    for (int i = 1; i < 60; i++){
      System.out.print("=");
    }
    System.out.println("=");
    System.out.println("");
    System.out.println("WELCOME TO PLANT VS ZOMBIES");
    System.out.println("LET'S START THE GAME, SHALL WE?");
    System.out.println("");
    Game.arena.printArena();
    System.out.println("Sunflower Points = " + Game.sunflowerPoints);
    System.out.println("");
    while (!Game.end){
      Game.printCommand();
      String str = input.next();
      if (str.equals("SKIP")){
        Game.skip();
      } else if (str.equals("ADDPLANT")){
          int y = input.nextInt();
          int x = input.nextInt();
          String type = input.next();
          Game.addPlants(x, y, type);
          Game.skip();
      } else {
          System.out.println("Command salah!");
      }    
      Game.sunflowerPoints += 50;
      Game.arena.printArena();
      System.out.println("Sunflower Points = " + Game.sunflowerPoints);
      System.out.println("");
    }
    if (Game.end){
      System.out.println("GAME OVER");
      System.out.println("Points = " + Game.sunflowerPoints);
    }
    input.close();
  }
}