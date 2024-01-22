package strategies.BotStrategy;

import Models.Board;
import Models.Move;

public interface BotPlayingStrategy {

    Move suggestMove(Board board);

}
