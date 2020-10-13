import java.util.Scanner;
public class main {
    public static void main ( String[] args ){
        Player p = new Player();
        while ( true ){
            Scanner input = new Scanner(System.in);
            p.takeTurn();
            System.out.print( "Play again? (Y/N) : " );
            boolean userInput = CheckInput.getYesNo();
            System.out.println();
            //Ends the game if no and loops again if yes
            if ( userInput == false){
                System.out.println( "Game Over" );
                System.out.println( "Final Score = " + p.getPoints() + " points" );
                break;
            }
        }
    }
}
