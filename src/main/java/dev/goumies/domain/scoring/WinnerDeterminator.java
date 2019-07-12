package dev.goumies.domain.scoring;

import dev.goumies.domain.sequence.TennisGame;

interface WinnerDeterminator {
    static String forThis(TennisGame currentGame) {
        return "Player 1 wins the game";
    }
}
