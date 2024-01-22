package strategies.BotStrategy;

import Models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPLayingStrategy(BotDifficultyLevel level)
    {
        if(level.equals(BotDifficultyLevel.Medium))
        {
            return new MediumBotPlayingStrategy();
        }
        else if(level.equals(BotDifficultyLevel.Hard))
        {
            return new HardBotPlayingStrategy();
        }
        return new EasyBotPlayingStrategy();
    }
}
