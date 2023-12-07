
public class Game {
    int turn = 1;
    String playerOne = "Player One";
    String playerTwo = "Player Two";
    String winner = "Tie Game";
    boolean hasWon = false;

    Grid model = new Grid();
    GridView view = new GridView();
    GridController control = new GridController(model, view);

    
    
    
    public String playGame(){
        while(hasWon == false){
            control.updatedView();

        }
        return winner;
    }
}

