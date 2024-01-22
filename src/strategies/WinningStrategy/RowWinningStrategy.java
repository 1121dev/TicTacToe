package strategies.WinningStrategy;

import Models.Board;
import Models.CellStatus;
import Models.Move;
import Models.Player;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Player curPlayer = move.getCell().getPlayer();
        int boardSize = board.getBoard().size();
        for(int i = 0; i<boardSize; i++)
        {
            if(board.getBoard().get(row).get(i).getCellStatus().equals(CellStatus.Empty)||
                    !board.getBoard().get(row).get(i).getPlayer().equals(curPlayer))
                return false;
        }
        return true;
    }
}
