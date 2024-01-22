package Models;

import strategies.BotStrategy.BotPlayingStrategyFactory;
import strategies.BotStrategy.BotPlayingStrategy;

import java.util.Scanner;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;
    public Bot(String name, char symbol, int id, PlayerType playerType, BotDifficultyLevel botDifficultyLevel, Scanner sc) {
        super(name, symbol, id, playerType,sc);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = botPlayingStrategy = BotPlayingStrategyFactory.getBotPLayingStrategy(botDifficultyLevel);
    }

    public Move makeMove(Board board)
    {
        System.out.println("The bot is making a move");
        Move move =  botPlayingStrategy.suggestMove(board);
        if(move==null)
        {
            return null;
        }
        move.getCell().setPlayer(this);
        move.getCell().setCellStatus(CellStatus.Occupied);
        return move;
    }
}
