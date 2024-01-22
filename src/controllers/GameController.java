package Controllers;
import java.util.List;

import Models.Board;
import Services.GameService;
import Models.Game;
import Models.GameState;
import Models.Player;
import strategies.WinningStrategy.ColWinningStrategy;
import strategies.WinningStrategy.RowWinningStrategy;

public class GameController {
    public Game createGame(int dimension, List<Player>playerList)
    {
        return Game.getBuilder().setPlayer(playerList)
                .setDimension(dimension).addWinningStrategies(new RowWinningStrategy())
                .addWinningStrategies(new ColWinningStrategy()).build();
    }
    public void undo()
    {

    }
    public void displayBoard(Game game)
    {
        Board board = game.getBoard();
        board.display();
    }
    public void executeNextMove(Game game)
    {
        GameService gameService = new GameService(game);
        gameService.executeNextMove();
    }
    public Player getWinner(Game game)
    {
        return game.getWinner();
    }

    public GameState getGameStatus(Game game) {
        return game.getGameState();
    }
}
