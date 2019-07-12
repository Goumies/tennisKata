package dev.goumies.domain.scoring;

import dev.goumies.domain.sequence.TennisGame;
import dev.goumies.domain.sequence.TennisGameState;

public class ConsoleScoreBoard implements ScoreBoardFormat {

    private final TennisGame game;

    public ConsoleScoreBoard(TennisGame game) {
        this.game = game;
    }

    public String[] gameScore() {
        if(game.currentState().equals(TennisGameState.SETTING_UP)) {
            return new String[]{""};
        }
        if(game.currentState().equals(TennisGameState.STARTED)) {
            return new String[]{"GAME SCORE", game.lastAction(), "Player 1", "0", "Player 2", "0"};
        }
        if(game.currentState().equals(TennisGameState.WON)) {
            return new String[]{game.player1GameScore(), game.player2GameScore(), WinnerDeterminator.forThis(game)};
        }
        return new String[]{game.player1GameScore(), game.player2GameScore()};
    }

    @Override
    public String format(String[] gameScoreValues) {
        if(gameScoreValues.length == 1)
            return "";
        return "                                             GAME SCORE                                             \n" +
                "|                      |    "+ game.lastAction() +"Start the game    |\n" +
                "|----------------------|----------------------|\n" +
                "| Player 1             |          0           |\n" +
                "| Player 2             |          0           |\n" +
                "|----------------------|----------------------|\n" +
                "|                      |                      |\n"
                ;
    }
}
