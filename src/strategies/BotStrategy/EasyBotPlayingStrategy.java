package strategies.BotStrategy;

import Models.Board;
import Models.CellStatus;
import Models.Move;
import strategies.BotStrategy.BotPlayingStrategy;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    public Move suggestMove(Board board)
    {
        for(int i = 0; i<board.getBoard().size(); i++)
        {
            for(int j = 0; j<board.getBoard().size(); j++)
            {
                if(board.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.Empty))
                {
                    return new Move(board.getBoard().get(i).get(j));
                }
            }
        }
        return null;
    }
}
