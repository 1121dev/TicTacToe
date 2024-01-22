package Services;
import Models.*;
import strategies.WinningStrategy.WinningStrategy;

public class GameService {

    Game game;
    public GameService(Game game)
    {
        this.game = game;
    }
    public void executeNextMove()
    {
        Player currentPlayer = game.getCurrentPLayer();
        Move move = currentPlayer.makeMove(game.getBoard());
        if(move==null)
        {
            game.setGameState(GameState.Draw);
            return;
        }
        game.updateBoard(move);
        game.addMove(move);
        for(WinningStrategy strategy : game.getWinningStrategies())
        {
            if(strategy.checkWinner(game.getBoard(),move))
            {
                game.setGameState(GameState.Win);
                game.setWinner(currentPlayer);
                System.out.printf("The player %s has won",currentPlayer.getName());
                System.out.println();
                break;
            }
        }
        //this.board.display();
        game.nextPlayerTurn();
    }
}
