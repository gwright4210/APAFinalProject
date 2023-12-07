//import java.util.Scanner;
public class Main{
    public static void main(String[] args) {

        Game game = new Game();
        game.playGame();
    }
}

/* 
class Grid{
    //initialize array
    private char[][] grid = new char[6][7];

    public Grid(){
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++){
                grid[row][col] = ' ';
            }
        }
    }
    public void setCell(int row, int col, char value){
        grid[row][col] = value;
    }

    public char[][] getGrid(){
        return grid;
    }
}

class GridView{
    public void displayGrid(char[][] grid){
        for(char[] row : grid){
            for(char cell : row){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}

class GridController{
    private Grid model;
    private GridView view;

    public GridController(Grid model, GridView view){
        this.model = model;
        this.view = view;
    }

    public void updatedView() {
        view.displayGrid(model.getGrid());
    }

     public void setCell(int row, int col, char value){
       model.setCell(row, col, value);
    }
}
*/