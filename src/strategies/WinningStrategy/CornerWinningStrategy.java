package strategies.WinningStrategy;

import Models.*;

public class CornerWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Move move) {
        int boardSize = board.getBoard().size();
        Player currentPlayer = move.getCell().getPlayer();

        int [] row = {0,boardSize-1,0,boardSize-1};
        int [] col = {0,0,boardSize-1,boardSize-1};
        for(int i = 0; i<4; i++)
        {
            Cell curCell = move.getCell();
            if(curCell.getCellStatus().equals(CellStatus.Empty)||
                    !(currentPlayer.equals(curCell.getPlayer())))
                return false;
        }
        return true;
    }
}
