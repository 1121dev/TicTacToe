import Controllers.GameController;
import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();
        System.out.println("Lets begin TicTactoe ");
        System.out.println("Enter the dimension of the board you want");
        int dimension = sc.nextInt();
        System.out.println("Enter the number of players");
        int numberOfPLayers = sc.nextInt();
        System.out.println("Is there a bot - Y/N");
        String isBot = sc.next();
        int nonBotPlayers = numberOfPLayers;
        if(isBot.equals("Y"))
        {
            nonBotPlayers-=1;
        }
        List<Player> playerList = new ArrayList<>();
        for(int i = 0; i<nonBotPlayers; i++)
        {
            System.out.println("Enter the name of the player "+ i);
            String playerName = sc.next();
            System.out.println("Enter the symbol for the player");
            String symbol = sc.next();
            playerList.add(new Player(playerName,symbol.charAt(0),i,PlayerType.Human,sc));
        }
        if(isBot.equals("Y"))
        {
            System.out.println("Enter the name of the bot player ");
            String playerName = sc.next();
            System.out.println("Enter the symbol for the bot player");
            String symbol = sc.next();
            playerList.add(new Bot(playerName,symbol.charAt(0),playerList.size(),PlayerType.Bot,BotDifficultyLevel.Easy,sc));
        }
        Game game = gameController.createGame(dimension,playerList);

        while(gameController.getGameStatus(game).equals(GameState.In_Progress))
        {
            gameController.displayBoard(game);
            //System.out.println("Do you want to undo the last move - (Y/N)");
            System.out.println("Player turn : "+game.getCurrentPLayer().getName());
            gameController.executeNextMove(game);
        }

        if(gameController.getGameStatus(game).equals(GameState.Draw))
        {
            System.out.println("The match is Draw");
        }
        else
        {   gameController.displayBoard(game);
            System.out.println("The winner is "+gameController.getWinner(game).getName());
        }



    }
}