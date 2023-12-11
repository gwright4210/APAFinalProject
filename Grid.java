
 
    public class Grid {
        //initialize array
        char[][] grid = new char[6][7];

        public Grid() {
            //initialize array
            for (int row = 0; row < grid.length; row++){
                for (int col = 0; col < grid[0].length; col++){
                    grid[row][col] = ' ';
                }
            }
        }

        public void setCell(int row, int col, char value){
            grid[row][col] = value;
        }

        public char[][] getGrid() {return grid;}
    }
    
    class GridView{
        public void display(char[][] grid){
            System.out.println(" 0 1 2 3 4 5 6");
            System.out.println("---------------");
            for (int row = 0; row < grid.length; row++){
                System.out.print("|");
                for (int col = 0; col < grid[0].length; col++){
                    System.out.print(grid[row][col]);
                    System.out.print("|");
                }
                System.out.println();
                System.out.println("---------------");
            }
            System.out.println(" 0 1 2 3 4 5 6");
            System.out.println();
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
    
         public void setCell(int row, int col, char value){
           model.setCell(row, col, value);
        }
    }

