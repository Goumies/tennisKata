package dev.goumies.domain.scoring;

import dev.goumies.domain.sequence.TennisGame;
import dev.goumies.domain.sequence.TennisGameState;

public class ConsoleScoreBoard {

    private final TennisGame game;

    public ConsoleScoreBoard(TennisGame game) {

        this.game = game;
    }

    public String[] gameScore() {
        if(game.currentState().equals(TennisGameState.SETTING_UP)) {
            return new String[]{""};
        }
        if(game.currentState().equals(TennisGameState.STARTED)) {
            return new String[]{"GAME SCORE", "Player1", "0", "Player2", "0"};
        }
        return new String[]{game.player1GameScore(), game.player2GameScore()};
    }
}
