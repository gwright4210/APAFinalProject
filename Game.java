import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    int turn = 1;
    char player = 'R';
    boolean winner = false;
    Scanner in = new Scanner(System.in);

    Grid model = new Grid();
    GridView view = new GridView();
    GridController control = new GridController(model, view);
    
    // bugs I need to fix
	// input error 
    public int validInput() {
        int play = -1;
        System.out.print("Player " + player + ", choose a column: ");

        try {
            play = in.nextInt();
        }catch(InputMismatchException ex) {
            System.out.println("Enter a valid input.");
			in.nextLine();
            validInput();
        }
        return play;
    }
    
    public void playGame(){
        while(winner == false && turn <= 42){
            boolean validPlay;
            int play;
			do {
				//show grid
				control.updatedView();

				//validate input
                play = validInput();
                
				//validate play
				validPlay = validate(play, model.getGrid());
                
			}while (validPlay == false);
			
			//drop the checker
			for (int row = model.getGrid().length-1; row >= 0; row--){
				if(model.getGrid()[row][play] == ' '){
					model.getGrid()[row][play] = player;
					break;
				}
			}
			
			//determine if there is a winner
			winner = isWinner(player, model.getGrid());
			
			//switch players
			if (player == 'R'){
				player = 'B';
			}else{
				player = 'R';
			}
			
			turn++;			
		}
		control.updatedView();
		
		if (winner){
			if (player=='R'){
				System.out.println("Black won");
			}else{
				System.out.println("Red won");
			}
		}else{
			System.out.println("Tie game");
		}
		
	}
	
	public static boolean validate(int column, char[][] grid){
		//valid column?
		if (column < 0 || column > 6){
			return false;
		}
		
		//full column?
		if (grid[0][column] != ' '){
			return false;
		}
		return true;
	}
	
	public static boolean isWinner(char player, char[][] grid){
		//check for 4 across
		for(int row = 0; row<grid.length; row++){
			for (int col = 0;col < grid[0].length - 3;col++){
				if (grid[row][col] == player   && 
					grid[row][col+1] == player &&
					grid[row][col+2] == player &&
					grid[row][col+3] == player){
					return true;
				}
			}			
		}
		//check for 4 up and down
		for(int row = 0; row < grid.length - 3; row++){
			for(int col = 0; col < grid[0].length; col++){
				if (grid[row][col] == player   && 
					grid[row+1][col] == player &&
					grid[row+2][col] == player &&
					grid[row+3][col] == player){
					return true;
				}
			}
		}
		//check upward diagonal
		for(int row = 3; row < grid.length; row++){
			for(int col = 0; col < grid[0].length - 3; col++){
				if (grid[row][col] == player   && 
					grid[row-1][col+1] == player &&
					grid[row-2][col+2] == player &&
					grid[row-3][col+3] == player){
					return true;
				}
			}
		}
		//check downward diagonal
		for(int row = 0; row < grid.length - 3; row++){
			for(int col = 0; col < grid[0].length - 3; col++){
				if (grid[row][col] == player   && 
					grid[row+1][col+1] == player &&
					grid[row+2][col+2] == player &&
					grid[row+3][col+3] == player){
					return true;
				}
			}
		}
		return false;
	}
}
    


