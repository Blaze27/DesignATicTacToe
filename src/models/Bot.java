package models;

import enums.BotDifficultyLevel;
import enums.PlayerType;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, Character symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        setBotDifficultyLevel(botDifficultyLevel);
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevelEnum) {
        this.botDifficultyLevel = botDifficultyLevelEnum;
    }
    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }
}
