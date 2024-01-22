package Models;

import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
    private int id;
    private PlayerType playerType;

    private Scanner scanner;

    //    public Player(String name, char symbol, int id, PlayerType playerType) {
//        this.name = name;
//        this.symbol = symbol;
//        this.id = id;
//        this.playerType = playerType;
//    }
    private static boolean cellAvailable(Board board)
    {
        for(int i = 0; i<board.getBoard().size(); i++)
        {
            for(int j = 0; j<board.getBoard().size(); j++)
            {
                if(board.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.Empty))
                    return true;
            }
        }
        return false;
    }
    public Move makeMove(Board board)
    {   if(!cellAvailable(board)){
        return null;
    }



        System.out.println("Enter the row and col of the move you want to make");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        Cell cell = new Cell(row,col,CellStatus.Occupied,this);
        System.out.printf("The player %s is making a move to row %d and col %d\n",this.getName(),cell.getRow(),cell.getCol());
        if(board.getBoard().get(row).get(col).getCellStatus().equals(CellStatus.Occupied))
        {
            throw new IllegalArgumentException("This cell is already occupied, select another");

        }
        //cell.setPlayer(this);
        return new Move(cell);
    }
    public Player(String name, char symbol, int id, PlayerType playerType, Scanner scanner) {
        this.name = name;
        this.symbol = symbol;
        this.id = id;
        this.playerType = playerType;
        this.scanner = scanner;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getId() {
        return id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
