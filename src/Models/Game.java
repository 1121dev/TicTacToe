package Models;


import strategies.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;
    List<Player> players;
    List<Move>moves;
    int currentPlayerIndex;
    int dimension;
    GameState gameState;
    Player winner;
    List<WinningStrategy> winningStrategies;

    public Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies)
    {
        this.players = players;
        this.dimension = dimension;
        this.winningStrategies = winningStrategies;
        this.board = new Board(dimension);
        this.currentPlayerIndex = 0;
        this.moves = new ArrayList<>();
        this.gameState = GameState.In_Progress;
    }

    public GameState getGameState()
    {
        return this.gameState;
    }

    public void setGameState(GameState state)
    {
        this.gameState = state;
    }

    public void setWinner(Player player)
    {
        this.winner = player;
    }

    public void nextPlayerTurn()
    {
        //this.currentPlayerIndex++;
        this.currentPlayerIndex = (this.currentPlayerIndex+1)%this.players.size();
    }

    public void updateBoard(Move move)
    {
        Cell cell = move.getCell();

        this.board.getBoard().get(cell.getRow()).set(cell.getCol(),cell);
    }
    public static Builder getBuilder()
    {
        return new Builder();
    }

    public Player getCurrentPLayer()
    {
        return players.get(currentPlayerIndex);
    }

    public void addMove(Move move)
    {
        this.moves.add(move);
    }

//    public void makeMove()
//    {
//        Player currentPLayer = players.get(currentPlayerIndex);
//        Move move = currentPLayer.makeMove(board);
//        Cell cell = move.getCell();
//        this.board.getBoard().get(cell.getRow()).set(cell.getCol(),cell);
//        moves.add(move);
//        for(strategies.BotStrategy.WinningStrategy strategy : winningStrategies)
//        {
//            if(strategy.checkWinner(board,move))
//            {
//                gameState = GameState.Win;
//                System.out.printf("The player %s has won",currentPLayer.getName());
//                System.out.println();
//                break;
//            }
//        }
//        this.board.display();
//        currentPlayerIndex%=players.size();
//
//    }

    public List<WinningStrategy> getWinningStrategies() {
        return this.winningStrategies;
    }

    public Player getWinner() {
        return this.winner;
    }

    public static class Builder
    {
        List<Player>players;
        List<WinningStrategy>winningStrategies;
        int dimension;
        private Builder()
        {
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimension = 0;
        }
        public Builder setPlayer(List<Player>players)
        {
            this.players = players;
            return this;
        }
        public Builder setWinningStrategy(List<WinningStrategy>winningStrategies)
        {
            this.winningStrategies = winningStrategies;
            return this;
        }
        public Builder setDimension(int dimension)
        {
            this.dimension = dimension;
            return this;
        }

        public Builder addPlayer(Player player)
        {
            this.players.add(player);
            return this;
        }
        public Builder addWinningStrategies(WinningStrategy strategy)
        {
            this.winningStrategies.add(strategy);
            return this;
        }
        public Game build()
        {
            return new Game(dimension,players,winningStrategies);
        }



    }
    public Board getBoard()
    {
        return board;
    }

}
