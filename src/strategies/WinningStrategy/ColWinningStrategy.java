package strategies.WinningStrategy;

import Models.Board;
import Models.CellStatus;
import Models.Move;
import Models.Player;

public class ColWinningStrategy implements WinningStrategy{

    @Override
    public boolean checkWinner(Board board, Move move) {
        //boolean flag = false;
        int col = move.getCell().getCol();
        Player player = move.getCell().getPlayer();
        for(int i = 0; i<board.getBoard().size(); i++)
        {
            if(board.getBoard().get(i).get(col).getCellStatus().equals(CellStatus.Empty)||
                    !board.getBoard().get(i).get(col).getPlayer().equals(player))
                return false;
        }
        return true;
    }
}
