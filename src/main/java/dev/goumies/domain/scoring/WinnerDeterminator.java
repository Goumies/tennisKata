package dev.goumies.domain.scoring;

import dev.goumies.domain.sequence.TennisGame;
import dev.goumies.domain.sequence.TennisGameState;

interface WinnerDeterminator {
    static String forThis(TennisGame currentGame) {
        if(!currentGame.currentState().equals(TennisGameState.WON))
            return "";
        if(currentGame.hasPlayer1WithMaxPoints())
            return "Player 1 wins the game";
        return "Player 2 wins the game";
    }
}
