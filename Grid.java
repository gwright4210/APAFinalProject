
 
    public class Grid {
        //initialize array
        String[][] grid = new String[6][7];

        public Grid() {
            //initialize array
            for (int row = 0; row < grid.length; row++){
                for (int col = 0; col < grid[0].length; col++){
                    grid[row][col] = " ";
                }
            }
        }

        public void setCell(int row, int col, String value){
            grid[row][col] = value;
        }

        public String[][] getGrid() {return grid;}
    }
    
    class GridView{
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String BLACK = "\u001B[30m";
        String BLUE = "\u001b[34m";
        public void display(String[][] grid){
            System.out.println(BLUE);
            System.out.println(" 0 1 2 3 4 5 6");
            System.out.println("---------------");
            for (int row = 0; row < grid.length; row++){
                System.out.print(BLUE + "|");
                for (int col = 0; col < grid[0].length; col++){
                    System.out.print(RESET);
                    System.out.print(grid[row][col]);
                    System.out.print(BLUE + "|");
                }
                System.out.println(BLUE);
                System.out.println("---------------");
            }
            System.out.println(" 0 1 2 3 4 5 6");
            System.out.println(RESET);
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
            view.display(model.getGrid());
        }
    
         public void setCell(int row, int col, String value){
           model.setCell(row, col, value);
        }
    }

